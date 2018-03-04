/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.AdresDao;
import be.finalwork.goemanschrooyen.model.Adres;
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
@RequestMapping("/Adres")
public class AdresController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Adres> getAll() {
		// Aanroepen met
		// http://localhost:8080/Adres/getAll
		return AdresDao.getAdressen();
	}

	@RequestMapping("/getById")
	public Adres getById(@RequestParam(value = "adresId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Adres/getById?auteurId=2

		return AdresDao.getAdresById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "adresId", defaultValue = "1") int AdresId) {
		// Aanroepen met
		// http://localhost:8080/Adres/getById?auteurId=2

		return AdresDao.verwijderAdres(AdresId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Adres nieuweAdres) {
		// Aanroepen met
		// http://localhost:8080/Adres/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Adres-klasse voor automatische omzetting van JSON naar objecten
		
		
		return AdresDao.voegAdresToe(nieuweAdres);
	}
	
}
