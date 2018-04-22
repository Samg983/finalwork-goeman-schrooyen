/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.App;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class AppDao {
       
    public static ArrayList<App> getApps() {
        ArrayList<App> resultaat = new ArrayList<App>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from App");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    App huidigeApp = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeApp);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static App getAppById(int id) {
        App resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from App where appId = ?", new Object[]{id});
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

    public static int voegAppToe(App nieuweApp) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO App (naam, beschrijving, imgpath) VALUES (?,?,?)", new Object[]{nieuweApp.getNaam(), nieuweApp.getBeschrijving(), nieuweApp.getImgpath()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateApp(App nieuweApp) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE App SET naam = ?, beschrijving = ?, imgpath = ? WHERE appId = ?", new Object[]{nieuweApp.getNaam(), nieuweApp.getBeschrijving(), nieuweApp.getImgpath(), nieuweApp.getAppId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderApp(int AppId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM App WHERE appId = ?", new Object[]{AppId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static App converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new App(mijnResultset.getInt("appId"), mijnResultset.getString("naam"), mijnResultset.getString("beschrijving"), mijnResultset.getString("imgpath"));
    }
}
