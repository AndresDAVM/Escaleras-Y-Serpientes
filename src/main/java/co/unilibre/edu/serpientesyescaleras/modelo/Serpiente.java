package co.unilibre.edu.serpientesyescaleras.modelo;

public class Serpiente {

    private int posicionCabeza;
    private int posicionCola;

    public Serpiente(int posicionCabeza, int posicionCola) {
        this.posicionCabeza = posicionCabeza;
        this.posicionCola = posicionCola;
    }

    public int getPosicionCabeza() {
        return posicionCabeza;
    }

    public int getPosicionCola() {
        return posicionCola;
    }
}