package ro.Emanuel.Tema02.dao;

import ro.Emanuel.Curs02.pojo.ContBancar;
import ro.Emanuel.Tema02.helper.DBHelper;
import ro.Emanuel.Tema02.pojo.Angajat;

import java.sql.*;
import java.util.ArrayList;

public class AngajatDAO {

    //insert value;

    public static void insert(Angajat angajat) throws SQLException {

        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO angajat_banca(nume, prenume, functie,salar)"
                + " VALUES(?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setString(1, angajat.getNume());
        stmt.setString(2, angajat.getPrenume());
        stmt.setString(3, angajat.getFunctie());
        stmt.setFloat(4, angajat.getSalar());
        stmt.executeUpdate();

        DBHelper.closeConnection(con);

    }

    public static ArrayList<Angajat> getAllAngajat() throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * FROM angajat_banca";
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Angajat> results = new ArrayList<Angajat>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String prenume = rs.getString("prenume");
            String functie = rs.getString("functie");
            float salar = rs.getFloat("salar");
            Angajat angajat= new Angajat(id, nume, prenume, functie, salar);
            results.add(angajat);
        }
        DBHelper.closeConnection(con);
        return results;
    }

    // toti angajatii dupa functie
    public static ArrayList<Angajat> getAllAngajatByFunctie(String functie) throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * from angajat_banca where functie=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, functie);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Angajat> results = new ArrayList<Angajat>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String prenume = rs.getString("prenume");
            String functieAngajat = rs.getString("functie");
            float salar = rs.getFloat("salar");
            Angajat angajat= new Angajat(id, nume, prenume, functieAngajat, salar);
            results.add(angajat);
        }
        DBHelper.closeConnection(con);
        return results;
    }

    //toti angajati dupa salar
    public static ArrayList<Angajat> getAllAngajatBySalar(float salar) throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * from angajat_banca where salar=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setFloat(1, salar);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Angajat> results = new ArrayList<Angajat>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String prenume = rs.getString("prenume");
            String functie = rs.getString("functie");
            float salarul = rs.getFloat("salar");
            Angajat angajat= new Angajat(id, nume, prenume, functie, salarul);
            results.add(angajat);
        }
        DBHelper.closeConnection(con);
        return results;
    }

    //angajat by id
    public static Angajat getAngajatById(int id) throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * from angajat_banca where id=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Angajat angajat = null;
        if (rs.next()) {
            int idAngajat = rs.getInt("id");
            String nume = rs.getString("nume");
            String prenume = rs.getString("prenume");
            String functie = rs.getString("functie");
            float salar = rs.getFloat("salar");
            angajat = new Angajat(idAngajat, nume, prenume, functie, salar);
        }
        DBHelper.closeConnection(con);
        return angajat;

    }

    //update

    public static void updateAngajat(Angajat angajat) throws SQLException {
        Connection con = DBHelper.getConnection();
        String updateString = "UPDATE angajat_banca SET funcite = ?,salar = ?," + "nume= ?,prenume=? WHERE id = ?";
        PreparedStatement stmt=con.prepareStatement(updateString);
        stmt.setString(1,angajat.getFunctie());
        stmt.setFloat(2,angajat.getSalar());
        stmt.setString(3,angajat.getNume());
        stmt.setString(4,angajat.getPrenume());
        stmt.setInt(5,angajat.getId());

        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    //delete
    public static void deleteAngajat(int idAngajat) throws SQLException{
        Connection con = DBHelper.getConnection();
        String deleteString="DELETE FROM cont_bancar where id=?";
        PreparedStatement stmt = con.prepareStatement(deleteString);
        stmt.setInt(1,idAngajat);
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public static void deleteAngajat(Angajat angajat)throws SQLException{
        AngajatDAO.deleteAngajat(angajat.getId());
    }




}
