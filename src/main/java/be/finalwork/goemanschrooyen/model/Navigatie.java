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
public class Navigatie {
    private int navigatieId;
    private double lat, lng;
    private boolean snelwegenAan, tolwegenAan;

    public int getNavigatieId() {
        return navigatieId;
    }

    public void setNavigatieId(int navigatieId) {
        this.navigatieId = navigatieId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public boolean isSnelwegenAan() {
        return snelwegenAan;
    }

    public void setSnelwegenAan(boolean snelwegenAan) {
        this.snelwegenAan = snelwegenAan;
    }

    public boolean isTolwegenAan() {
        return tolwegenAan;
    }

    public void setTolwegenAan(boolean tolwegenAan) {
        this.tolwegenAan = tolwegenAan;
    }

    public Navigatie(int navigatieId, double lat, double lng, boolean snelwegenAan, boolean tolwegenAan) {
        this.navigatieId = navigatieId;
        this.lat = lat;
        this.lng = lng;
        this.snelwegenAan = snelwegenAan;
        this.tolwegenAan = tolwegenAan;
    }
    
    public Navigatie(){
        
    }
}
