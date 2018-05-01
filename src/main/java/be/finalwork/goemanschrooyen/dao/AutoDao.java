/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Auto;
import be.finalwork.goemanschrooyen.observers.MyObserver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class AutoDao {
     public static ArrayList<Auto> getAutos() {
        ArrayList<Auto> resultaat = new ArrayList<Auto>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Auto");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Auto huidigeAuto = converteerHuidigeRijNaarObject(mijnResultset);
                    MyObserver observer = new MyObserver(huidigeAuto);
                    resultaat.add(huidigeAuto);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Auto getAutoById(int id) {
        Auto resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Auto where autoId = ?", new Object[]{id});
            if (mijnResultset != null) {
                mijnResultset.first();
                resultaat = converteerHuidigeRijNaarObject(mijnResultset);
                MyObserver observer = new MyObserver(resultaat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static int voegAutoToe(Auto nieuweAuto) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Auto (snelheid, schermAan, kmStand, huidigeBestuurder) VALUES (?,?,?,?)", new Object[]{nieuweAuto.getSnelheid(), nieuweAuto.getSchermAan() , nieuweAuto.getKmStand(), nieuweAuto.getHuidigeBestuurder()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateAuto(Auto nieuweAuto) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Auto SET snelheid = ?, schermAan = ?, kmStand = ? huidigeBestuurder = ? WHERE autoId = ?", new Object[]{nieuweAuto.getSnelheid(), nieuweAuto.getSchermAan(),  nieuweAuto.getKmStand(), nieuweAuto.getHuidigeBestuurder(),nieuweAuto.getAutoId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderAuto(int AutoId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Auto WHERE autoId = ?", new Object[]{AutoId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }
    
    public static void blink(){
        try{
            Auto.blink();
        } catch(InterruptedException e) {
            
        }
        
    }

    private static Auto converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Auto(mijnResultset.getInt("autoId"), mijnResultset.getDouble("snelheid"), mijnResultset.getBoolean("schermAan"), mijnResultset.getDouble("kmStand"), mijnResultset.getInt("huidigeBestuurder"));
    }
}
