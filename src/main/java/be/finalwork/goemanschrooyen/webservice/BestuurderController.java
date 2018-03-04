/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.BestuurderDao;
import be.finalwork.goemanschrooyen.model.Bestuurder;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SamGoeman
 */
@RestController
@RequestMapping("/Bestuurder")
public class BestuurderController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Bestuurder> getAll() {
		// Aanroepen met
		// http://localhost:8080/Bestuurder/getAll
		return BestuurderDao.getBestuurders();
	}

	@RequestMapping("/getById")
	public Bestuurder getById(@RequestParam(value = "bestuurderId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Bestuurder/getById?auteurId=2

		return BestuurderDao.getBestuurderById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "bestuurderId", defaultValue = "1") int BestuurderId) {
		// Aanroepen met
		// http://localhost:8080/Bestuurder/getById?auteurId=2

		return BestuurderDao.verwijderBestuurder(BestuurderId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Bestuurder nieuweBestuurder) {
		// Aanroepen met
		// http://localhost:8080/Bestuurder/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Bestuurder-klasse voor automatische omzetting van JSON naar objecten
		
		
		return BestuurderDao.voegBestuurderToe(nieuweBestuurder);
	}
	
}
