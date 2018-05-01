/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pi
 */
public class Auto implements Model {

    private int autoId, huidigeBestuurder;
    private Double snelheid;
    private Boolean schermAan;
    private Double kmStand;
    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

    //private I2CBus bus = I2CFactory.getInstance(0x1);
    //private I2CDevice devoce = bus.getDevice(0x48);
    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public Double getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(Double snelheid) {
        this.snelheid = snelheid;
    }

    public Boolean getSchermAan() {
        return schermAan;
    }

    public void setSchermAan(Boolean schermAan) {
        this.schermAan = schermAan;
    }

    public Double getKmStand() {
        return kmStand;
    }

    public void setKmStand(Double kmStand) {
        notifyListeners(this, "KMSTAND", this.kmStand, this.kmStand = kmStand);
        //this.kmStand = kmStand;
    }

    public int getHuidigeBestuurder() {
        return huidigeBestuurder;
    }

    public void setHuidigeBestuurder(int huidigeBestuurder) {
        this.huidigeBestuurder = huidigeBestuurder;
    }

    @Override
    public void notifyListeners(Object object, String property, double oldValue, double newValue) {
         for (PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    @Override
    public void addChangeListener(PropertyChangeListener newListener) {
         listener.add(newListener);
    }

    public Auto(int autoId, Double snelheid, Boolean schermAan, Double kmStand, int huidigeBestuurder) {
        this.autoId = autoId;
        this.snelheid = snelheid;
        this.schermAan = schermAan;
        this.kmStand = kmStand;
        this.huidigeBestuurder = huidigeBestuurder;
    }

    // Default constructor is nodig voor automatische omzetting van JSON naar
    // object
    public Auto() {

    }

    @Override
    public String toString() {
        return "Auto nr: " + this.autoId;
    }

    public static void blink() throws InterruptedException {

        System.out.println("<--Pi4J--> GPIO Control Example ... started.");

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000);

        // turn off gpio pin #01
        pin.low();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #01 (should turn on)
        pin.toggle();
        System.out.println("--> GPIO state should be: ON");

        Thread.sleep(5000);

        // toggle the current state of gpio pin #01  (should turn off)
        pin.toggle();
        System.out.println("--> GPIO state should be: OFF");

        Thread.sleep(5000);

        // turn on gpio pin #01 for 1 second and then off
        System.out.println("--> GPIO state should be: ON for only 1 second");
        pin.pulse(1000, true); // set second argument to 'true' use a blocking call

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
        gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");
    }

    public void pot() {
        /*try 
    {
        devoce.write((byte) (0x40 | (sensorId & 3)));
        devoce.read();
        buffer = (byte) devoce.read();
        unsignedValue = (short) ((short) 0x00FF & buffer);
    }
    catch (IOException e) 
    {
        logger.error("IOEXception " + e.getMessage() + " reading sensor " + sensorId);
        return false;
    }*/

    }
}
