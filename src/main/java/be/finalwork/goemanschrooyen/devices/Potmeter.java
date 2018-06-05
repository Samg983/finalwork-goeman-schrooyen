/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.devices;

import be.finalwork.goemanschrooyen.dao.KlimaatDao;
import be.finalwork.goemanschrooyen.dao.MediaDao;
import be.finalwork.goemanschrooyen.threads.TempLinksThread;
import be.finalwork.goemanschrooyen.threads.VolumeThread;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

import java.io.IOException;

/**
 *
 * @author SamGoeman
 */
public class Potmeter implements Runnable {

    //private List<Observer> observers = new ArrayList<Observer>();
    private int adres, potValue;
    private I2CDevice device;
    private int pot = 0;
    private String state;
    
    public int getAdres() {
        return adres;
    }
    
    public void setAdres(int adres) {
        this.adres = adres;
    }
    
    public int getPotValue() {
        return potValue;
    }
    
    public void setPotValue(int potValue) {
        this.potValue = potValue;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public Potmeter(int adres, String state) {
        System.out.println("New instance potmeter");
        this.state = state;
        this.adres = adres;
        try {
            I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);

            //this.device = i2c.getDevice(0b1001000);
            this.device = i2c.getDevice(this.adres);
            
        } catch (IOException e) {
            System.out.println(e);
        } catch (I2CFactory.UnsupportedBusNumberException e) {
            System.out.println(e);
        }
        
    }
    
    public int readValue() {
        //System.out.println("Potmeter read value");
        
        try {

//            pot = device.read(0b00000011);
//            System.out.println(pot);
//            Thread.slesep(100);
            pot = device.read(0b00000011);
            System.out.println(pot);
            Thread.sleep(100);
            
        } catch (InterruptedException | IOException e) {
            System.out.println(e);
        }
        
        return pot;
    }
    
    @Override
    public void run() {
        
        System.out.println("Potmeter read value");
        
        do {
            int potVal = this.readValue();
            
            if (this.state.equals("klimaat")) {
                if (KlimaatDao.getKlimaatById(1).getTemperatuurLinks() != potVal) {
                    System.out.println("Klimaat");
                    Runnable r = new TempLinksThread(potVal);
                    new Thread(r).start();
                }               
            } 
            
            if(this.state.equals("volume")){
                if (MediaDao.getMediaById(1).getVolume() != potVal) {
                    System.out.println("VOLUME");
                    Runnable r2 = new VolumeThread(potVal);
                    new Thread(r2).start();
                }  
            }
            
        } while (true);
    }
    
}
