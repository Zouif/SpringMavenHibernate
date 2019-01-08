package com.zouif.model;

import javax.persistence.*;
import java.util.List;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private int id;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @OneToMany(mappedBy="client", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comptecourant> comptecourant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Comptecourant> getComptecourant() {
        return comptecourant;
    }

    public void setComptecourant(List<Comptecourant> comptecourant) {
        this.comptecourant = comptecourant;
    }

    @Override
    public String toString(){
        return "id="+id+", nom="+nom+", prenom="+prenom+", "+comptecourant.toString();
    }
}