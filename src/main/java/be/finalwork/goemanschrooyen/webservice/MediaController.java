/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.MediaDao;
import be.finalwork.goemanschrooyen.model.Media;
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
@RequestMapping("/Media")
public class MediaController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Media> getAll() {
		// Aanroepen met
		// http://localhost:8080/Media/getAll
		return MediaDao.getMedias();
	}

	@RequestMapping("/getById")
	public Media getById(@RequestParam(value = "mediaId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Media/getById?auteurId=2

		return MediaDao.getMediaById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "mediaId", defaultValue = "1") int MediaId) {
		// Aanroepen met
		// http://localhost:8080/Media/getById?auteurId=2

		return MediaDao.verwijderMedia(MediaId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Media nieuweMedia) {
		// Aanroepen met
		// http://localhost:8080/Media/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Media-klasse voor automatische omzetting van JSON naar objecten
		
		
		return MediaDao.voegMediaToe(nieuweMedia);
	}
	
}