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
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Klimaat (temperatuurLinks, temperatuurRechts, ruitontdooiing, ventilatieSterkteLinks, ventilatieSterkteRechts, zetelverwarmingLinks, zetelverwarmingRechts) VALUES (?,?,?,?,?,?,?)", new Object[]{nieuweKlimaat.getTemperatuurLinks(), nieuweKlimaat.getTemperatuurRechts(), nieuweKlimaat.getRuitontdooiing(), nieuweKlimaat.getVentilatieSterkteLinks(), nieuweKlimaat.getVentilatieSterkteRechts(), nieuweKlimaat.getZetelverwarmingLinks(), nieuweKlimaat.getZetelverwarmingRechts()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateKlimaat(Klimaat nieuweKlimaat) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Klimaat SET temperatuurLinks = ?, temperatuurRechts = ?, ruitontdooiing = ?, ventilatieSterkteLinks = ?, ventilatieSterkteRechts = ?, zetelverwarmingLinks = ?, zetelverwarmingRechts = ? WHERE klimaatId = ?", new Object[]{nieuweKlimaat.getTemperatuurLinks(), nieuweKlimaat.getTemperatuurRechts(), nieuweKlimaat.getRuitontdooiing(), nieuweKlimaat.getVentilatieSterkteLinks(), nieuweKlimaat.getVentilatieSterkteRechts(), nieuweKlimaat.getZetelverwarmingLinks(), nieuweKlimaat.getZetelverwarmingRechts(), nieuweKlimaat.getKlimaatId()});
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
        return new Klimaat(mijnResultset.getInt("klimaatId"), mijnResultset.getDouble("temperatuurLinks"), mijnResultset.getDouble("temperatuurRechts"), mijnResultset.getBoolean("ruitontdooiing"), mijnResultset.getInt("ventilatieSterkteLinks"), mijnResultset.getInt("ventilatieSterkteRechts"), mijnResultset.getInt("zetelverwarmingLinks"), mijnResultset.getInt("zetelverwarmingRechts"));
    }
}
