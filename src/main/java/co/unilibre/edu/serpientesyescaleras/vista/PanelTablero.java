package co.unilibre.edu.serpientesyescaleras.vista;

import co.unilibre.edu.serpientesyescaleras.modelo.Escalera;
import co.unilibre.edu.serpientesyescaleras.modelo.Jugador;
import co.unilibre.edu.serpientesyescaleras.modelo.Serpiente;
import co.unilibre.edu.serpientesyescaleras.modelo.Tablero;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelTablero extends JPanel {

    private static final int FILAS = 10;
    private static final int COLUMNAS = 10;

    private List<Jugador> jugadores;
    private Tablero tablero;

    public PanelTablero() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void repintar() {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int ancho = getWidth() / COLUMNAS;
        int alto = getHeight() / FILAS;

        dibujarCasillas(g2, ancho, alto);

        if (tablero != null) {
            dibujarEscaleras(g2, tablero.getEscaleras(), ancho, alto);
            dibujarSerpientes(g2, tablero.getSerpientes(), ancho, alto);
        }

        if (jugadores != null) {
            for (Jugador j : jugadores) {
                dibujarJugador(g2, j, ancho, alto);
            }
        }
    }

    private void dibujarCasillas(Graphics2D g, int ancho, int alto) {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int col = 0; col < COLUMNAS; col++) {
                int x = col * ancho;
                int y = fila * alto;

                int numero = calcularNumeroCasilla(fila, col);
                g.setColor((numero % 2 == 0) ? new Color(235, 245, 255) : Color.WHITE);
                g.fillRect(x, y, ancho, alto);

                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x, y, ancho, alto);

                g.setColor(Color.DARK_GRAY);
                g.setFont(g.getFont().deriveFont(Font.PLAIN, 11f));
                g.drawString(String.valueOf(numero), x + 4, y + 14);
            }
        }
    }

    private void dibujarEscaleras(Graphics2D g, List<Escalera> escaleras, int ancho, int alto) {
        g.setStroke(new BasicStroke(4));
        g.setColor(new Color(34, 139, 34)); // verde
        for (Escalera escalera : escaleras) {
            Point inicio = centroCasilla(escalera.getPosicionInicio(), ancho, alto);
            Point fin = centroCasilla(escalera.getPosicionFin(), ancho, alto);
            g.drawLine(inicio.x, inicio.y, fin.x, fin.y);
        }
    }

    private void dibujarSerpientes(Graphics2D g, List<Serpiente> serpientes, int ancho, int alto) {
        g.setStroke(new BasicStroke(4));
        g.setColor(new Color(200, 30, 30)); // rojo
        for (Serpiente serpiente : serpientes) {
            Point cabeza = centroCasilla(serpiente.getPosicionCabeza(), ancho, alto);
            Point cola = centroCasilla(serpiente.getPosicionCola(), ancho, alto);
            g.drawLine(cabeza.x, cabeza.y, cola.x, cola.y);

            // marca la cabeza con un circulo para distinguirla de la escalera
            g.fillOval(cabeza.x - 5, cabeza.y - 5, 10, 10);
        }
    }

    private Point centroCasilla(int casilla, int ancho, int alto) {
        int[] rc = obtenerFilaColumna(casilla);
        int x = rc[1] * ancho + ancho / 2;
        int y = rc[0] * alto + alto / 2;
        return new Point(x, y);
    }

    private int calcularNumeroCasilla(int fila, int col) {
        int filaDesdeAbajo = FILAS - 1 - fila;
        int base = filaDesdeAbajo * COLUMNAS;
        boolean izquierdaADerecha = filaDesdeAbajo % 2 == 0;
        int offset = izquierdaADerecha ? col : (COLUMNAS - 1 - col);
        return base + offset + 1;
    }

    private void dibujarJugador(Graphics2D g, Jugador jugador, int ancho, int alto) {
        Point centro = centroCasilla(jugador.getPosicionActual(), ancho, alto);
        int x = centro.x - 8;
        int y = centro.y - 8;

        g.setColor(obtenerColor(jugador.getColor()));
        g.fillOval(x, y, 16, 16);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 16, 16);
    }

    private int[] obtenerFilaColumna(int casilla) {
        int indice = casilla - 1;
        int filaDesdeAbajo = indice / COLUMNAS;
        int fila = FILAS - 1 - filaDesdeAbajo;
        boolean izquierdaADerecha = filaDesdeAbajo % 2 == 0;
        int colEnFila = indice % COLUMNAS;
        int col = izquierdaADerecha ? colEnFila : (COLUMNAS - 1 - colEnFila);
        return new int[]{fila, col};
    }

    private Color obtenerColor(String nombreColor) {
        return switch (nombreColor.toLowerCase()) {
            case "rojo" -> Color.RED;
            case "azul" -> Color.BLUE;
            case "verde" -> Color.GREEN.darker();
            case "amarillo" -> Color.ORANGE;
            default -> Color.GRAY;
        };
    }
}