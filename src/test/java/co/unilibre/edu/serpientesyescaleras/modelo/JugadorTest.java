package co.unilibre.edu.serpientesyescaleras.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JugadorTest {

    @Test
    void jugadorDebeIniciarEnCasilla1() {
        Jugador jugador = new Jugador("Ana", "rojo");
        assertEquals(1, jugador.getPosicionActual());
    }

    @Test
    void moverADebeActualizarLaPosicion() {
        Jugador jugador = new Jugador("Ana", "rojo");
        jugador.moverA(25);
        assertEquals(25, jugador.getPosicionActual());
    }

    @Test
    void getNombreYColorDebenCoincidirConElConstructor() {
        Jugador jugador = new Jugador("Luis", "azul");
        assertEquals("Luis", jugador.getNombre());
        assertEquals("azul", jugador.getColor());
    }
}