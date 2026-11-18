package co.unilibre.edu.serpientesyescaleras.modelo;

import java.util.Random;

public class Dado {

    private int ultimoValor;
    private final Random random;

    public Dado() {
        this.random = new Random();
        this.ultimoValor = 0;
    }

    public int lanzar() {
        this.ultimoValor = random.nextInt(6) + 1; // valor entre 1 y 6
        return this.ultimoValor;
    }

    public int getUltimoValor() {
        return ultimoValor;
    }
}