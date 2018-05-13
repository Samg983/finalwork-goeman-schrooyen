/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.observers;

import be.finalwork.goemanschrooyen.model.Model;
import static be.finalwork.goemanschrooyen.webservice.RapportController.rapport;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author SamGoeman
 */
public class MyObserver implements PropertyChangeListener {
    public MyObserver(Model model) {
        model.addChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        System.out.println("Changed property: " + e.getPropertyName() + " [old -> "
            + e.getOldValue() + "] | [new -> " + e.getNewValue() +"]");
        
        if(e.getPropertyName().equals("counterButton")){
            rapport.setRapportCounter((int) e.getNewValue());
        }
    }
    
    
}
