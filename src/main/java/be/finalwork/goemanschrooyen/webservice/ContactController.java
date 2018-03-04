/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.ContactDao;
import be.finalwork.goemanschrooyen.model.Contact;
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
@RequestMapping("/Contact")
public class ContactController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Contact> getAll() {
		// Aanroepen met
		// http://localhost:8080/Contact/getAll
		return ContactDao.getContacten();
	}

	@RequestMapping("/getById")
	public Contact getById(@RequestParam(value = "contactId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Contact/getById?auteurId=2

		return ContactDao.getContactById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "contactId", defaultValue = "1") int ContactId) {
		// Aanroepen met
		// http://localhost:8080/Contact/getById?auteurId=2

		return ContactDao.verwijderContact(ContactId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Contact nieuweContact) {
		// Aanroepen met
		// http://localhost:8080/Contact/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Contact-klasse voor automatische omzetting van JSON naar objecten
		
		
		return ContactDao.voegContactToe(nieuweContact);
	}
	
}
