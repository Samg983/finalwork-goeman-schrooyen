/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.BlokDao;
import be.finalwork.goemanschrooyen.model.Blok;
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
@RequestMapping("/Blok")
public class BlokController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Blok> getAll() {
		// Aanroepen met
		// http://localhost:8080/Blok/getAll
		return BlokDao.getBlokken();
	}

	@RequestMapping("/getById")
	public Blok getById(@RequestParam(value = "blokId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Blok/getById?auteurId=2

		return BlokDao.getBlokById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "blokId", defaultValue = "1") int BlokId) {
		// Aanroepen met
		// http://localhost:8080/Blok/getById?auteurId=2

		return BlokDao.verwijderBlok(BlokId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Blok nieuweBlok) {
		// Aanroepen met
		// http://localhost:8080/Blok/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Blok-klasse voor automatische omzetting van JSON naar objecten
		
		
		return BlokDao.voegBlokToe(nieuweBlok);
	}
	
}
