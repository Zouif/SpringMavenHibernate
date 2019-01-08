package com.zouif.model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="Comptecourant")
public class Comptecourant extends Compte {

    @Column(name="decouvert")
    private int decouvert;

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

}