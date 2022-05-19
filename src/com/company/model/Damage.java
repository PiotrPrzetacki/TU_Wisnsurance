package com.company.model;

import java.util.Set;
import java.util.UUID;

public class Damage {
    private UUID id;
    private Policy policy;
    private DamageTypes damageType;
    private Client victim;
    private Set<String> documents;

    public Damage(Integer id, Policy policy, DamageTypes damageType, Client victim) {
        this.id = UUID.randomUUID();
        this.policy = policy;
        this.damageType = damageType;
        this.victim = victim;
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

    public Set<String> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<String> documents) {
        this.documents = documents;
    }

    public void addDocument(String document){
        Set<String> newDocuments = this.getDocuments();
        newDocuments.add(document);
        this.setDocuments(newDocuments);
    }

    public void deleteDocument(String document){
        Set<String> documents = this.getDocuments();
        documents.remove(document);
        this.setDocuments(documents);
    }

}
