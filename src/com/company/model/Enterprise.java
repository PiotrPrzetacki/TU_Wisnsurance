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


}
