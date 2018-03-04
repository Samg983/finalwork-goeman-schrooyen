/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.NavigatieDao;
import be.finalwork.goemanschrooyen.model.Navigatie;
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
@RequestMapping("/Navigatie")
public class NavigatieController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Navigatie> getAll() {
		// Aanroepen met
		// http://localhost:8080/Navigatie/getAll
		return NavigatieDao.getNavigaties();
	}

	@RequestMapping("/getById")
	public Navigatie getById(@RequestParam(value = "navigatieId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Navigatie/getById?auteurId=2

		return NavigatieDao.getNavigatieById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "navigatieId", defaultValue = "1") int NavigatieId) {
		// Aanroepen met
		// http://localhost:8080/Navigatie/getById?auteurId=2

		return NavigatieDao.verwijderNavigatie(NavigatieId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Navigatie nieuweNavigatie) {
		// Aanroepen met
		// http://localhost:8080/Navigatie/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Navigatie-klasse voor automatische omzetting van JSON naar objecten
		
		
		return NavigatieDao.voegNavigatieToe(nieuweNavigatie);
	}
	
}
