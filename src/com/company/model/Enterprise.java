package com.company.model;

import java.util.UUID;

public class Enterprise extends Client{
    private String nip;
    private String regon;
    private Person representative;
    private UUID enterpriseId;

    public Enterprise(Address address, String phone, String nip, String regon, Person representative) {
        super(address, phone);
        this.nip = nip;
        this.regon = regon;
        this.representative = representative;
    }

    public Enterprise() {
        super();
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public Person getRepresentative() {
        return representative;
    }

    public void setRepresentative(Person representative) {
        this.representative = representative;
    }

    public UUID getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(UUID enterpriseId) {
        this.enterpriseId = enterpriseId;
    }
}
