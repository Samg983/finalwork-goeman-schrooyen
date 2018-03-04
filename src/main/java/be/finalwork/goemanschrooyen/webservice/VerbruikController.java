/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.VerbruikDao;
import be.finalwork.goemanschrooyen.model.Verbruik;
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
@RequestMapping("/Verbruik")
public class VerbruikController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Verbruik> getAll() {
		// Aanroepen met
		// http://localhost:8080/Verbruik/getAll
		return VerbruikDao.getVerbruiken();
	}

	@RequestMapping("/getById")
	public Verbruik getById(@RequestParam(value = "verbruikId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Verbruik/getById?auteurId=2

		return VerbruikDao.getVerbruikById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "verbruikId", defaultValue = "1") int VerbruikId) {
		// Aanroepen met
		// http://localhost:8080/Verbruik/getById?auteurId=2

		return VerbruikDao.verwijderVerbruik(VerbruikId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Verbruik nieuweVerbruik) {
		// Aanroepen met
		// http://localhost:8080/Verbruik/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Verbruik-klasse voor automatische omzetting van JSON naar objecten
		
		
		return VerbruikDao.voegVerbruikToe(nieuweVerbruik);
	}
	
}
