package Beans;

public class Cancion {
    private int idCancion;
    private String nombreCancion;
    private String nombreBanda;
    private int bFavorito;

    public Cancion(int idCancion, String nombreCancion, String nombreBanda, int bFavorito) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.nombreBanda = nombreBanda;
        this.bFavorito = bFavorito;
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

    public int getbFavorito() {
        return bFavorito;
    }

    public void setbFavorito(int bFavorito) {
        this.bFavorito = bFavorito;
    }
}