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

    private static Button button, button2, button3, backLinks, backRechts, touchButton;
    private static JoyStick joystick;
    private static Potmeter pm, pm2;
    public static Rapport rapport;

    public RapportController() {
        
        rapport = new Rapport();
        
        button = new Button(RaspiPin.GPIO_21, "");
        MyObserver buttonObserver = new MyObserver(button);
        
        button2 = new Button(RaspiPin.GPIO_04, "");
        MyObserver buttonObserver2 = new MyObserver(button2);
        
        button3 = new Button(RaspiPin.GPIO_05, "");
        MyObserver buttonObserver3 = new MyObserver(button3);
        
        /*backLinks = new Button(RaspiPin.GPIO_26, "left");
        MyObserver button2Observer = new MyObserver(backLinks);
        
        backRechts = new Button(RaspiPin.GPIO_27, "right");
        MyObserver button3Observer = new MyObserver(backRechts);
        
        touchButton = new Button(RaspiPin.GPIO_06, "touch");
        MyObserver touchButtonObserver = new MyObserver(touchButton);*/
    
        /*pm = new Potmeter(0b1001000, "klimaat");
        Thread potmeterThread = new Thread(pm);
        potmeterThread.start();
        
        pm2 = new Potmeter(0b1001001, "volume");
        Thread potmeterThread2 = new Thread(pm2);
        potmeterThread2.start();*/
        
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
