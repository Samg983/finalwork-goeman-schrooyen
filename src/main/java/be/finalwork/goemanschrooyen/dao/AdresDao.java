/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import java.sql.*;
import java.util.ArrayList;

import be.finalwork.goemanschrooyen.model.Adres;

/**
 *
 * @author SamGoeman
 */
public class AdresDao {

    public static ArrayList<Adres> getAdressen() {
        ArrayList<Adres> resultaat = new ArrayList<Adres>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Adres");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Adres huidigeAdres = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeAdres);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Adres getAdresById(int id) {
        Adres resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Adres where adresId = ?", new Object[]{id});
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

    public static int voegAdresToe(Adres nieuweAdres) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Adres (bestemming, isFavoriet) VALUES (?,?)", new Object[]{nieuweAdres.getBestemming(), nieuweAdres.getIsFavoriet()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateAdres(Adres nieuweAdres) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Adres SET bestemming = ?, isFavoriet = ? WHERE adresId = ?", new Object[]{nieuweAdres.getBestemming(), nieuweAdres.getIsFavoriet(), nieuweAdres.getAdresId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderAdres(int AdresId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Adres WHERE adresId = ?", new Object[]{AdresId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Adres converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Adres(mijnResultset.getInt("adresId"), mijnResultset.getString("bestemming"), mijnResultset.getBoolean("isFavoriet"));
    }
}
