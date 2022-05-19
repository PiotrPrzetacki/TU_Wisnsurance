package com.company.model;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

public abstract class Client {
    private UUID id;
    private Address address;
    private String phone;

    public Client(Address address, String phone) {
        this.id = UUID.randomUUID();
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Policy addPolicy(Integer id, Client insured, Client beneficiary, List<Risk> risks, Date duration_from, Date duration_to, BigDecimal price, PolicyTypes policyType){
        return new Policy(this, insured, beneficiary, risks, duration_from, duration_to, price, policyType);
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
            DBConnection.getStatement().execute(String.format(Locale.US,
                    "INSERT INTO clients (id, address_id, phone) VALUES ('%s', '%s', '%s')",
                    id.toString(),
                    address.getId().toString(),
                    phone
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
