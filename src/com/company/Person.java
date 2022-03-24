package com.company;

public class Person extends Client{
    private String pesel;
    private String firstName;
    private String lastName;

    public Person(Integer id, String address, String phone, String pesel, String firstName, String lastName) {
        super(id, address, phone);
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
