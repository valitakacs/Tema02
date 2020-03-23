package ro.Emanuel.Tema02;


import ro.Emanuel.Tema02.dao.AngajatDAO;
import ro.Emanuel.Tema02.dao.BancaDAO;
import ro.Emanuel.Tema02.dao.ClientDAO;
import ro.Emanuel.Tema02.helper.DBHelper;
import ro.Emanuel.Tema02.pojo.Angajat;
import ro.Emanuel.Tema02.pojo.Banca;
import ro.Emanuel.Tema02.pojo.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainDao {
    public static void main(String[] args) throws SQLException {
        Connection con = DBHelper.getConnection();

        Banca banca1 = new Banca(3, "Vali", "Nojoridului 43B", "0771435667", "2000", "9000000");
        BancaDAO.insert(banca1);

        //BancaDAO.updateBanca();

        //BancaDAO.deleteBanca(1);

        Angajat angajat1 = new Angajat(1, "Takacs", "Vali", "Director", 210000);
        AngajatDAO.insert(angajat1);

        ArrayList<Angajat> angajati = AngajatDAO.getAllAngajat();
        for (Angajat angajat : angajati) {
            System.out.println(angajat.toString());
        }
       /* ArrayList<Angajat>angajats=AngajatDAO.getAllAngajatByFunctie()
                for(Angajat angajat:angajats){
                    System.out.println(angajat.toString());
                }
        ArrayList<Angajat>angajatt=AngajatDAO.getAllAngajatBySalar()
        for(Angajat angajat:angajatt){
            System.out.println(angajat.toString());
        }*/


        //Angajat.deleteAngajatBanca(1);


        Client client1 = new Client(2, "Marius", "0004563245445", "Nufarul", "07745632221", 32);
        ClientDAO.insertClienti(client1);

        ArrayList<Client> clienti = ClientDAO.getALLClient();
        for (Client client : clienti) {
            System.out.println(client.toString());
        }

        //ClientDAO.deleteClient(2);

        DBHelper.closeConnection(con);

    }
}
