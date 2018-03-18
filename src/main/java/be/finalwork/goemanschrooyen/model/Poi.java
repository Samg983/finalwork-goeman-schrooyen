/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

/**
 *
 * @author SamGoeman
 */
public class Poi {
    private int poiId;
    private String naam, soortPoi;
    private Double lat, lng;

    public int getPoiId() {
        return poiId;
    }

    public void setPoiId(int poiId) {
        this.poiId = poiId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getSoortPoi() {
        return soortPoi;
    }

    public void setSoortPoi(String soortPoi) {
        this.soortPoi = soortPoi;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Poi(int poiId, String naam, String soortPoi, Double lat, Double lng) {
        this.poiId = poiId;
        this.naam = naam;
        this.soortPoi = soortPoi;
        this.lat = lat;
        this.lng = lng;
    }
    
    public Poi(){
        
    }
}
