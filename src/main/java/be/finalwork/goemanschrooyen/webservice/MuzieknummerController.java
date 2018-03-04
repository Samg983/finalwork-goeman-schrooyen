/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.MuzieknummerDao;
import be.finalwork.goemanschrooyen.model.Muzieknummer;
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
@RequestMapping("/Muzieknummer")
public class MuzieknummerController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Muzieknummer> getAll() {
		// Aanroepen met
		// http://localhost:8080/Muzieknummer/getAll
		return MuzieknummerDao.getMuzieknummers();
	}

	@RequestMapping("/getById")
	public Muzieknummer getById(@RequestParam(value = "muzieknummerId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Muzieknummer/getById?auteurId=2

		return MuzieknummerDao.getMuzieknummerById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "muzieknummerId", defaultValue = "1") int MuzieknummerId) {
		// Aanroepen met
		// http://localhost:8080/Muzieknummer/getById?auteurId=2

		return MuzieknummerDao.verwijderMuzieknummer(MuzieknummerId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Muzieknummer nieuweMuzieknummer) {
		// Aanroepen met
		// http://localhost:8080/Muzieknummer/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Muzieknummer-klasse voor automatische omzetting van JSON naar objecten
		
		
		return MuzieknummerDao.voegMuzieknummerToe(nieuweMuzieknummer);
	}
	
}
