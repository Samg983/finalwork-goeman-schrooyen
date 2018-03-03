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
public class Klimaat {
    private int klimaatId;
    private double temperatuur;
    private Boolean ruitontdooiing;
    private int ventilatieSterkte, zetelverwarming;

    public int getKlimaatId() {
        return klimaatId;
    }

    public void setKlimaatId(int klimaatId) {
        this.klimaatId = klimaatId;
    }

    public double getTemperatuur() {
        return temperatuur;
    }

    public void setTemperatuur(double temperatuur) {
        this.temperatuur = temperatuur;
    }

    public Boolean getRuitontdooiing() {
        return ruitontdooiing;
    }

    public void setRuitontdooiing(Boolean ruitontdooiing) {
        this.ruitontdooiing = ruitontdooiing;
    }

    public int getVentilatieSterkte() {
        return ventilatieSterkte;
    }

    public void setVentilatieSterkte(int ventilatieSterkte) {
        this.ventilatieSterkte = ventilatieSterkte;
    }

    public int getZetelverwarming() {
        return zetelverwarming;
    }

    public void setZetelverwarming(int zetelverwarming) {
        this.zetelverwarming = zetelverwarming;
    }

    public Klimaat(int klimaatId, double temperatuur, Boolean ruitontdooiing, int ventilatieSterkte, int zetelverwarming) {
        this.klimaatId = klimaatId;
        this.temperatuur = temperatuur;
        this.ruitontdooiing = ruitontdooiing;
        this.ventilatieSterkte = ventilatieSterkte;
        this.zetelverwarming = zetelverwarming;
    }
    
    public Klimaat(){
        
    }
}
