package co.unilibre.edu.serpientesyescaleras.controlador;

import co.unilibre.edu.serpientesyescaleras.modelo.Jugador;
import co.unilibre.edu.serpientesyescaleras.modelo.Partida;
import co.unilibre.edu.serpientesyescaleras.vista.VentanaPrincipal;

import javax.swing.*;

public class ControladorJuego {

    private Partida partida;
    private VentanaPrincipal ventana;
    private boolean animando = false;

    public ControladorJuego(Partida partida, VentanaPrincipal ventana) {
        this.partida = partida;
        this.ventana = ventana;

        this.ventana.getPanelTablero().setJugadores(partida.getJugadores());
        this.ventana.getPanelTablero().setTablero(partida.getTablero());
        this.ventana.getPanelControles().actualizarTurno(partida.getJugadorActual());

        this.ventana.getPanelControles().getBtnLanzar().addActionListener(e -> onLanzarDado());
    }

    public void onLanzarDado() {
        if (animando) {
            return;
        }

        animando = true;
        ventana.getPanelControles().getBtnLanzar().setEnabled(false);

        Jugador jugador = partida.getJugadorActual();
        int valorDado = partida.getDado().lanzar();
        ventana.getPanelControles().actualizarDado(valorDado);
        ventana.getPanelControles().agregarMensaje(jugador.getNombre() + " lanzó " + valorDado);

        int posicionInicial = jugador.getPosicionActual();
        int posicionBase = partida.getTablero().calcularPosicionBase(posicionInicial, valorDado);

        animarMovimiento(jugador, posicionInicial, posicionBase, () -> {
            int posicionFinal = partida.getTablero().aplicarSerpienteOEscalera(posicionBase);
            if (posicionFinal != posicionBase) {
                if (posicionFinal > posicionBase) {
                    ventana.getPanelControles().agregarMensaje(jugador.getNombre() + " subió por una escalera hasta la casilla " + posicionFinal);
                } else {
                    ventana.getPanelControles().agregarMensaje(jugador.getNombre() + " cayó en una serpiente hasta la casilla " + posicionFinal);
                }
                jugador.moverA(posicionFinal);
                ventana.getPanelTablero().repintar();
            }
            finalizarTurno(jugador);
        });
    }

    private void animarMovimiento(Jugador jugador, int desde, int hasta, Runnable alTerminar) {
        if (desde >= hasta) {
            alTerminar.run();
            return;
        }

        int[] pasoActual = {desde};
        Timer timer = new Timer(180, null);
        timer.addActionListener(e -> {
            pasoActual[0]++;
            jugador.moverA(pasoActual[0]);
            ventana.getPanelTablero().repintar();

            if (pasoActual[0] >= hasta) {
                ((Timer) e.getSource()).stop();
                alTerminar.run();
            }
        });
        timer.start();
    }

    private void finalizarTurno(Jugador jugador) {
        ventana.getPanelControles().agregarMensaje(jugador.getNombre() + " quedó en la casilla " + jugador.getPosicionActual());

        Jugador ganador = partida.verificarGanador();
        animando = false;

        if (ganador != null) {
            partida.finalizarPartida();
            ventana.getPanelControles().agregarMensaje("¡" + ganador.getNombre() + " ganó la partida!");
            ventana.getPanelControles().getBtnLanzar().setEnabled(false);
        } else {
            partida.avanzarTurno();
            ventana.getPanelControles().actualizarTurno(partida.getJugadorActual());
            ventana.getPanelControles().getBtnLanzar().setEnabled(true);
        }
    }

    public void onNuevaPartida() {
        partida.iniciar();
        for (Jugador j : partida.getJugadores()) {
            j.moverA(1);
        }
        animando = false;
        ventana.getPanelControles().getBtnLanzar().setEnabled(true);
        ventana.getPanelControles().actualizarTurno(partida.getJugadorActual());
        ventana.getPanelTablero().repintar();
    }
}