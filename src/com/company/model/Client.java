package com.company.model;

import com.company.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public abstract class Client {
    private UUID id;
    private Address address;
    private String phone;

    public Client(Address address, String phone) {
        this.address = address;
        this.phone = phone;
    }

    public Client() {
        this.id = UUID.randomUUID();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Policy> getPolicies(List<Policy> allPolicies){
        List<Policy> clientPolicies = new ArrayList<>();

        for(Policy policy : allPolicies){
            if(policy.getPolicyholder() == this || policy.getInsured() == this || policy.getBeneficiary() == this){
                clientPolicies.add(policy);
            }
        }
        return clientPolicies;
    }

    public void cancelPolicy(Policy policy){
        if(policy.getPolicyholder() == this){
            policy.setActive(false);
        }
    }

    public void save(){
        try {
            ResultSet rs = DBConnection.getStatement().executeQuery("SELECT COUNT(*) FROM clients WHERE id='"+id+"'");
            rs.next();
            if(rs.getInt(1)==0) {
                this.id = UUID.randomUUID();
                DBConnection.getStatement().execute(String.format(Locale.US,
                        "INSERT INTO clients (id, address_id, phone) VALUES ('%s', '%s', '%s')",
                        id,
                        address.getId().toString(),
                        phone
                ));
            }
            else{
                DBConnection.getStatement().execute(String.format(Locale.US,
                        "UPDATE clients SET address_id='%s', phone='%s' WHERE id='%s'",
                        address.getId(),
                        phone,
                        id
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
