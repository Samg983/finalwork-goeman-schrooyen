/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.devices;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import java.io.IOException;

/**
 *
 * @author SamGoeman
 */
public class JoyStick {
    private int x, y, down;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }
    
   
    
    public JoyStick() {
        try {
            I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);

            I2CDevice device = i2c.getDevice(0b1001000);
            
           
            
            /*device.write((byte) 0b1100011);
                  System.out.println("written");
                  Thread.sleep(500);
                   int value = device.read(0b1001000);
                    //Thread.sleep(800);
                    System.out.println("value: " + value);
                    
                    
                    klimaat.setTemperatuur(value);
                    KlimaatDao.updateKlimaat(klimaat);*/
            int i = 0;
            do {

                int btn = device.read(0b00000010);
                int x = device.read(0b00000001);
                int y = device.read(0b00000000);
                //int pot = device.read(0b00000011);

                if (x < 10) {
                    System.out.println("left: " + x);
                } else if (x > 250) {
                    System.out.println("right: " + x);
                }
                if (y < 10) {
                    System.out.println("down: " + y);
                } else if (y > 250) {
                    System.out.println("up: " + y);
                }
                if (btn == 0) {
                    System.out.println("Button: " + btn);
                }
                Thread.sleep(1000);
                /*if(KlimaatDao.getKlimaatById(1).getTemperatuurLinks() != pot){
                        System.out.println("NOT SAME");
                     Runnable r = new TempThread(pot);
                    new Thread(r).start();
                    } else {
                        System.out.println("SAME");
                    }*/

//                System.out.println("x: " + x);
//                System.out.println("y: " + y);
//                System.out.println("Btn: " + btn);
                //System.out.println("Pot: " + pot);

                i++;
            } while (true);

        } catch (IOException e) {
            System.out.println(e);
        } catch (UnsupportedBusNumberException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}
