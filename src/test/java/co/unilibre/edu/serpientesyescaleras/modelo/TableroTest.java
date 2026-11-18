package co.unilibre.edu.serpientesyescaleras.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    private Tablero tablero;

    @BeforeEach
    void setUp() {
        List<Serpiente> serpientes = new ArrayList<>();
        serpientes.add(new Serpiente(16, 6));

        List<Escalera> escaleras = new ArrayList<>();
        escaleras.add(new Escalera(2, 10));

        tablero = new Tablero(serpientes, escaleras);
    }

    @Test
    void calcularPosicionBaseDebeSumarElValorDelDado() {
        int nueva = tablero.calcularPosicionBase(5, 3);
        assertEquals(8, nueva);
    }

    @Test
    void calcularPosicionBaseNoDebePasarseDe100() {
        int nueva = tablero.calcularPosicionBase(98, 5);
        assertEquals(98, nueva, "Si se pasa de 100, el jugador debe quedarse en la misma casilla");
    }

    @Test
    void aplicarSerpienteDebeRegresarALaCola() {
        int resultado = tablero.aplicarSerpienteOEscalera(16);
        assertEquals(6, resultado);
    }

    @Test
    void aplicarEscaleraDebeSubirHastaElFinal() {
        int resultado = tablero.aplicarSerpienteOEscalera(2);
        assertEquals(10, resultado);
    }

    @Test
    void aplicarEnCasillaSinEspecialNoDebeCambiarLaPosicion() {
        int resultado = tablero.aplicarSerpienteOEscalera(50);
        assertEquals(50, resultado);
    }
}