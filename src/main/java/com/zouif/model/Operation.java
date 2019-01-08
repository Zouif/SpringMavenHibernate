package com.zouif.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="Operation")
public class Operation {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="montant")
    private int montant;

    @Column(name="date_operation")
    private Date date;

    @ManyToOne
    @JoinColumn(name="expediteur")
    @JsonIgnore
    private Comptecourant compteExpediteur;

    @ManyToOne
    @JoinColumn(name = "destinataire")
    @JsonIgnore
    private Comptecourant compteDestinataire;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Comptecourant getCompteExpediteur() {
        return compteExpediteur;
    }

    public void setCompteExpediteur(Comptecourant compteExpediteur) {
        this.compteExpediteur = compteExpediteur;
    }

    public Comptecourant getCompteDestinataire() {
        return compteDestinataire;
    }

    public void setCompteDestinataire(Comptecourant compteDestinataire) {
        this.compteDestinataire = compteDestinataire;
    }

    @Override
    public String toString(){
        return null;
    }
}