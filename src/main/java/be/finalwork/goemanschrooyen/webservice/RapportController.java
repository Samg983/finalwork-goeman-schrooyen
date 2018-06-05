/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.devices.Button;
import be.finalwork.goemanschrooyen.devices.JoyStick;
import be.finalwork.goemanschrooyen.devices.Potmeter;
import be.finalwork.goemanschrooyen.observers.MyObserver;
import be.finalwork.goemanschrooyen.rapport.Rapport;
import com.pi4j.io.gpio.RaspiPin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SamGoeman
 */
@RestController
@RequestMapping("/Rapport")
public class RapportController {

    private static Button button, backLinks, backRechts, touchButton;
    private static JoyStick joystick;
    private static Potmeter pm;
    public static Rapport rapport;

    public RapportController() {
        rapport = new Rapport();
        
      /*  button = new Button(RaspiPin.GPIO_01, "");
        MyObserver buttonObserver = new MyObserver(button);
        
        backLinks = new Button(RaspiPin.GPIO_26, "left");
        MyObserver button2Observer = new MyObserver(backLinks);
        
        backRechts = new Button(RaspiPin.GPIO_27, "right");
        MyObserver button3Observer = new MyObserver(backRechts);
        
        touchButton = new Button(RaspiPin.GPIO_06, "touch");
        MyObserver touchButtonObserver = new MyObserver(touchButton);*/
    
        pm = new Potmeter();
        Thread potmeterThread = new Thread(pm);
        potmeterThread.start();
        
        /*joystick = new JoyStick();
        Thread joystickThread = new Thread(joystick); 
        joystickThread.start();*/
    }

    @RequestMapping("/getRapport")
    public Rapport getRapport() {
        return rapport;
    }
    
    @RequestMapping("/setZero")
    public void setZero() {
        rapport.setButtonCounter(0);
        rapport.setBackLeftCounter(0);
        rapport.setBackRightCounter(0);
        rapport.setTouchButtonCounter(0);
    }
    

}
