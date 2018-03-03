/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

/**
 *
 * @author SamGoeman
 */
public class Muzieknummer {
    private int muzieknummerId;
    private String naam, auteur, genre, locatie;

    public int getMuzieknummerId() {
        return muzieknummerId;
    }

    public void setMuzieknummerId(int muzieknummerId) {
        this.muzieknummerId = muzieknummerId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Muzieknummer(int muzieknummerId, String naam, String auteur, String genre, String locatie) {
        this.muzieknummerId = muzieknummerId;
        this.naam = naam;
        this.auteur = auteur;
        this.genre = genre;
        this.locatie = locatie;
    }
    
    public Muzieknummer(){
        
    }
    
}
