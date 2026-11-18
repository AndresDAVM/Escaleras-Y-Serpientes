package co.unilibre.edu.serpientesyescaleras.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartidaTest {

    private Partida partida;
    private Jugador jugador1;
    private Jugador jugador2;

    @BeforeEach
    void setUp() {
        Tablero tablero = new Tablero(new ArrayList<>(), new ArrayList<>());
        Dado dado = new Dado();

        jugador1 = new Jugador("Ana", "rojo");
        jugador2 = new Jugador("Luis", "azul");

        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        partida = new Partida(tablero, dado, jugadores);
    }

    @Test
    void verificarGanadorDebeSerNuloAlInicio() {
        assertNull(partida.verificarGanador());
    }

    @Test
    void verificarGanadorDebeDevolverElJugadorQueLlegaA100() {
        jugador1.moverA(100);
        assertEquals(jugador1, partida.verificarGanador());
    }

    @Test
    void avanzarTurnoDebeCambiarAlSiguienteJugador() {
        assertEquals(jugador1, partida.getJugadorActual());
        partida.avanzarTurno();
        assertEquals(jugador2, partida.getJugadorActual());
    }

    @Test
    void avanzarTurnoDebeVolverAlPrimerJugadorAlFinalDeLaLista() {
        partida.avanzarTurno(); // pasa a jugador2
        partida.avanzarTurno(); // debe volver a jugador1
        assertEquals(jugador1, partida.getJugadorActual());
    }
}