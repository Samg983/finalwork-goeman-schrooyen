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
public class Radiozender {
    private int radiozenderId;
    private String naam, foto;
    private double frequentie;

    public int getRadiozenderId() {
        return radiozenderId;
    }

    public void setRadiozenderId(int radiozenderId) {
        this.radiozenderId = radiozenderId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getFrequentie() {
        return frequentie;
    }

    public void setFrequentie(double frequentie) {
        this.frequentie = frequentie;
    }

    public Radiozender(int radiozenderId, String naam, String foto, double frequentie) {
        this.radiozenderId = radiozenderId;
        this.naam = naam;
        this.foto = foto;
        this.frequentie = frequentie;
    }
    
    public Radiozender(){
        
    }
}
