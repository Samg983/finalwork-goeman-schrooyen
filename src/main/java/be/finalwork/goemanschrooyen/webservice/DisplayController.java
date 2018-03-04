/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.DisplayDao;
import be.finalwork.goemanschrooyen.model.Display;
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
@RequestMapping("/Display")
public class DisplayController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Display> getAll() {
		// Aanroepen met
		// http://localhost:8080/Display/getAll
		return DisplayDao.getDisplays();
	}

	@RequestMapping("/getById")
	public Display getById(@RequestParam(value = "displayId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Display/getById?auteurId=2

		return DisplayDao.getDisplayById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "displayId", defaultValue = "1") int DisplayId) {
		// Aanroepen met
		// http://localhost:8080/Display/getById?auteurId=2

		return DisplayDao.verwijderDisplay(DisplayId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Display nieuweDisplay) {
		// Aanroepen met
		// http://localhost:8080/Display/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Display-klasse voor automatische omzetting van JSON naar objecten
		
		
		return DisplayDao.voegDisplayToe(nieuweDisplay);
	}
	
}