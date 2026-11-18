package co.unilibre.edu.serpientesyescaleras.vista;

import javax.swing.*;
import java.awt.*;

public class PanelDado extends JPanel {

    private int valor = 1;

    public PanelDado() {
        setPreferredSize(new Dimension(60, 60));
    }

    public void setValor(int valor) {
        this.valor = valor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int lado = Math.min(getWidth(), getHeight()) - 4;
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(2, 2, lado, lado, 12, 12);
        g2.setColor(Color.BLACK);
        g2.drawRoundRect(2, 2, lado, lado, 12, 12);

        int cx = 2 + lado / 2;
        int cy = 2 + lado / 2;
        int offset = lado / 4;
        int radio = lado / 10;

        dibujarPuntos(g2, cx, cy, offset, radio);
    }

    private void dibujarPuntos(Graphics2D g, int cx, int cy, int offset, int radio) {
        switch (valor) {
            case 1 -> punto(g, cx, cy, radio);
            case 2 -> {
                punto(g, cx - offset, cy - offset, radio);
                punto(g, cx + offset, cy + offset, radio);
            }
            case 3 -> {
                punto(g, cx - offset, cy - offset, radio);
                punto(g, cx, cy, radio);
                punto(g, cx + offset, cy + offset, radio);
            }
            case 4 -> {
                punto(g, cx - offset, cy - offset, radio);
                punto(g, cx + offset, cy - offset, radio);
                punto(g, cx - offset, cy + offset, radio);
                punto(g, cx + offset, cy + offset, radio);
            }
            case 5 -> {
                punto(g, cx - offset, cy - offset, radio);
                punto(g, cx + offset, cy - offset, radio);
                punto(g, cx, cy, radio);
                punto(g, cx - offset, cy + offset, radio);
                punto(g, cx + offset, cy + offset, radio);
            }
            case 6 -> {
                punto(g, cx - offset, cy - offset, radio);
                punto(g, cx + offset, cy - offset, radio);
                punto(g, cx - offset, cy, radio);
                punto(g, cx + offset, cy, radio);
                punto(g, cx - offset, cy + offset, radio);
                punto(g, cx + offset, cy + offset, radio);
            }
        }
    }

    private void punto(Graphics2D g, int x, int y, int radio) {
        g.fillOval(x - radio, y - radio, radio * 2, radio * 2);
    }
}