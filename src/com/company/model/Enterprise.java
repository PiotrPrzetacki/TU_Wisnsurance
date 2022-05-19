package com.company.model;

public class Enterprise extends Client{
    private String nip;
    private String regon;
    private Person representative;

    public Enterprise(Address address, String phone, String nip, String regon, Person representative) {
        super(address, phone);
        this.nip = nip;
        this.regon = regon;
        this.representative = representative;
    }
}
