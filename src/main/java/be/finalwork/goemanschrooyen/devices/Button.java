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

    private int backLeftCounter = 0;

    private int backRightCounter = 0;

    //
    private int upRechtsCounter = 0;

    private int btnRechtsCounter = 0;

    private int downRechtsCounter = 0;

    private int upLinksCounter = 0;

    private int btnLinksCounter = 0;

    private int downLinksCounter = 0;

    private String state;

    private Pin pin;

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

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        notifyListeners(this, "counterButton", this.counter, this.counter = counter);
    }

    public int getTouchCounter() {
        return touchCounter;
    }

    public void setTouchCounter(int touchCounter) {
        notifyListeners(this, "touchCounterButton", this.touchCounter, this.touchCounter = touchCounter);
    }

    public int getBackLeftCounter() {
        return backLeftCounter;
    }

    public void setBackLeftCounter(int backLeftCounter) {
        notifyListeners(this, "backLeftCounter", this.backLeftCounter, this.backLeftCounter = backLeftCounter);
    }

    public int getBackRightCounter() {
        return backRightCounter;
    }

    public void setBackRightCounter(int backRightCounter) {
        notifyListeners(this, "backRightCounter", this.backRightCounter, this.backRightCounter = backRightCounter);
    }

    public int getUpRechtsCounter() {
        return upRechtsCounter;
    }

    public void setUpRechtsCounter(int upRechtsCounter) {
        notifyListeners(this, "upRechtsCounter", this.upRechtsCounter, this.upRechtsCounter = upRechtsCounter);
    }

    public int getBtnRechtsCounter() {
        return btnRechtsCounter;
    }

    public void setBtnRechtsCounter(int btnRechtsCounter) {
        notifyListeners(this, "btnRechtsCounter", this.btnRechtsCounter, this.btnRechtsCounter = btnRechtsCounter);
    }

    public int getDownRechtsCounter() {
        return downRechtsCounter;
    }

    public void setDownRechtsCounter(int downRechtsCounter) {
        notifyListeners(this, "downRechtsCounter", this.downRechtsCounter, this.downRechtsCounter = downRechtsCounter);
    }

    public int getUpLinksCounter() {
        return upLinksCounter;
    }

    public void setUpLinksCounter(int upLinksCounter) {
        notifyListeners(this, "upLinksCounter", this.upLinksCounter, this.upLinksCounter = upLinksCounter);
    }

    public int getBtnLinksCounter() {
        return btnLinksCounter;
    }

    public void setBtnLinksCounter(int btnLinksCounter) {
        notifyListeners(this, "btnLinksCounter", this.btnLinksCounter, this.btnLinksCounter = btnLinksCounter);
    }

    public int getDownLinksCounter() {
        return downLinksCounter;
    }

    public void setDownLinksCounter(int downLinksCounter) {
        notifyListeners(this, "downLinksCounter", this.downLinksCounter, this.downLinksCounter = downLinksCounter);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Button(Pin pin, String state) {

        this.pin = pin;

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

                    if (state.equals("touch")) {
                        setTouchCounter(touchCounter + 1);
                    }
                }

                if (event.getState() == PinState.LOW) {
                    System.out.println("Pinstate LOW:" + isEmpty + ". Counter: " + counter);
                    if (state.equals("touch")) {
                        setTouchCounter(touchCounter + 1);
                    }

                    if (state.equals("backLeft")) {
                        setBackLeftCounter(backLeftCounter + 1);
                    }

                    if (state.equals("backRight")) {
                        setBackRightCounter(backRightCounter + 1);
                    }

                    if (state.equals("home")) {
                        setCounter(counter + 1);
                    }

                    if (state.equals("upRechtsCounter")) {
                        setUpRechtsCounter(upRechtsCounter + 1);
                    }

                    if (state.equals("btnRechtsCounter")) {
                        setBtnRechtsCounter(btnRechtsCounter + 1);
                    }

                    if (state.equals("downRechtsCounter")) {
                        setDownRechtsCounter(downRechtsCounter + 1);
                    }

                    if (state.equals("upLinksCounter")) {
                        setUpLinksCounter(upLinksCounter + 1);
                    }

                    if (state.equals("btnLinksCounter")) {
                        setBtnLinksCounter(btnLinksCounter + 1);
                    }
                    if (state.equals("downLinksCounter")) {
                        setDownLinksCounter(downLinksCounter + 1);
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
