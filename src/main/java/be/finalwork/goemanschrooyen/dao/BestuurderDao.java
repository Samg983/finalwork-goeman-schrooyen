/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Bestuurder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class BestuurderDao {
    public static ArrayList<Bestuurder> getBestuurders() {
        ArrayList<Bestuurder> resultaat = new ArrayList<Bestuurder>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Bestuurder");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Bestuurder huidigeBestuurder = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeBestuurder);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Bestuurder getBestuurderById(int id) {
        Bestuurder resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Bestuurder where bestuurderId = ?", new Object[]{id});
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

    public static int voegBestuurderToe(Bestuurder nieuweBestuurder) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Bestuurder (naam) VALUES (?)", new Object[]{nieuweBestuurder.getNaam()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateBestuurder(Bestuurder nieuweBestuurder) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Bestuurder SET naam = ? WHERE bestuurderId = ?", new Object[]{nieuweBestuurder.getNaam(), nieuweBestuurder.getBestuurderId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderBestuurder(int BestuurderId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Bestuurder WHERE bestuurderId = ?", new Object[]{BestuurderId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Bestuurder converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Bestuurder(mijnResultset.getInt("bestuurderId"), mijnResultset.getString("naam"));
    }
}
