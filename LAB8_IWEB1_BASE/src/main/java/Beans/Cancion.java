package Beans;

public class Cancion {
    private int idCancion;
    private String nombreCancion;
    private String nombreBanda;

    public Artista(int idCancion, String nombreCancion, String nombreBanda) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.nombreBanda = nombreBanda;
    }


    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }
}