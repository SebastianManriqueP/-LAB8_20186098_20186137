package Daos;

import Beans.Cancion;
import java.util.ArrayList;
import java.sql.*;

public class CancionRecomenDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";

    public ArrayList<Cancion> obtenerCancionesRecom() {
        ArrayList<Cancion> listaCancionR = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT C.idcancion, C.nombre_cancion, C.banda FROM reproduccion R, cancion C where C.idcancion = R.cancion_idcancion group by R.cancion_idcancion having count(*)>2 order by count(*) desc");) {

            while (rs.next()) {
                Cancion cancion = new Cancion(rs.getInt(1),rs.getString(2),rs.getInt(3));
                listaCancionR.add(cancion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaCancionR;
    }


}