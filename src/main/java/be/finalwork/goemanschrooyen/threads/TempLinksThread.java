/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.threads;

import be.finalwork.goemanschrooyen.dao.KlimaatDao;
import be.finalwork.goemanschrooyen.model.Klimaat;

/**
 *
 * @author root
 */
public class TempLinksThread implements Runnable{
    private final double value;
    
    public TempLinksThread(double p){
        this.value = p;
    }
    
    @Override
    public void run(){
        Klimaat klimaat = KlimaatDao.getKlimaatById(1);
        klimaat.setTemperatuurLinks(this.value);
        KlimaatDao.updateKlimaat(klimaat);    
    }
}
