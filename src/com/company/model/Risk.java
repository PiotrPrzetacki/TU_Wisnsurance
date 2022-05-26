package com.company.model;

import java.sql.SQLException;
import java.util.Locale;
import java.util.UUID;

public class Risk {
    private UUID id;
    private Double priceFrom;
    private Double priceTo;
    private String description;
    private PolicyTypes policyType;

    public Risk(Double priceFrom, Double priceTo, String description, PolicyTypes policyType) {
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.description = description;
        this.policyType = policyType;
    }

    public Risk() {
        this.id = UUID.randomUUID();
    }

    public PolicyTypes getPolicyType() {
        return policyType;
    }

    public void save(){
        this.id = UUID.randomUUID();
        try {
            DBConnection.getStatement().execute(String.format(Locale.US,
                    "INSERT INTO risks VALUES ('%s', %f, %f, '%s', '%s')",
                    id.toString(),
                    priceFrom,
                    priceTo,
                    description,
                    policyType
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPriceFrom(Double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(Double priceTo) {
        this.priceTo = priceTo;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPolicyType(PolicyTypes policyType) {
        this.policyType = policyType;
    }
}
