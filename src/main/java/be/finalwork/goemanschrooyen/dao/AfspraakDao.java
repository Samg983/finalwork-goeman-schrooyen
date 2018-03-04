/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Afspraak;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class AfspraakDao {
    
    public static ArrayList<Afspraak> getAfspraken() {
        ArrayList<Afspraak> resultaat = new ArrayList<Afspraak>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Afspraak");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Afspraak huidigeAfspraak = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeAfspraak);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Afspraak getAfspraakById(int id) {
        Afspraak resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Afspraak where afspraakId = ?", new Object[]{id});
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

    public static int voegAfspraakToe(Afspraak nieuweAfspraak) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Afspraak (datum, beschrijving, uur, adres) VALUES (?,?,?,?)", new Object[]{nieuweAfspraak.getDatum(), nieuweAfspraak.getBeschrijving(), nieuweAfspraak.getUur(), nieuweAfspraak.getAdres()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateAfspraak(Afspraak nieuweAfspraak) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Afspraak SET datum = ?, beschrijving = ?, uur = ?, adres = ? WHERE afspraakId = ?", new Object[]{nieuweAfspraak.getDatum(), nieuweAfspraak.getBeschrijving(), nieuweAfspraak.getUur(), nieuweAfspraak.getAdres(), nieuweAfspraak.getAfspraakId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderAfspraak(int AfspraakId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Afspraak WHERE afspraakId = ?", new Object[]{AfspraakId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Afspraak converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Afspraak(mijnResultset.getInt("afspraakId"), mijnResultset.getString("datum"), mijnResultset.getString("beschrijving"), mijnResultset.getString("uur"), mijnResultset.getString("adres"));
    }
}
