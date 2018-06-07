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
    private int homeCounter, touchButtonCounter, backLeftCounter, backRightCounter;
    private int upRechtsCounter, downRechtsCounter, btnRechtsCounter, upLinksCounter, downLinksCounter, btnLinksCounter;
    private double temperatuurLinks;
    private int volume;
    
    public Rapport(){
        
    }


    public int getTouchButtonCounter() {
        return touchButtonCounter;
    }

    public void setTouchButtonCounter(int touchButtonCounter) {
        this.touchButtonCounter = touchButtonCounter;
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

    public int getHomeCounter() {
        return homeCounter;
    }

    public void setHomeCounter(int homeCounter) {
        this.homeCounter = homeCounter;
    }

    public int getUpRechtsCounter() {
        return upRechtsCounter;
    }

    public void setUpRechtsCounter(int upRechtsCounter) {
        this.upRechtsCounter = upRechtsCounter;
    }

    public int getDownRechtsCounter() {
        return downRechtsCounter;
    }

    public void setDownRechtsCounter(int downRechtsCounter) {
        this.downRechtsCounter = downRechtsCounter;
    }

    public int getBtnRechtsCounter() {
        return btnRechtsCounter;
    }

    public void setBtnRechtsCounter(int btnRechtsCounter) {
        this.btnRechtsCounter = btnRechtsCounter;
    }

    public int getUpLinksCounter() {
        return upLinksCounter;
    }

    public void setUpLinksCounter(int upLinksCounter) {
        this.upLinksCounter = upLinksCounter;
    }

    public int getDownLinksCounter() {
        return downLinksCounter;
    }

    public void setDownLinksCounter(int downLinksCounter) {
        this.downLinksCounter = downLinksCounter;
    }

    public int getBtnLinksCounter() {
        return btnLinksCounter;
    }

    public void setBtnLinksCounter(int btnLinksCounter) {
        this.btnLinksCounter = btnLinksCounter;
    }
   
}
