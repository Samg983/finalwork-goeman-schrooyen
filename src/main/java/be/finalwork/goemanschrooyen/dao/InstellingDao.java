/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Instelling;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class InstellingDao {
    
    public static ArrayList<Instelling> getInstellingen() {
        ArrayList<Instelling> resultaat = new ArrayList<Instelling>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Instelling");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Instelling huidigeInstelling = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeInstelling);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Instelling getInstellingById(int id) {
        Instelling resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Instelling where instellingId = ?", new Object[]{id});
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

    public static int voegInstellingToe(Instelling nieuweInstelling) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Instelling (isGebruikerInstelling, isAan, naam, categorie) VALUES (?,?,?,?)", new Object[]{nieuweInstelling.getIsGebruikerInstelling(), nieuweInstelling.getIsAan(), nieuweInstelling.getNaam(), nieuweInstelling.getCategorie()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateInstelling(Instelling nieuweInstelling) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Instelling SET isGebruikerInstelling = ?, isAan = ?, naam = ?, categorie = ? WHERE instellingId = ?", new Object[]{nieuweInstelling.getIsGebruikerInstelling(), nieuweInstelling.getIsAan(), nieuweInstelling.getNaam(), nieuweInstelling.getCategorie(), nieuweInstelling.getInstellingId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderInstelling(int InstellingId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Instelling WHERE instellingId = ?", new Object[]{InstellingId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Instelling converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Instelling(mijnResultset.getInt("instellingId"), mijnResultset.getBoolean("isGebruikerInstelling"), mijnResultset.getBoolean("isAan"), mijnResultset.getString("naam"), mijnResultset.getString("categorie"));
    }
}
