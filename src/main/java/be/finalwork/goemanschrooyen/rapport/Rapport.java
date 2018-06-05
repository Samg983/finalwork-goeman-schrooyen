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
    private int buttonCounter, touchButtonCounter, backLeftCounter, backRightCounter;
    private int joyStickX;
    private double temperatuurLinks, temperatuurRechts;
    
    public Rapport(){
        
    }

    public int getButtonCounter() {
        return buttonCounter;
    }

    public void setButtonCounter(int buttonCounter) {
        this.buttonCounter = buttonCounter;
    }

    public int getTouchButtonCounter() {
        return touchButtonCounter;
    }

    public void setTouchButtonCounter(int touchButtonCounter) {
        this.touchButtonCounter = touchButtonCounter;
    }
   
    public int getJoyStickX(){
        return this.joyStickX;
    }
    
    public void setJoyStickX(int joyStickX){
        this.joyStickX = joyStickX;
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
        this.temperatuurRechts = temperatuurRechts;
    }

    public int getBackLeftCounter() {
        return backLeftCounter;
    }

    public void setBackLeftCounter(int backLeftCounter) {
        this.backLeftCounter = backLeftCounter;
    }

    public int getBackRightCounter() {
        return backRightCounter;
    }

    public void setBackRightCounter(int backRightCounter) {
        this.backRightCounter = backRightCounter;
    }
    
    
    
    
}
