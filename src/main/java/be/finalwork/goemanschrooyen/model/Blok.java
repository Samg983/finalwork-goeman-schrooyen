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
public class Blok {
    private int blokId;
    private String soort;
    private int positie;

    public int getBlokId() {
        return blokId;
    }

    public void setBlokId(int blokId) {
        this.blokId = blokId;
    }

    public String getSoort() {
        return soort;
    }

    public void setSoort(String soort) {
        this.soort = soort;
    }

    public int getPositie() {
        return positie;
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }

    public Blok(int blokId, String soort, int positie) {
        this.blokId = blokId;
        this.soort = soort;
        this.positie = positie;
    }
    
    public Blok(){
        
    }
}
