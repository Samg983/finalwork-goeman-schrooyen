/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.rapport;

/**
 *
 * @author SamGoeman
 */
public class Rapport {
    private int rapportCounter;
    private int joyStickX;
    
    public Rapport(){
        
    }
    
    public int getRapportCounter(){
        return rapportCounter;
    }
    
    public void setRapportCounter(int rapportCounter){
        this.rapportCounter = rapportCounter;
    }
    
    public int getJoyStickX(){
        return this.joyStickX;
    }
    
    public void setJoyStickX(int joyStickX){
        this.joyStickX = joyStickX;
    }
}
