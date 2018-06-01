/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.devices;

import be.finalwork.goemanschrooyen.model.Model;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author SamGoeman
 */
public class HomeButton implements Model {

    private boolean isEmpty = true;
    private RedirectView rv;
    private int counter = 0;
    
    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public RedirectView getRv() {
        return rv;
    }

    public void setRv(RedirectView rv) {
        this.rv = rv;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        System.out.println("setCounter");
        notifyListeners(this, "counterButton", this.counter, this.counter = counter); 
    }

    public HomeButton() {
      
        
        System.out.println("Button aangemaakt");
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.PULL_DOWN);

        // set shutdown state for this input pin
        myButton.setShutdownOptions(true);

        // create and register gpio pin listener
        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                  System.out.println("Listener aangemaakt");
                if (event.getState() == PinState.HIGH) {
                    System.out.println("Pinstate HIGH:" + isEmpty);
                }

                if (event.getState() == PinState.LOW) {
                   
                    
                    setCounter(counter + 1);
                    System.out.println("Pinstate LOW:" + isEmpty + ". Counter: " + counter);

                }

            }
        });
    }

    
    
    
    
    
    /*private RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://samgoeman.com/rq/");
        return redirectView;
    }*/

    @Override
    public void notifyListeners(Object object, String property, double oldValue, double newValue) {
        listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void notifyListeners(Object object, String property, int oldValue, int newValue) {
        listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void notifyListeners(Object object, String property, String oldValue, String newValue) {
        listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void notifyListeners(Object object, String property, boolean oldValue, boolean newValue) {
         listener.forEach((name) -> {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        });
    }

    @Override
    public void addChangeListener(PropertyChangeListener newListener) {
         listener.add(newListener);
    }
}
