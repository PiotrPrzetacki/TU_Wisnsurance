package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Client {
    protected Integer id;
    protected String address;
    protected String phone;

    public Client(Integer id, String address, String phone) {
        this.id = id;
        this.address = address;
        this.phone = phone;
    }

    public Policy addPolicy(Integer id, Client insured, Client beneficiary, List<Risk> risks, Date duration_from, Date duration_to, BigDecimal price, PolicyTypes policyType){
        return new Policy(id, this, insured, beneficiary, risks, duration_from, duration_to, price, policyType);
    }

    public List<Policy> getPolicies(List<Policy> allPolicies){
        List<Policy> clientPolicies = new ArrayList<>();

        for(Policy policy : allPolicies){
            if(policy.getPolicyholder() == this || policy.getInsured() == this || policy.getBeneficiary() == this){
                clientPolicies.add(policy);
            }
        }
        return clientPolicies;
    }

    public void cancelPolicy(Policy policy){
        if(policy.getPolicyholder() == this){
            policy.setActive(false);
        }
    }
}
