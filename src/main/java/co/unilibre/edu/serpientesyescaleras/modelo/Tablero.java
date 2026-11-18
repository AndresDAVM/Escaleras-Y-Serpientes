package co.unilibre.edu.serpientesyescaleras.modelo;

import java.util.List;

public class Tablero {

    private final int tamano = 100;
    private List<Serpiente> serpientes;
    private List<Escalera> escaleras;

    public Tablero(List<Serpiente> serpientes, List<Escalera> escaleras) {
        this.serpientes = serpientes;
        this.escaleras = escaleras;
    }

    public int calcularPosicionBase(int posicionActual, int valorDado) {
        int nuevaPosicion = posicionActual + valorDado;
        if (nuevaPosicion > tamano) {
            return posicionActual;
        }
        return nuevaPosicion;
    }

    public int aplicarSerpienteOEscalera(int posicion) {
        for (Serpiente serpiente : serpientes) {
            if (serpiente.getPosicionCabeza() == posicion) {
                return serpiente.getPosicionCola();
            }
        }
        for (Escalera escalera : escaleras) {
            if (escalera.getPosicionInicio() == posicion) {
                return escalera.getPosicionFin();
            }
        }
        return posicion;
    }

    public int getTamano() {
        return tamano;
    }

    public List<Serpiente> getSerpientes() {
        return serpientes;
    }

    public List<Escalera> getEscaleras() {
        return escaleras;
    }
}