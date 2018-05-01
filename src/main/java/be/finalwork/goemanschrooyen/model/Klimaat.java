/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SamGoeman
 */
public class Klimaat implements Model{
    private int klimaatId;
    private double temperatuurLinks, temperatuurRechts;
    private boolean ruitontdooiing;
    private int ventilatieSterkteLinks, ventilatieSterkteRechts, zetelverwarmingLinks, zetelverwarmingRechts;
    
    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();


    public int getKlimaatId() {
        return klimaatId;
    }

    public void setKlimaatId(int klimaatId) {
        this.klimaatId = klimaatId;
    }

    public double getTemperatuurLinks() {
        return temperatuurLinks;
    }

    public void setTemperatuurLinks(double temperatuurLinks) {
        this.temperatuurLinks = temperatuurLinks;
    }

    public double getTemperatuurRechts() {
        return temperatuurRechts;
    }

    public void setTemperatuurRechts(double temperatuurRechts) {
        notifyListeners(this, "TempRechts", this.temperatuurRechts, this.temperatuurRechts = temperatuurRechts); 
    }

    public boolean getRuitontdooiing() {
        return ruitontdooiing;
    }

    public void setRuitontdooiing(boolean ruitontdooiing) {
        this.ruitontdooiing = ruitontdooiing;
    }

    public int getVentilatieSterkteLinks() {
        return ventilatieSterkteLinks;
    }

    public void setVentilatieSterkteLinks(int ventilatieSterkteLinks) {
        this.ventilatieSterkteLinks = ventilatieSterkteLinks;
    }

    public int getVentilatieSterkteRechts() {
        return ventilatieSterkteRechts;
    }

    public void setVentilatieSterkteRechts(int ventilatieSterkteRechts) {
        this.ventilatieSterkteRechts = ventilatieSterkteRechts;
    }

    public int getZetelverwarmingLinks() {
        return zetelverwarmingLinks;
    }

    public void setZetelverwarmingLinks(int zetelverwarmingLinks) {
        this.zetelverwarmingLinks = zetelverwarmingLinks;
    }

    public int getZetelverwarmingRechts() {
        return zetelverwarmingRechts;
    }

    public void setZetelverwarmingRechts(int zetelverwarmingRechts) {
        this.zetelverwarmingRechts = zetelverwarmingRechts;
    }

    public Klimaat(int klimaatId, double temperatuurLinks, double temperatuurRechts, Boolean ruitontdooiing, int ventilatieSterkteLinks, int ventilatieSterkteRechts, int zetelverwarmingLinks, int zetelverwarmingRechts) {
        this.klimaatId = klimaatId;
        this.temperatuurLinks = temperatuurLinks;
        this.temperatuurRechts = temperatuurRechts;
        this.ruitontdooiing = ruitontdooiing;
        this.ventilatieSterkteLinks = ventilatieSterkteLinks;
        this.ventilatieSterkteRechts = ventilatieSterkteRechts;
        this.zetelverwarmingLinks = zetelverwarmingLinks;
        this.zetelverwarmingRechts = zetelverwarmingRechts;
    }

  
    
    public Klimaat(){
        
    }

    @Override
    public void notifyListeners(Object object, String property, double oldValue, double newValue) {
        for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    @Override
    public void notifyListeners(Object object, String property, int oldValue, int newValue) {
        for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    @Override
    public void notifyListeners(Object object, String property, String oldValue, String newValue) {
        for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    @Override
    public void notifyListeners(Object object, String property, boolean oldValue, boolean newValue) {
       for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    @Override
    public void addChangeListener(PropertyChangeListener newListener) {
        listener.add(newListener);
    }
    
    
}
