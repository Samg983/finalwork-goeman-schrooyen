/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.devices.HomeButton;
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

    private HomeButton button = new HomeButton();

    @RequestMapping("/getRapport")
    public Rapport getRapport() {
        Rapport rapport = new Rapport();
        rapport.setRapportCounter(button.getCounter());
        return rapport;
    }
    
}
