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
public class App {
    private int appId;
    private String naam, beschrijving;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public App(int appId, String naam, String beschrijving) {
        this.appId = appId;
        this.naam = naam;
        this.beschrijving = beschrijving;
    }
    
    public App(){
        
    }
}
