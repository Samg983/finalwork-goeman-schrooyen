/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Muzieknummer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class MuzieknummerDao {
     public static ArrayList<Muzieknummer> getMuzieknummers() {
        ArrayList<Muzieknummer> resultaat = new ArrayList<Muzieknummer>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Muzieknummer");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Muzieknummer huidigeMuzieknummer = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeMuzieknummer);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Muzieknummer getMuzieknummerById(int id) {
        Muzieknummer resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Muzieknummer where muzieknummerId = ?", new Object[]{id});
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

    public static int voegMuzieknummerToe(Muzieknummer nieuweMuzieknummer) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Muzieknummer (naam, auteur, genre, locatie) VALUES (?,?,?,?)", new Object[]{nieuweMuzieknummer.getNaam(), nieuweMuzieknummer.getAuteur(), nieuweMuzieknummer.getGenre(), nieuweMuzieknummer.getLocatie()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateMuzieknummer(Muzieknummer nieuweMuzieknummer) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Muzieknummer SET naam = ?, auteur = ?, genre = ?, locatie = ? WHERE muzieknummerId = ?", new Object[]{nieuweMuzieknummer.getNaam(), nieuweMuzieknummer.getAuteur(), nieuweMuzieknummer.getGenre(), nieuweMuzieknummer.getLocatie(), nieuweMuzieknummer.getMuzieknummerId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderMuzieknummer(int MuzieknummerId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Muzieknummer WHERE muzieknummerId = ?", new Object[]{MuzieknummerId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Muzieknummer converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Muzieknummer(mijnResultset.getInt("muzieknummerId"), mijnResultset.getString("naam"), mijnResultset.getString("auteur"), mijnResultset.getString("genre"), mijnResultset.getString("locatie"));
    }
}
