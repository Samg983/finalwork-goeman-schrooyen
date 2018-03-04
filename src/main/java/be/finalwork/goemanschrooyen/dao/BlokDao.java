/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Blok;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class BlokDao {
     public static ArrayList<Blok> getBlokken() {
        ArrayList<Blok> resultaat = new ArrayList<Blok>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Blok");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Blok huidigeBlok = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeBlok);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Blok getBlokById(int id) {
        Blok resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Blok where blokId = ?", new Object[]{id});
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

    public static int voegBlokToe(Blok nieuweBlok) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Blok (soort, positie) VALUES (?,?)", new Object[]{nieuweBlok.getSoort(), nieuweBlok.getPositie()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateBlok(Blok nieuweBlok) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Blok SET soort = ?, positie = ? WHERE blokId = ?", new Object[]{nieuweBlok.getSoort(), nieuweBlok.getPositie(), nieuweBlok.getBlokId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderBlok(int BlokId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Blok WHERE blokId = ?", new Object[]{BlokId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Blok converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Blok(mijnResultset.getInt("blokId"), mijnResultset.getString("soort"), mijnResultset.getInt("positie"));
    }
}
