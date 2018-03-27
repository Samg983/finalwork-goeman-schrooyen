/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.AutoDao;
import be.finalwork.goemanschrooyen.dao.KlimaatDao;
import be.finalwork.goemanschrooyen.devices.HomeButton;
import be.finalwork.goemanschrooyen.devices.Potmeter;
import be.finalwork.goemanschrooyen.model.Auto;
import be.finalwork.goemanschrooyen.threads.TempThread;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author SamGoeman
 */
@RestController
@RequestMapping("/Auto")
public class AutoController {

    private RedirectView rv;
    private boolean isEmpty = true;

    //OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
    //Meestal wordt hier nog extra code rondgeschreven.
    //Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
    @RequestMapping("/getAll")
    public ArrayList<Auto> getAll() {
        // Aanroepen met
        // http://localhost:8080/Auto/getAll
        return AutoDao.getAutos();
    }

    @RequestMapping("/blink")
    public void blink() {
        // Aanroepen met
        // http://localhost:8080/Auto/getAll

        AutoDao.blink();
    }

    @RequestMapping("/lcd")
    public void lcd() {
        // Aanroepen met
        // http://localhost:8080/Auto/getAll
        AutoDao.blink();
    }

    @RequestMapping("/duw")
    public RedirectView duw() throws InterruptedException {

          HomeButton button = new HomeButton();
          
          return button.getRv();
    }

    @RequestMapping("/temp")
    public void temp() {
        Potmeter pm = new Potmeter();

        do {
            if (KlimaatDao.getKlimaatById(1).getTemperatuurLinks() != pm.readValue()) {
                System.out.println("NOT SAME");
                Runnable r = new TempThread(pm.readValue());
                new Thread(r).start();
            } else {
                System.out.println("SAME");
            }
        } while (true);

    }

 

    @RequestMapping("/getById")
    public Auto getById(@RequestParam(value = "autoId", defaultValue = "1") int kenmerkId) {
        // Aanroepen met
        // http://localhost:8080/Auto/getById?auteurId=2

        return AutoDao.getAutoById(kenmerkId);
    }

    @RequestMapping("/verwijderById")
    public int verwijderById(@RequestParam(value = "autoId", defaultValue = "1") int AutoId) {
        // Aanroepen met
        // http://localhost:8080/Auto/getById?auteurId=2

        return AutoDao.verwijderAuto(AutoId);
    }

    @RequestMapping(value = "/voegToe", method = RequestMethod.POST)
    public int voegToe(@RequestBody Auto nieuweAuto) {
        // Aanroepen met
        // http://localhost:8080/Auto/voegToe
        // Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
        // Content type van de POST request is application/json
        // Default constructor nodig bij Auto-klasse voor automatische omzetting van JSON naar objecten

        return AutoDao.voegAutoToe(nieuweAuto);
    }

}
