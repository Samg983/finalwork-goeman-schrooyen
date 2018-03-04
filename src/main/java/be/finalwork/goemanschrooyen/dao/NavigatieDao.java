/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Navigatie;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class NavigatieDao {
     public static ArrayList<Navigatie> getNavigaties() {
        ArrayList<Navigatie> resultaat = new ArrayList<Navigatie>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Navigatie");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Navigatie huidigeNavigatie = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeNavigatie);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Navigatie getNavigatieById(int id) {
        Navigatie resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Navigatie where navigatieId = ?", new Object[]{id});
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

    public static int voegNavigatieToe(Navigatie nieuweNavigatie) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Navigatie (lat, lng, snelwegenAan, tolwegenAan) VALUES (?,?,?,?)", new Object[]{nieuweNavigatie.getLat(), nieuweNavigatie.getLng(), nieuweNavigatie.getSnelwegenAan(), nieuweNavigatie.getTolwegenAan()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateNavigatie(Navigatie nieuweNavigatie) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Navigatie SET lat = ?, lng = ?, snelwegenAan = ?, tolwegenAan = ? WHERE navigatieId = ?", new Object[]{nieuweNavigatie.getLat(), nieuweNavigatie.getLng(), nieuweNavigatie.getSnelwegenAan(), nieuweNavigatie.getTolwegenAan(), nieuweNavigatie.getNavigatieId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderNavigatie(int NavigatieId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Navigatie WHERE navigatieId = ?", new Object[]{NavigatieId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Navigatie converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Navigatie(mijnResultset.getInt("navigatieId"), mijnResultset.getDouble("lat"), mijnResultset.getDouble("lng"), mijnResultset.getBoolean("snelwegenAan"), mijnResultset.getBoolean("tolwegenAan"));
    }
}
