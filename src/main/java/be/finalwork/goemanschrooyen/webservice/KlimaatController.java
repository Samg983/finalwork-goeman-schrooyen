/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.KlimaatDao;
import be.finalwork.goemanschrooyen.model.Klimaat;
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
@RequestMapping("/Klimaat")
public class KlimaatController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Klimaat> getAll() {
		// Aanroepen met
		// http://localhost:8080/Klimaat/getAll
		return KlimaatDao.getKlimaten();
	}

	@RequestMapping("/getById")
	public Klimaat getById(@RequestParam(value = "klimaatId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Klimaat/getById?auteurId=2

		return KlimaatDao.getKlimaatById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "klimaatId", defaultValue = "1") int KlimaatId) {
		// Aanroepen met
		// http://localhost:8080/Klimaat/getById?auteurId=2

		return KlimaatDao.verwijderKlimaat(KlimaatId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Klimaat nieuweKlimaat) {
		// Aanroepen met
		// http://localhost:8080/Klimaat/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Klimaat-klasse voor automatische omzetting van JSON naar objecten
		
		
		return KlimaatDao.voegKlimaatToe(nieuweKlimaat);
	}
        
        @RequestMapping(value = "/update", method = RequestMethod.POST)
	public int update(@RequestBody Klimaat updateKlimaat) {
		// Aanroepen met
		// http://localhost:8080/Klimaat/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Klimaat-klasse voor automatische omzetting van JSON naar objecten
		
		
		return KlimaatDao.updateKlimaat(updateKlimaat);
	}
	
}
