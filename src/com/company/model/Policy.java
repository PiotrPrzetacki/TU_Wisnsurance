package com.company.model;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Policy {
    private UUID id;
    private Client policyholder;
    private Client insured;
    private Client beneficiary;
    private List<Risk> risks;
    private Date duration_from;
    private Date duration_to;
    private Double price;
    private PolicyTypes policyType;
    private Boolean isActive;

    public Policy() {
    }

    public Policy(Client policyholder, Client insured, Client beneficiary, List<Risk> risks, Date duration_from, Date duration_to, Double price, PolicyTypes policyType) {
        this.policyholder = policyholder;
        this.insured = insured;
        this.beneficiary = beneficiary;
        this.risks = risks;
        this.duration_from = duration_from;
        this.duration_to = duration_to;
        this.price = price;
        this.policyType = policyType;
        this.isActive = true;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPolicyholder(Client policyholder) {
        this.policyholder = policyholder;
    }

    public void setInsured(Client insured) {
        this.insured = insured;
    }

    public void setBeneficiary(Client beneficiary) {
        this.beneficiary = beneficiary;
    }

    public void setRisks(List<Risk> risks) {
        this.risks = risks;
    }

    public void setDuration_from(Date duration_from) {
        this.duration_from = duration_from;
    }

    public void setDuration_to(Date duration_to) {
        this.duration_to = duration_to;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPolicyType(PolicyTypes policyType) {
        this.policyType = policyType;
    }

    public Client getPolicyholder() {
        return policyholder;
    }

    public Client getInsured() {
        return insured;
    }

    public Client getBeneficiary() {
        return beneficiary;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public PolicyTypes getPolicyType() {
        return policyType;
    }

    public List<Risk> getAvailableRisks(List<Risk> risks){
        List<Risk> availableRisks = new ArrayList<>();
        for(Risk risk : risks){
            if(risk.getPolicyType() == this.getPolicyType()){
                availableRisks.add(risk);
            }
        }
        return availableRisks;
    }

    public void save(){
        this.id = UUID.randomUUID();
        String d_from = new SimpleDateFormat("yyyy-MM-dd").format(duration_from);
        String d_to = new SimpleDateFormat("yyyy-MM-dd").format(duration_to);
        try {
            DBConnection.getStatement().execute(String.format(Locale.US,
                    "INSERT INTO policies(id, policyholder_id, insured_id, beneficiary_id, duration_from, duration_to, price, policy_type) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %f, '%s')",
                    id,
                    policyholder.getId(),
                    insured.getId(),
                    beneficiary.getId(),
                    d_from,
                    d_to,
                    price,
                    policyType
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
