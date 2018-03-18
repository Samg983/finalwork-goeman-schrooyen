/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Poi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class PoiDao {
    
    public static ArrayList<Poi> getPois() {
        ArrayList<Poi> resultaat = new ArrayList<Poi>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Poi");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Poi huidigePoi = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigePoi);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Poi getPoiById(int id) {
        Poi resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Poi where poiId = ?", new Object[]{id});
            if (mijnResultset != null) {
                mijnResultset.first();
                resultaat = converteerHuidigeRijNaarObject(mijnResultset);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static int voegPoiToe(Poi nieuwePoi) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Poi (naam, getSoortPoi, lat, lng) VALUES (?,?,?,?)", new Object[]{nieuwePoi.getNaam(), nieuwePoi.getSoortPoi(), nieuwePoi.getLat(), nieuwePoi.getLng()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updatePoi(Poi nieuwePoi) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Poi SET naam = ?, soortPoi = ?, lat = ?, lng = ? WHERE adresId = ?", new Object[]{nieuwePoi.getNaam(), nieuwePoi.getSoortPoi(), nieuwePoi.getLat(), nieuwePoi.getLng(), nieuwePoi.getPoiId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderPoi(int PoiId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Poi WHERE poiId = ?", new Object[]{PoiId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Poi converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Poi(mijnResultset.getInt("poiId"), mijnResultset.getString("naam"), mijnResultset.getString("soortPoi"), mijnResultset.getDouble("lat"), mijnResultset.getDouble("lng"));
    }
}
