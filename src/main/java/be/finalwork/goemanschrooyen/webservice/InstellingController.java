/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.InstellingDao;
import be.finalwork.goemanschrooyen.model.Instelling;
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
@RequestMapping("/Instelling")
public class InstellingController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Instelling> getAll() {
		// Aanroepen met
		// http://localhost:8080/Instelling/getAll
		return InstellingDao.getInstellingen();
	}

	@RequestMapping("/getById")
	public Instelling getById(@RequestParam(value = "instellingId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Instelling/getById?auteurId=2

		return InstellingDao.getInstellingById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "instellingId", defaultValue = "1") int InstellingId) {
		// Aanroepen met
		// http://localhost:8080/Instelling/getById?auteurId=2

		return InstellingDao.verwijderInstelling(InstellingId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Instelling nieuweInstelling) {
		// Aanroepen met
		// http://localhost:8080/Instelling/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Instelling-klasse voor automatische omzetting van JSON naar objecten
		
		
		return InstellingDao.voegInstellingToe(nieuweInstelling);
	}
	
}