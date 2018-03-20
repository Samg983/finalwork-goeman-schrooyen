/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.dao.AutoDao;
import be.finalwork.goemanschrooyen.dao.KlimaatDao;
import be.finalwork.goemanschrooyen.model.Auto;
import be.finalwork.goemanschrooyen.model.Klimaat;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;
import java.io.IOException;
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
@RequestMapping("/Auto")
public class AutoController {
	
	//OPMERKING: meestal wordt er niet zomaar doorverbonden naar methodes van de DAO
	//Meestal wordt hier nog extra code rondgeschreven.
	//Er moet ook aan security gedacht worden, een gebruiker zomaar toelaten alle gegevens uit de database te wissen is geen goed idee
	
	@RequestMapping("/getAll")
	public ArrayList<Auto> getAll() {
		// Aanroepen met
		// http://localhost:8080/Auto/getAll
		return AutoDao.getAutos();
	}
        
        @RequestMapping("/blink")
	public void blink() {
		// Aanroepen met
		// http://localhost:8080/Auto/getAll
		 AutoDao.blink();
	}
        
        @RequestMapping("/temp")
	public void temp()
        {
            System.out.println("Start temp");
            //Klimaat klimaat = KlimaatDao.getKlimaatById(1);
            
            
            try {
                 I2CBus i2c = I2CFactory.getInstance(I2CBus.BUS_1);

       
                  I2CDevice device = i2c.getDevice(0b1001000);
                  /*device.write((byte) 0b1100011);
                  System.out.println("written");
                  Thread.sleep(500);
                   int value = device.read(0b1001000);
                    //Thread.sleep(800);
                    System.out.println("value: " + value);
                    
                    
                    klimaat.setTemperatuur(value);
                    KlimaatDao.updateKlimaat(klimaat);*/
              int i = 0;
                do {
                    
                    /*int btn = device.read(0b00000010);
                    int x = device.read(0b00000001);
                    int y = device.read(0b00000000);*/
                    int pot = device.read(0b00000011);
                    
                    /* if (x < 10){ 
                        System.out.println("left: " + x);
                    } else if (x > 250){
                        System.out.println("right: " + x);
                    }
                    if (y < 10){
                        System.out.println("down: " + y);
                    } else if (y > 250){
                        System.out.println("up: " + y);
                    }
                    if (btn == 0){
                        System.out.println("Button: " + btn);
                    }*/
                    Thread.sleep(800);  
                    /*System.out.println("x: " + x);
                    System.out.println("y: " + y);
                    System.out.println("Btn: " + btn);*/
                    System.out.println("Pot: " + pot);
                    
                   i++; 
                } while(i < 100);
                
                 
            } catch (IOException e) {
                 System.out.println(e);
            } catch (UnsupportedBusNumberException e) {
                 System.out.println(e);
            }catch (InterruptedException e) {
                 System.out.println(e);
            }
		

	}
        
        

	@RequestMapping("/getById")
	public Auto getById(@RequestParam(value = "autoId", defaultValue = "1") int kenmerkId) {
		// Aanroepen met
		// http://localhost:8080/Auto/getById?auteurId=2

		return AutoDao.getAutoById(kenmerkId);
	}
        
        @RequestMapping("/verwijderById")
	public int verwijderById(@RequestParam(value = "autoId", defaultValue = "1") int AutoId) {
		// Aanroepen met
		// http://localhost:8080/Auto/getById?auteurId=2

		return AutoDao.verwijderAuto(AutoId);
	}
	
	@RequestMapping(value = "/voegToe", method = RequestMethod.POST)
	public int voegToe(@RequestBody Auto nieuweAuto) {
		// Aanroepen met
		// http://localhost:8080/Auto/voegToe
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Auto-klasse voor automatische omzetting van JSON naar objecten
		
		
		return AutoDao.voegAutoToe(nieuweAuto);
	}
	
}
