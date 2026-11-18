package co.unilibre.edu.serpientesyescaleras.controlador;

import co.unilibre.edu.serpientesyescaleras.modelo.*;
import co.unilibre.edu.serpientesyescaleras.vista.VentanaPrincipal;

import java.util.ArrayList;
import java.util.List;

public class ControladorConfiguracion {

    private VentanaPrincipal ventana;

    public ControladorConfiguracion(VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.ventana.getPanelConfiguracion().getBtnIniciar().addActionListener(e -> iniciarPartida());
    }

    private void iniciarPartida() {
        var panelConfig = ventana.getPanelConfiguracion();
        int cantidad = panelConfig.getCantidadJugadores();
        String[] nombres = panelConfig.getNombres();

        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            jugadores.add(new Jugador(nombres[i], panelConfig.getColorPara(i)));
        }

        Tablero tablero = crearTableroPredeterminado();
        Dado dado = new Dado();
        Partida partida = new Partida(tablero, dado, jugadores);

        new ControladorJuego(partida, ventana);
        ventana.mostrarJuego();
    }

    private Tablero crearTableroPredeterminado() {
        List<Serpiente> serpientes = new ArrayList<>();
        serpientes.add(new Serpiente(99, 54));
        serpientes.add(new Serpiente(70, 15));
        serpientes.add(new Serpiente(48, 26));

        List<Escalera> escaleras = new ArrayList<>();
        escaleras.add(new Escalera(4, 25));
        escaleras.add(new Escalera(21, 43));
        escaleras.add(new Escalera(50, 67));

        return new Tablero(serpientes, escaleras);
    }
}