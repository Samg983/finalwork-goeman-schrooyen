/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.devices.HomeButton;
import be.finalwork.goemanschrooyen.devices.JoyStick;
import be.finalwork.goemanschrooyen.rapport.Rapport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SamGoeman
 */
@RestController
@RequestMapping("/Rapport")
public class RapportController {

    private static HomeButton button;
    private static JoyStick joystick;

    public RapportController() {
        button = new HomeButton();
        joystick = new JoyStick();

        Thread joystickThread = new Thread(joystick);
        joystickThread.start();
    }


    @RequestMapping("/getRapport")
    public Rapport getRapport() {
        Rapport rapport = new Rapport();
        System.out.println("BUTTON");

        System.out.println(button);

        rapport.setRapportCounter(button.getCounter());
        //rapport.setJoyStickX(5);
        return rapport;
    }

}