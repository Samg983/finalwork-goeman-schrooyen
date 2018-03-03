/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

/**
 *
 * @author pi
 */
public class Auto {
        private int autoId;
	private Double snelheid;
	private Boolean schermAan;
        private Double kmStand;

    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public Double getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(Double snelheid) {
        this.snelheid = snelheid;
    }

    public Boolean getSchermAan() {
        return schermAan;
    }

    public void setSchermAan(Boolean schermAan) {
        this.schermAan = schermAan;
    }

    public Double getKmStand() {
        return kmStand;
    }

    public void setKmStand(Double kmStand) {
        this.kmStand = kmStand;
    }

    public Auto(int autoId, Double snelheid, Boolean schermAan, Double kmStand) {
        this.autoId = autoId;
        this.snelheid = snelheid;
        this.schermAan = schermAan;
        this.kmStand = kmStand;
    }

    
	// Default constructor is nodig voor automatische omzetting van JSON naar
	// object
	public Auto() {

	}
	
        @Override
	public String toString(){
		return "Auto nr: " + this.autoId;
	}
}
