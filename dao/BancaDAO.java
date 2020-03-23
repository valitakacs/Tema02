package ro.Emanuel.Tema02.dao;

import ro.Emanuel.Tema02.helper.DBHelper;
import ro.Emanuel.Tema02.pojo.Angajat;
import ro.Emanuel.Tema02.pojo.Banca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BancaDAO {
    // insert
    public static void insert(Banca banca) throws SQLException {
        Connection con = DBHelper.getConnection();
        String insertString = "INSERT INTO banca(nume,adresa,telefon,an_infiintare,capital)" + "VALUES(?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(insertString);
        stmt.setString(1, banca.getNume());
        stmt.setString(2, banca.getAdresa());
        stmt.setString(3, banca.getTelefon());
        stmt.setString(4, banca.getAnInfiintare());
        stmt.setString(5, banca.getCapital());
        stmt.executeUpdate();

        DBHelper.closeConnection(con);

    }
    //update
    public static void updateBanca(Banca banca) throws SQLException{
        Connection con=DBHelper.getConnection();
        String updateString="UPDATE banca SET nume = ?,adresa = ?" +"telefon = ?, an_infiintare = ?" + "capital = ? WHERE id =?";
        PreparedStatement stmt=con.prepareStatement(updateString);
        stmt.setString(1, banca.getNume());
        stmt.setString(2, banca.getAdresa());
        stmt.setString(3, banca.getTelefon());
        stmt.setString(4, banca.getAnInfiintare());
        stmt.setString(5, banca.getCapital());
        stmt.executeUpdate();
        DBHelper.closeConnection(con);
    }

    //delete

    public static void deletBanca(int idBanca) throws SQLException{
        Connection con =DBHelper.getConnection();
        String deleteString="DELETE FROM banca WHERE id=?";
        PreparedStatement stmt=con.prepareStatement(deleteString);
        stmt.setInt(1,idBanca);

        stmt.executeUpdate();
        DBHelper.closeConnection(con);

    }
    //apelam methoda delete,suprascriem;
    public static void deleteBanca(Banca banca) throws SQLException{
        BancaDAO.deletBanca(banca.getId());
    }


}
