package co.unilibre.edu.serpientesyescaleras.modelo;

public class Jugador {

    private String nombre;
    private String color;
    private int posicionActual;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.posicionActual = 1; // todos arrancan en la casilla 1
    }

    public void moverA(int pos) {
        this.posicionActual = pos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getPosicionActual() {
        return posicionActual;
    }
}