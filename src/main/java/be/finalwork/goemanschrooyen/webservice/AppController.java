/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.AppDao;
import be.finalwork.goemanschrooyen.model.App;
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
@RequestMapping("/App")
public class AppController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<App> getAll() {
		// Aanroepen met
		// http://localhost:8080/App/getAll
		return AppDao.getApps();
	}

	@RequestMapping("/getById")
	public App getById(@RequestParam(value = "appId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/App/getById?auteurId=2

		return AppDao.getAppById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "appId", defaultValue = "1") int AppId) {
		// Aanroepen met
		// http://localhost:8080/App/getById?auteurId=2

		return AppDao.verwijderApp(AppId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody App nieuweApp) {
		// Aanroepen met
		// http://localhost:8080/App/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij App-klasse voor automatische omzetting van JSON naar objecten
		
		
		return AppDao.voegAppToe(nieuweApp);
	}
	
}