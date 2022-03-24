package com.company;

import java.math.BigDecimal;

public class Risk {
    private Integer id;
    private BigDecimal price_from;
    private BigDecimal price_to;
    private String description;
    private PolicyTypes policyType;

    public Risk(Integer id, BigDecimal price_from, BigDecimal price_to, String description, PolicyTypes policyType) {
        this.id = id;
        this.price_from = price_from;
        this.price_to = price_to;
        this.description = description;
        this.policyType = policyType;
    }

    public PolicyTypes getPolicyType() {
        return policyType;
    }
}
