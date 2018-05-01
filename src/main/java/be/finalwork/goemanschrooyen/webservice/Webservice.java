/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;

import be.finalwork.goemanschrooyen.devices.HomeButton;
import be.finalwork.goemanschrooyen.observers.MyObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @author Maarten Heylen
 */
//@EnableAutoConfiguration

@SpringBootApplication
public class Webservice {
        public static void main(String[] args) {
        
       HomeButton button = new HomeButton();
     
       
       SpringApplication.run(Webservice.class, args);
    }
}
