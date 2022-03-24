package com.company;

public class Enterprise extends Client{
    private String nip;
    private String regon;
    private Person representative;

    public Enterprise(Integer id, Address address, String phone, String nip, String regon, Person representative) {
        super(id, address, phone);
        this.nip = nip;
        this.regon = regon;
        this.representative = representative;
    }
}
