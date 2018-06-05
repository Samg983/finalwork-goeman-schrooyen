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
public class Media implements Model {
    private int mediaId;
    private int volume;
    
    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        notifyListeners(this, "volume", this.volume, this.volume = volume);
    }

    public Media(int mediaId, int volume) {
        this.mediaId = mediaId;
        this.volume = volume;
    }
    
    public Media(){
        
    }

    @Override
    public void notifyListeners(Object object, String property, double oldValue, double newValue) {
         listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void notifyListeners(Object object, String property, int oldValue, int newValue) {
        listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void notifyListeners(Object object, String property, String oldValue, String newValue) {
        listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void notifyListeners(Object object, String property, boolean oldValue, boolean newValue) {
         listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void addChangeListener(PropertyChangeListener newListener) {
         listener.add(newListener);
    }
    
    
}
