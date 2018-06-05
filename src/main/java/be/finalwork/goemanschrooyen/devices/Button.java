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
import com.pi4j.io.gpio.Pin;
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
public class Button implements Model {

    private boolean isEmpty = true;

    private int counter = 0;

    private int touchCounter = 0;

    private Pin pin;

    private boolean isTouch;

    private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public boolean getIsTouch() {
        return isTouch;
    }

    public void setIsTouch(boolean isTouch) {
        this.isTouch = isTouch;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        System.out.println("setCounter");
        notifyListeners(this, "counterButton", this.counter, this.counter = counter);
    }

    public int getTouchCounter() {
        return touchCounter;
    }

    public void setTouchCounter(int touchCounter) {
        notifyListeners(this, "touchCounterButton", this.touchCounter, this.touchCounter = touchCounter);
    }

    public Button(Pin pin, boolean touch) {

        this.pin = pin;
        this.isTouch = touch;

        System.out.println("Button aangemaakt");
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(pin, PinPullResistance.PULL_DOWN);

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
                    if (touch) {
                        System.out.println("TOUCH");
                        setTouchCounter(touchCounter + 1);
                    }
                }

                if (event.getState() == PinState.LOW) {
                    System.out.println("Pinstate LOW:" + isEmpty + ". Counter: " + counter);
                    if (touch) {
                        setTouchCounter(touchCounter + 1);
                    } else {
                        setCounter(counter + 1);
                    }
                }

            }
        });
    }

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