package com.company.model;

import java.sql.SQLException;
import java.util.Locale;
import java.util.UUID;

public class Address {

    private UUID id;
    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String buildingNumber;
    private String apartmentNumber;

    public Address(String country, String zipCode, String city, String street, String buildingNumber, String apartmentNumber) {
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }

    public UUID getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString(){
        String address = this.getZipCode() + " " +this.getCity() + ", " + this.getStreet() + " " + this.getApartmentNumber();
        address += this.getApartmentNumber() != null ? ("/"+this.getApartmentNumber()) : "";
        return address;
    }

    public void save(){
        this.id = UUID.randomUUID();
        try {
            DBConnection.getStatement().execute(String.format(Locale.US,
                    "INSERT INTO addresses VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    id,
                    country,
                    zipCode,
                    city,
                    street,
                    buildingNumber,
                    apartmentNumber
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
