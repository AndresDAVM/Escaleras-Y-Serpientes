package co.unilibre.edu.serpientesyescaleras.modelo;

public class Escalera {

    private int posicionInicio;
    private int posicionFin;

    public Escalera(int posicionInicio, int posicionFin) {
        this.posicionInicio = posicionInicio;
        this.posicionFin = posicionFin;
    }

    public int getPosicionInicio() {
        return posicionInicio;
    }

    public int getPosicionFin() {
        return posicionFin;
    }
}