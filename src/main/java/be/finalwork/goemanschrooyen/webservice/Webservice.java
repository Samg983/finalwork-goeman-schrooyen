/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.webservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author Maarten Heylen
 */

//@EnableAutoConfiguration

@SpringBootApplication
public class Webservice {

    public static void main(String[] args) {
        SpringApplication.run(Webservice.class, args);
    }
}
