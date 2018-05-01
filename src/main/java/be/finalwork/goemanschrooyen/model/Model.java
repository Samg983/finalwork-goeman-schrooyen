/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

import java.beans.PropertyChangeListener;

/**
 *
 * @author SamGoeman
 */
public interface Model {
   public void notifyListeners(Object object, String property, double oldValue, double newValue); 

   public void addChangeListener(PropertyChangeListener newListener); 
}
