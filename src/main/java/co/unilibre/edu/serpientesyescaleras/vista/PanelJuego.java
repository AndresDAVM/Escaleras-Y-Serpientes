package co.unilibre.edu.serpientesyescaleras.vista;

import javax.swing.*;
import java.awt.*;

public class PanelJuego extends JPanel {

    private PanelTablero panelTablero;
    private PanelControles panelControles;

    public PanelJuego() {
        setLayout(new BorderLayout());
        panelTablero = new PanelTablero();
        panelControles = new PanelControles();
        add(panelTablero, BorderLayout.CENTER);
        add(panelControles, BorderLayout.EAST);
    }

    public PanelTablero getPanelTablero() {
        return panelTablero;
    }

    public PanelControles getPanelControles() {
        return panelControles;
    }
}