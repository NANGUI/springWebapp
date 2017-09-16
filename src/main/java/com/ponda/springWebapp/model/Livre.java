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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author user
 */
@Entity
public class Livre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String isbn;
    private String editeur;
    @ManyToMany
    @JoinTable(name = "auteur_livre", joinColumns = @JoinColumn(name = "livre_id"),
            inverseJoinColumns = @JoinColumn(name = "auteur_id"))
    private Set<Auteur> auteurs = new HashSet<>();

    public Livre() {
    }

    public Livre(String titre, String isbn, String editeur) {
        this.titre = titre;
        this.isbn = isbn;
        this.editeur = editeur;
    }

    public Livre(String titre, String isbn, String editeur, Set<Auteur> auteurs) {
        this.titre = titre;
        this.isbn = isbn;
        this.editeur = editeur;
        this.auteurs = auteurs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Set<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(Set<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Livre other = (Livre) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", titre=" + titre + ", isbn=" + isbn + ", editeur=" + editeur + ", auteurs=" + auteurs + '}';
    }
    
    
}
