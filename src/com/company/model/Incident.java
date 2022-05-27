package com.company.model;

import com.company.DBConnection;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class Incident {
    private UUID id;
    private LocalDate date;
    private List<Damage> damages;
    private Address place;

    public Incident(Integer id, LocalDate date, List<Damage> damages, Address place) {
        this.date = date;
        this.damages = damages;
        this.place = place;
    }

    public Incident() {
    }

    public void save(){
        this.id = UUID.randomUUID();
        try {
            DBConnection.getStatement().execute(String.format(
                    "INSERT INTO incidents VALUES ('%s', '%s', '%s')",
                    id,
                    date,
                    place.getId()
            ));
            for(Damage damage : damages){
                DBConnection.getStatement().execute(String.format(Locale.US,
                        "INSERT INTO incidents_damages VALUES ('%s', '%s')",
                        id,
                        damage.getId()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public void setDamages(List<Damage> damages) {
        this.damages = damages;
    }

    public Address getPlace() {
        return place;
    }

    public void setPlace(Address place) {
        this.place = place;
    }
}
