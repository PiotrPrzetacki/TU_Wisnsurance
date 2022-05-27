package com.company.model;

import com.company.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class Damage {
    private UUID id;
    private Policy policy;
    private DamageTypes damageType;
    private Client victim;
    private Set<Document> documents;

    public Damage(Policy policy, DamageTypes damageType, Client victim, Set<Document> documents) {
        this.policy = policy;
        this.damageType = damageType;
        this.victim = victim;
        this.documents = documents;
    }

    public Damage() {
    }

    public void save(){
        try {
            ResultSet rs = DBConnection.getStatement().executeQuery("SELECT COUNT(*) FROM damages WHERE id='"+id+"'");
            rs.next();
            if(rs.getInt(1)==0) {
                this.id = UUID.randomUUID();
                DBConnection.getStatement().execute(String.format(
                        "INSERT INTO damages VALUES ('%s', '%s', '%s', '%s')",
                        id,
                        policy.getId(),
                        damageType,
                        victim.getId()
                ));
                for (Document document : documents) {
                    DBConnection.getStatement().execute(String.format(Locale.US,
                            "INSERT INTO damages_documents VALUES ('%s', '%s')",
                            id,
                            document.getId()
                    ));
                }
            }
            else{
                DBConnection.getStatement().execute(String.format(
                        "UPDATE damages SET policy_id='%s', damage_type='%s', victim_id='%s' WHERE id='%s'",
                        policy.getId(),
                        damageType,
                        victim.getId(),
                        id
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UUID getId() {
        return id;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public DamageTypes getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageTypes damageType) {
        this.damageType = damageType;
    }

    public Client getVictim() {
        return victim;
    }

    public void setVictim(Client victim) {
        this.victim = victim;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

}
