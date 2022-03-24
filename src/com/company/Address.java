package com.company;

public class Address {

    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String buildingNumber;
    private String apartment_Number;

    public Address(String country, String zipCode, String city, String street, String buildingNumber, String apartment_Number) {
        this.country = country;
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartment_Number = apartment_Number;
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

    public String getApartment_Number() {
        return apartment_Number;
    }

    public void setApartment_Number(String apartment_Number) {
        this.apartment_Number = apartment_Number;
    }

    @Override
    public String toString(){
        String address = this.getZipCode() + " " +this.getCity() + ", " + this.getStreet() + " " + this.getApartment_Number();
        address += this.getApartment_Number() != null ? ("/"+this.getApartment_Number()) : "";
        return address;
    }
}
