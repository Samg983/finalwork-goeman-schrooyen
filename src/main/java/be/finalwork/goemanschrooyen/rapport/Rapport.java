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
    private int xRechts, yRechts, btnRechts;
    private double temperatuurLinks;
    private int volume;
    
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

    public int getxRechts() {
        return xRechts;
    }

    public void setxRechts(int xRechts) {
        this.xRechts = xRechts;
    }

    public int getyRechts() {
        return yRechts;
    }

    public void setyRechts(int yRechts) {
        this.yRechts = yRechts;
    }

    public int getBtnRechts() {
        return btnRechts;
    }

    public void setBtnRechts(int btnRechts) {
        this.btnRechts = btnRechts;
    }
   

    public double getTemperatuurLinks() {
        return temperatuurLinks;
    }

    public void setTemperatuurLinks(double temperatuurLinks) {
        this.temperatuurLinks = temperatuurLinks;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
