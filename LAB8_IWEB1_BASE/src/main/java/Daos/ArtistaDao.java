package Daos;

import Beans.Artista;
import java.util.ArrayList;
import java.sql.*;

public class ArtistaDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";

    public ArrayList<Artista> obtenerartistas() {
        ArrayList<Artista> listaArtistas = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaArtistas;
    }

}