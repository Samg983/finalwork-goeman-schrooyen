/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Media;
import be.finalwork.goemanschrooyen.observers.MyObserver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class MediaDao {
     public static ArrayList<Media> getMedias() {
        ArrayList<Media> resultaat = new ArrayList<Media>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Media");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Media huidigeMedia = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeMedia);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Media getMediaById(int id) {
        Media resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Media where mediaId = ?", new Object[]{id});
            if (mijnResultset != null) {
                mijnResultset.first();
                resultaat = converteerHuidigeRijNaarObject(mijnResultset);
                MyObserver observer = new MyObserver(resultaat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static int voegMediaToe(Media nieuweMedia) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Media (volume) VALUES (?)", new Object[]{nieuweMedia.getVolume()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateMedia(Media nieuweMedia) {
        int aantalAangepasteRijen = 0;
        try {
              System.out.println("update media dao");
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Media SET volume = ? WHERE mediaId = ?", new Object[]{nieuweMedia.getVolume(), nieuweMedia.getMediaId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderMedia(int MediaId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Media WHERE mediaId = ?", new Object[]{MediaId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Media converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Media(mijnResultset.getInt("mediaId"), mijnResultset.getInt("volume"));
    }
}
