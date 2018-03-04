/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Radiozender;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class RadiozenderDao {
     public static ArrayList<Radiozender> getRadiozenders() {
        ArrayList<Radiozender> resultaat = new ArrayList<Radiozender>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Radiozender");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Radiozender huidigeRadiozender = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeRadiozender);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Radiozender getRadiozenderById(int id) {
        Radiozender resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Radiozender where radiozenderId = ?", new Object[]{id});
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

    public static int voegRadiozenderToe(Radiozender nieuweRadiozender) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Radiozender (naam, foto, frequentie) VALUES (?,?,?)", new Object[]{nieuweRadiozender.getNaam(), nieuweRadiozender.getFoto(), nieuweRadiozender.getFrequentie()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateRadiozender(Radiozender nieuweRadiozender) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Radiozender SET naam = ?, foto = ?, frequentie = ? WHERE radiozenderId = ?", new Object[]{nieuweRadiozender.getNaam(), nieuweRadiozender.getFoto(), nieuweRadiozender.getFrequentie(), nieuweRadiozender.getRadiozenderId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderRadiozender(int RadiozenderId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Radiozender WHERE radiozenderId = ?", new Object[]{RadiozenderId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Radiozender converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Radiozender(mijnResultset.getInt("radiozenderId"), mijnResultset.getString("naam"), mijnResultset.getString("foto"), mijnResultset.getDouble("frequentie"));
    }
}
