package com.company.model;

import com.company.model.Address;
import com.company.model.Client;
import com.company.model.DBConnection;

import java.sql.SQLException;
import java.util.Locale;
import java.util.UUID;

public class Person extends Client {
    private UUID personId;
    private String pesel;
    private String firstName;
    private String lastName;

    public Person(Address address, String phone, String pesel, String firstName, String lastName) {
        super(address, phone);
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
        super();
        this.personId = UUID.randomUUID();
    }

    public void save(){
        super.save();
        this.personId = UUID.randomUUID();
        try {
            DBConnection.getStatement().execute(String.format(Locale.US,
                    "UPDATE clients SET person_id='%s' WHERE id='%s'",
                    personId.toString(),
                    getId().toString()
            ));
            DBConnection.getStatement().execute(String.format(Locale.US,
                    "INSERT INTO people (id, pesel, first_name, last_name) VALUES ('%s', '%s', '%s', '%s')",
                    personId.toString(),
                    pesel,
                    firstName,
                    lastName
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
