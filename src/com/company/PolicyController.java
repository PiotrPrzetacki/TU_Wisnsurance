package com.company;

import com.company.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PolicyController {

    public List<Policy> getAllPolicies() throws SQLException {
        List<Policy> policies = new ArrayList<>();
        ResultSet policiesRS = DBConnection.getStatement().executeQuery("SELECT * FROM policies");
        while (policiesRS.next()){
            Policy policy = new Policy();
            policy.setId(UUID.fromString(policiesRS.getString("id")));
            policy.setPolicyholder();
        }
    }

    public Client getClientById(UUID id) throws SQLException {
        ResultSet clientRS = DBConnection.getStatement().executeQuery(String.format(
                "SELECT * FROM clients WHERE id='%s'",
                id));
        clientRS.next();
        if(clientRS.getString("person_id")!=null){
            Person person = new Person();
            person.setId(UUID.fromString(clientRS.getString("id")));
            person.setAddress(getAddressById(UUID.fromString(clientRS.getString("address_id"))));
            person.setPhone(clientRS.getString("phone"));
            person.setPersonId(UUID.fromString(clientRS.getString("person_id")));

            Person p = getPersonById(person.getPersonId());
            person.setPesel(p.getPesel());
            person.setFirstName(p.getFirstName());
            person.setLastName(p.getLastName());
            return person;
        }
        else{
            Enterprise enterprise = new Enterprise();
            enterprise.setId(UUID.fromString(clientRS.getString("id")));
            enterprise.setAddress(getAddressById(UUID.fromString(clientRS.getString("address_id"))));
            enterprise.setPhone(clientRS.getString("phone"));
            enterprise.set(UUID.fromString(clientRS.getString("person_id")));
        }
    }

    public Person getPersonById(UUID id) throws SQLException {
        ResultSet personRS = DBConnection.getStatement().executeQuery(String.format(
                "SELECT * FROM people WHERE id='%s'",
                id));
        personRS.next();
        Person person = new Person();
        person.setPersonId(UUID.fromString(personRS.getString("id")));
        person.setPesel(personRS.getString("pesel"));
        person.setFirstName(personRS.getString("first_name"));
        person.setLastName(personRS.getString("last_name"));
        return person;
    }

    public Address getAddressById(UUID id) throws SQLException {
        ResultSet addressRS = DBConnection.getStatement().executeQuery(String.format(
                "SELECT * FROM clients WHERE id='%s'",
                id));
        addressRS.next();
        Address address = new Address(
                addressRS.getString("country"),
                addressRS.getString("zip_code"),
                addressRS.getString("city"),
                addressRS.getString("street"),
                addressRS.getString("building_number"),
                addressRS.getString("apartment_number")
        );
        address.setId(UUID.fromString(addressRS.getString("id")));
        return address;
    }
}
