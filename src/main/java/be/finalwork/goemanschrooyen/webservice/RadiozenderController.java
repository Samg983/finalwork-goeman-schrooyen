/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.RadiozenderDao;
import be.finalwork.goemanschrooyen.model.Radiozender;
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
@RequestMapping("/Radiozender")
public class RadiozenderController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Radiozender> getAll() {
		// Aanroepen met
		// http://localhost:8080/Radiozender/getAll
		return RadiozenderDao.getRadiozenders();
	}

	@RequestMapping("/getById")
	public Radiozender getById(@RequestParam(value = "radiozenderId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Radiozender/getById?auteurId=2

		return RadiozenderDao.getRadiozenderById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "radiozenderId", defaultValue = "1") int RadiozenderId) {
		// Aanroepen met
		// http://localhost:8080/Radiozender/getById?auteurId=2

		return RadiozenderDao.verwijderRadiozender(RadiozenderId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Radiozender nieuweRadiozender) {
		// Aanroepen met
		// http://localhost:8080/Radiozender/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Radiozender-klasse voor automatische omzetting van JSON naar objecten
		
		
		return RadiozenderDao.voegRadiozenderToe(nieuweRadiozender);
	}
	
}
