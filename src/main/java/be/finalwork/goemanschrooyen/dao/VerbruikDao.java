/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Verbruik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class VerbruikDao {
       public static ArrayList<Verbruik> getVerbruiken() {
        ArrayList<Verbruik> resultaat = new ArrayList<Verbruik>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verbruik");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Verbruik huidigeVerbruik = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeVerbruik);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Verbruik getVerbruikById(int id) {
        Verbruik resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Verbruik where verbruikId = ?", new Object[]{id});
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

    public static int voegVerbruikToe(Verbruik nieuweVerbruik) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Verbruik (brandstofNiveau, gemiddeldVerbruik) VALUES (?,?)", new Object[]{nieuweVerbruik.getBrandstofNiveau(), nieuweVerbruik.getGemiddeldVerbruik()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateVerbruik(Verbruik nieuweVerbruik) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Verbruik SET brandstofNiveau = ?, gemiddeldVerbruik = ? WHERE verbruikId = ?", new Object[]{nieuweVerbruik.getBrandstofNiveau(), nieuweVerbruik.getGemiddeldVerbruik(), nieuweVerbruik.getVerbruikId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderVerbruik(int VerbruikId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Verbruik WHERE verbruikId = ?", new Object[]{VerbruikId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Verbruik converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Verbruik(mijnResultset.getInt("verbruikId"), mijnResultset.getDouble("brandstofNiveau"), mijnResultset.getDouble("gemiddeldVerbruik"));
    }
}
