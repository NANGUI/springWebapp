/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ponda.springWebapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author user
 */
@Entity
public class Auteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 
    private String prenom;
    private String nom;
    @ManyToMany(mappedBy = "auteurs")
    private Set<Livre> livres = new HashSet<>();

    public Auteur() {
    }

    public Auteur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
    
    public Auteur(String prenom, String nom, Set<Livre> livres) {
        this.prenom = prenom;
        this.nom = nom;
        this.livres = livres;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auteur other = (Auteur) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Auteur{" + "id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", livres=" + livres + '}';
    }

    
}
