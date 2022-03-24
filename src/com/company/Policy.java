package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Policy {
    private Integer id;
    private Client policyholder;
    private Client insured;
    private Client beneficiary;
    private List<Risk> risks;
    private Date duration_from;
    private Date duration_to;
    private BigDecimal price;
    private PolicyTypes policyType;
    private Boolean isActive;

    public Policy(Integer id, Client policyholder, Client insured, Client beneficiary, List<Risk> risks, Date duration_from, Date duration_to, BigDecimal price, PolicyTypes policyType) {
        this.id = id;
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
}
