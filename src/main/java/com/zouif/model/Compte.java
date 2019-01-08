package com.zouif.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@MappedSuperclass
public abstract class Compte {

    @Id
    @GeneratedValue
    @Column(name="numero")
    private long numero;

    @Column(name="intitule")
    private String intitule;

    @Column(name="solde")
    private int solde;

    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonIgnore
    private Client client;

    @OneToMany(mappedBy = "compteExpediteur")
    private List<Operation> operationsExpediteur;

    @OneToMany(mappedBy = "compteDestinataire")
    private List<Operation> operationsDestinataire;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @JsonIgnore
    public List<Operation> getOperationsExpediteur() {
        return operationsExpediteur;
    }

    public void setOperationsExpediteur(List<Operation> operationsExpediteur) {
        this.operationsExpediteur = operationsExpediteur;
    }

    @JsonIgnore
    public List<Operation> getOperationsDestinataire() {
        return operationsDestinataire;
    }

    public void setOperationsDestinataire(List<Operation> operationsDestinataire) {
        this.operationsDestinataire = operationsDestinataire;
    }

    public Set<Operation> getOperations() {

        Set<Operation> operations = new HashSet<>();
        operations.addAll(this.operationsExpediteur);
        operations.addAll(this.operationsDestinataire);
        return operations;
    }

    @Override
    public String toString(){
        return "numero="+numero+", intitule="+intitule+", solde="+solde;
    }
}
