package com.company.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Incident {
    private UUID id;
    private Date date;
    private List<Damage> damages;
    private String place;

    public Incident(Integer id, Date date, List<Damage> damages, String place) {
        this.date = date;
        this.damages = damages;
        this.place = place;
    }

    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public void setDamages(List<Damage> damages) {
        this.damages = damages;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
