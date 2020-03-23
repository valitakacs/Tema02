package ro.Emanuel.Tema02.dao;

import ro.Emanuel.Tema02.helper.DBHelper;
import ro.Emanuel.Tema02.pojo.Angajat;
import ro.Emanuel.Tema02.pojo.Client;

import java.sql.*;
import java.util.ArrayList;

public class ClientDAO {
    // insert value
    public static void insertClienti(Client client) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO client(nume,cnp,adresa,telefon,varsta)" + "VALUES(?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setString(1, client.getNume());
        stmt.setString(2, client.getCnp());
        stmt.setString(3, client.getAdresa());
        stmt.setString(4, client.getTelefon());
        stmt.setInt(5, client.getVarsta());

        stmt.executeUpdate();
        DBHelper.closeConnection(con);

    }
    // all clients

    public static ArrayList<Client> getALLClient() throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * FROM client";
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Client> results = new ArrayList<Client>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String cnp = rs.getString("cnp");
            String adresa = rs.getString("adresa");
            String telefon = rs.getString("telefon");
            int varsta = rs.getInt("varsta");
            Client client = new Client(id, nume, cnp, adresa, telefon, varsta);
            results.add(client);
        }
        DBHelper.closeConnection(con);
        return results;
    }

    //all client by name
    public static ArrayList<Client> getAllClientByName(String nume) throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * from client where name=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, nume);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Client> results = new ArrayList<Client>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String numeClient = rs.getString("nume");
            String cnp = rs.getString("cnp");
            String adresa = rs.getString("adresa");
            String telefon = rs.getString("telefon");
            int varsta = rs.getInt("varsta");
            Client client = new Client(id, numeClient, cnp, adresa, telefon, varsta);
            results.add(client);
        }
        DBHelper.closeConnection(con);
        return results;
    }
    //all client by age

    public static ArrayList<Client> getAllClientByName(int age) throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * from client where age=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, age);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Client> results = new ArrayList<Client>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String cnp = rs.getString("cnp");
            String adresa = rs.getString("adresa");
            String telefon = rs.getString("telefon");
            int varsta = rs.getInt("varsta");
            Client client = new Client(id, nume, cnp, adresa, telefon, varsta);
            results.add(client);
        }
        DBHelper.closeConnection(con);
        return results;
    }

    //all client by adress

    public static ArrayList<Client> getAllClientByAdresa(String adresa) throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * from client where adresa=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, adresa);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Client> results = new ArrayList<Client>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nume = rs.getString("nume");
            String cnp = rs.getString("cnp");
            String adresaClient = rs.getString("adresa");
            String telefon = rs.getString("telefon");
            int varsta = rs.getInt("varsta");
            Client client = new Client(id, nume, cnp, adresaClient, telefon, varsta);
            results.add(client);
        }
        DBHelper.closeConnection(con);
        return results;
    }

    //client by id
    public static Client getClientById(int id) throws SQLException {
        Connection con = DBHelper.getConnection();
        String query = "SELECT * from client where id=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Client client = null;
        if (rs.next()) {
            int idClient = rs.getInt("id");
            String nume = rs.getString("nume");
            String cnp = rs.getString("cnp");
            String adresa = rs.getString("adresa");
            String telefon = rs.getString("telefon");
            int varsta = rs.getInt("varsta");
            client = new Client(idClient, nume, cnp, adresa, telefon, varsta);
        }
        DBHelper.closeConnection(con);
        return client;

    }

    //update
    public static void updateClienti(Client client) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "UPDATE client SET nume = ?,cnp = ?," + "adresa= ?,telefon=?" + "varsta=? WHERE id = ?";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setString(1, client.getNume());
        stmt.setString(2, client.getCnp());
        stmt.setString(3, client.getAdresa());
        stmt.setString(4, client.getTelefon());
        stmt.setInt(5, client.getVarsta());

        stmt.executeUpdate();
        DBHelper.closeConnection(con);

    }

    //delete
    public static void deleteClient(int idClient) throws SQLException{
        Connection con = DBHelper.getConnection();
        String deleteString="DELETE FROM client where id=?";
        PreparedStatement stmt = con.prepareStatement(deleteString);
        stmt.setInt(1,idClient);
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    public static void deleteClient(Client client)throws SQLException{
        ClientDAO.deleteClient(client.getId());
    }



}
