/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.observers;

import be.finalwork.goemanschrooyen.devices.Potmeter;

/**
 *
 * @author SamGoeman
 */
public abstract class PotValueObserver {
   protected Potmeter subject;
   public abstract void update();
}
