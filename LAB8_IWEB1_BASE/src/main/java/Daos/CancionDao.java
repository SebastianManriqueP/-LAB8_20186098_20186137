package Daos;

import Beans.Cancion;
import java.util.ArrayList;
import java.sql.*;

public class CancionDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public ArrayList<Cancion> obtenerCancionesRecom() {
        ArrayList<Cancion> listaCancionR = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT C.idcancion, C.nombre_cancion, C.banda, C.Favorito FROM reproduccion R, cancion C where C.idcancion = R.cancion_idcancion group by R.cancion_idcancion having count(*)>2 order by count(*) desc");) {

            while (rs.next()) {
                Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                listaCancionR.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaCancionR;
    }

    public  ArrayList<Cancion> obtenerCanciones(){
        ArrayList<Cancion> listaCancion = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM cancion");) {

            while (rs.next()) {
                Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
                listaCancion.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaCancion;
    }

    public void agregarFav(String id){
        int idInt = Integer.parseInt(id);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE cancion SET Favorito = 1 WHERE idcancion = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1,idInt);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borrarFav(String id){
        int idInt = Integer.parseInt(id);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE cancion SET Favorito = 0 WHERE idcancion = ?";

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1,idInt);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Cancion> obtenerlistacanciones(String banda) {
        ArrayList<Cancion> listaCancionR = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sql = " SELECT * FROM cancion where banda= "?" ";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, banda);
            pstmt.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaCancionR;
    }

}