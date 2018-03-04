/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Klimaat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class KlimaatDao {
     public static ArrayList<Klimaat> getKlimaten() {
        ArrayList<Klimaat> resultaat = new ArrayList<Klimaat>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Klimaat");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Klimaat huidigeKlimaat = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeKlimaat);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Klimaat getKlimaatById(int id) {
        Klimaat resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Klimaat where klimaatId = ?", new Object[]{id});
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

    public static int voegKlimaatToe(Klimaat nieuweKlimaat) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Klimaat (temperatuur, ruitontdooiing, ventilatieSterkte, zetelverwarming) VALUES (?,?,?,?)", new Object[]{nieuweKlimaat.getTemperatuur(), nieuweKlimaat.getRuitontdooiing(), nieuweKlimaat.getVentilatieSterkte(), nieuweKlimaat.getZetelverwarming()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateKlimaat(Klimaat nieuweKlimaat) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Klimaat SET temperatuur = ?, ruitontdooiing = ?, ventilatieSterkte = ?, zetelverwarming = ? WHERE klimaatId = ?", new Object[]{nieuweKlimaat.getTemperatuur(), nieuweKlimaat.getRuitontdooiing(), nieuweKlimaat.getVentilatieSterkte(), nieuweKlimaat.getZetelverwarming(), nieuweKlimaat.getKlimaatId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderKlimaat(int KlimaatId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Klimaat WHERE klimaatId = ?", new Object[]{KlimaatId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Klimaat converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Klimaat(mijnResultset.getInt("klimaatId"), mijnResultset.getDouble("temperatuur"), mijnResultset.getBoolean("ruitontdooiing"), mijnResultset.getInt("ventilatieSterkte"), mijnResultset.getInt("zetelverwarming"));
    }
}
