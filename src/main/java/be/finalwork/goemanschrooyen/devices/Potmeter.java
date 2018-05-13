/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.devices;

import be.finalwork.goemanschrooyen.dao.KlimaatDao;
import be.finalwork.goemanschrooyen.threads.TempThread;
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

    public Potmeter() {
        System.out.println("New instance potmeter");
        try {
            I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);

            this.device = i2c.getDevice(0b1001000);

        } catch (IOException e) {
            System.out.println(e);
        } catch (I2CFactory.UnsupportedBusNumberException e) {
            System.out.println(e);
        }

    }

    public int readValue() {
        //System.out.println("Potmeter read value");
        int pot = 0;
        try {

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
        //System.out.println("Potmeter read value");
        
        do {
            int pot = this.readValue();
            if (KlimaatDao.getKlimaatById(1).getTemperatuurLinks() != pot) {
                System.out.println("NOT SAME");
                Runnable r = new TempThread(pot);
                new Thread(r).start();
            } else {
                System.out.println("SAME");
            }
        } while (true);
    }

}
