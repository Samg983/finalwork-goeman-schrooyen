/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.AfspraakDao;
import be.finalwork.goemanschrooyen.model.Afspraak;
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
@RequestMapping("/Afspraak")
public class AfspraakController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Afspraak> getAll() {
		// Aanroepen met
		// http://localhost:8080/Afspraak/getAll
		return AfspraakDao.getAfspraken();
	}

	@RequestMapping("/getById")
	public Afspraak getById(@RequestParam(value = "afspraakId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Afspraak/getById?auteurId=2

		return AfspraakDao.getAfspraakById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "afspraakId", defaultValue = "1") int AfspraakId) {
		// Aanroepen met
		// http://localhost:8080/Afspraak/getById?auteurId=2

		return AfspraakDao.verwijderAfspraak(AfspraakId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Afspraak nieuweAfspraak) {
		// Aanroepen met
		// http://localhost:8080/Afspraak/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Afspraak-klasse voor automatische omzetting van JSON naar objecten
		
		
		return AfspraakDao.voegAfspraakToe(nieuweAfspraak);
	}
	
}
