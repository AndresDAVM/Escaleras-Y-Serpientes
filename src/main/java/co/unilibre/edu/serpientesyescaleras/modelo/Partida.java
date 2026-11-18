package co.unilibre.edu.serpientesyescaleras.modelo;

import java.util.List;

public class Partida {

    private Tablero tablero;
    private Dado dado;
    private List<Jugador> jugadores;
    private int turnoActual;
    private EstadoPartida estado;

    public Partida(Tablero tablero, Dado dado, List<Jugador> jugadores) {
        this.tablero = tablero;
        this.dado = dado;
        this.jugadores = jugadores;
        this.turnoActual = 0;
        this.estado = EstadoPartida.EN_CURSO;
    }

    public void iniciar() {
        this.turnoActual = 0;
        this.estado = EstadoPartida.EN_CURSO;
    }

    public void avanzarTurno() {
        this.turnoActual = (turnoActual + 1) % jugadores.size();
    }

    public void finalizarPartida() {
        this.estado = EstadoPartida.FINALIZADA;
    }

    public Jugador verificarGanador() {
        for (Jugador jugador : jugadores) {
            if (jugador.getPosicionActual() == tablero.getTamano()) {
                return jugador;
            }
        }
        return null;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Dado getDado() {
        return dado;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public EstadoPartida getEstado() {
        return estado;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual);
    }
}