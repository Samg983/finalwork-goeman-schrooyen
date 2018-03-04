/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.dao;

import be.finalwork.goemanschrooyen.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SamGoeman
 */
public class ContactDao {
    public static ArrayList<Contact> getContacten() {
        ArrayList<Contact> resultaat = new ArrayList<Contact>();
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Contact");
            if (mijnResultset != null) {
                while (mijnResultset.next()) {
                    Contact huidigeContact = converteerHuidigeRijNaarObject(mijnResultset);
                    resultaat.add(huidigeContact);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }

        return resultaat;
    }

    public static Contact getContactById(int id) {
        Contact resultaat = null;
        try {
            ResultSet mijnResultset = Database.voerSqlUitEnHaalResultaatOp("SELECT * from Contact where contactId = ?", new Object[]{id});
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

    public static int voegContactToe(Contact nieuweContact) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("INSERT INTO Contact (naam, telnr, isFavo) VALUES (?,?,?)", new Object[]{nieuweContact.getNaam(), nieuweContact.getTelnr(), nieuweContact.getIsFavo()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int updateContact(Contact nieuweContact) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("UPDATE Contact SET naam = ?, telnr = ?, isFavo = ? WHERE contactId = ?", new Object[]{nieuweContact.getNaam(), nieuweContact.getTelnr(), nieuweContact.getIsFavo(), nieuweContact.getContactId()});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    public static int verwijderContact(int ContactId) {
        int aantalAangepasteRijen = 0;
        try {
            aantalAangepasteRijen = Database.voerSqlUitEnHaalAantalAangepasteRijenOp("DELETE FROM Contact WHERE contactId = ?", new Object[]{ContactId});
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Foutafhandeling naar keuze
        }
        return aantalAangepasteRijen;
    }

    private static Contact converteerHuidigeRijNaarObject(ResultSet mijnResultset) throws SQLException {
        return new Contact(mijnResultset.getInt("contactId"), mijnResultset.getString("naam"), mijnResultset.getString("telnr"), mijnResultset.getBoolean("isFavo"));
    }
}
