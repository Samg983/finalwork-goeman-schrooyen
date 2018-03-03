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
public class Display {
    private int displayId;
    private String modus;

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
    }

    public String getModus() {
        return modus;
    }

    public void setModus(String modus) {
        this.modus = modus;
    }

    public Display(int displayId, String modus) {
        this.displayId = displayId;
        this.modus = modus;
    }
    
    public Display(){
        
    }
}
