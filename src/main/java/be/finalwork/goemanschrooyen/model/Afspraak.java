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
public class Afspraak {
    private int afspraakId;
    private String datum, beschrijving, uur, adres;

    public int getAfspraakId() {
        return afspraakId;
    }

    public void setAfspraakId(int afspraakId) {
        this.afspraakId = afspraakId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getUur() {
        return uur;
    }

    public void setUur(String uur) {
        this.uur = uur;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Afspraak(int afspraakId, String datum, String beschrijving, String uur, String adres) {
        this.afspraakId = afspraakId;
        this.datum = datum;
        this.beschrijving = beschrijving;
        this.uur = uur;
        this.adres = adres;
    }
    
    public Afspraak(){
        
    }
}
