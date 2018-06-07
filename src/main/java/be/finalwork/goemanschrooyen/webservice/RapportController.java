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

    private static Button upRechts, btnRechts, downRechts, upLinks, btnLinks, downLinks, backLeft, backRight, home, touchButton;
    private static Potmeter pm, pm2;
    public static Rapport rapport;

    public RapportController() {
        
        rapport = new Rapport();
        
        upRechts = new Button(RaspiPin.GPIO_21, "upRechtsCounter");
        MyObserver buttonObserver = new MyObserver(upRechts);
        
        btnRechts = new Button(RaspiPin.GPIO_04, "btnRechtsCounter");
        MyObserver buttonObserver2 = new MyObserver(btnRechts);
        
        downRechts = new Button(RaspiPin.GPIO_05, "downRechtsCounter");
        MyObserver buttonObserver3 = new MyObserver(downRechts);
        
       ////
        upLinks = new Button(RaspiPin.GPIO_23, "upLinksCounter");
        MyObserver buttonObserver4 = new MyObserver(upLinks);
        
        btnLinks = new Button(RaspiPin.GPIO_24, "btnLinksCounter");
        MyObserver buttonObserver5 = new MyObserver(btnLinks);
        
        downLinks = new Button(RaspiPin.GPIO_25, "downLinksCounter");
        MyObserver buttonObserver6 = new MyObserver(downLinks);
        /////
        
        backLeft = new Button(RaspiPin.GPIO_26, "backLeft");
        MyObserver buttonObserver7 = new MyObserver(backLeft);
        
        backRight = new Button(RaspiPin.GPIO_27, "backRight");
        MyObserver buttonObserver8 = new MyObserver(backRight);
        
        home = new Button(RaspiPin.GPIO_01, "home");
        MyObserver buttonObserver9 = new MyObserver(home);
        
       
        touchButton = new Button(RaspiPin.GPIO_06, "touch");
        MyObserver touchButtonObserver = new MyObserver(touchButton);
    
        pm = new Potmeter(0b1001000, "klimaat");
        Thread potmeterThread = new Thread(pm);
        potmeterThread.start();
        
        pm2 = new Potmeter(0b1001001, "volume");
        Thread potmeterThread2 = new Thread(pm2);
        potmeterThread2.start();
        
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
        rapport.setBackLeftCounter(0);
        rapport.setBackRightCounter(0);
        rapport.setTouchButtonCounter(0);
        rapport.setBtnLinksCounter(0);
        rapport.setBtnRechtsCounter(0);
        rapport.setUpLinksCounter(0);
        rapport.setUpRechtsCounter(0);
        rapport.setDownLinksCounter(0);
        rapport.setUpLinksCounter(0);
        rapport.setHomeCounter(0);
    }
    

}
