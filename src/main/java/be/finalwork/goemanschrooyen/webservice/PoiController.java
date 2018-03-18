/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.PoiDao;
import be.finalwork.goemanschrooyen.model.Poi;
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
@RequestMapping("/Poi")
public class PoiController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Poi> getAll() {
		// Aanroepen met
		// http://localhost:8080/Poi/getAll
		return PoiDao.getPois();
	}

	@RequestMapping("/getById")
	public Poi getById(@RequestParam(value = "poiId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Poi/getById?auteurId=2

		return PoiDao.getPoiById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "poiId", defaultValue = "1") int PoiId) {
		// Aanroepen met
		// http://localhost:8080/Poi/getById?auteurId=2

		return PoiDao.verwijderPoi(PoiId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Poi nieuwePoi) {
		// Aanroepen met
		// http://localhost:8080/Poi/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Poi-klasse voor automatische omzetting van JSON naar objecten
		
		
		return PoiDao.voegPoiToe(nieuwePoi);
	}
	
}
