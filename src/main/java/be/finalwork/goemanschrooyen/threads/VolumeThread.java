/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.threads;

import be.finalwork.goemanschrooyen.dao.KlimaatDao;
import be.finalwork.goemanschrooyen.dao.MediaDao;
import be.finalwork.goemanschrooyen.model.Media;

/**
 *
 * @author root
 */
public class VolumeThread implements Runnable{
    private final int value;
    
    public VolumeThread(int p){
        this.value = p;
    }
    
    @Override
    public void run(){
        Media media = MediaDao.getMediaById(1);
        media.setVolume(this.value);
        MediaDao.updateMedia(media);    
    }
}
