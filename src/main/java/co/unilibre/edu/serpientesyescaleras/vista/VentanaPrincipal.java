package co.unilibre.edu.serpientesyescaleras.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private CardLayout cardLayout;
    private JPanel panelContenedor;

    private PanelConfiguracion panelConfiguracion;
    private PanelJuego panelJuego;

    public VentanaPrincipal() {
        setTitle("Serpientes y Escaleras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        panelConfiguracion = new PanelConfiguracion();
        panelJuego = new PanelJuego();

        panelContenedor.add(panelConfiguracion, "configuracion");
        panelContenedor.add(panelJuego, "juego");

        add(panelContenedor);

        setSize(700, 550);
        setLocationRelativeTo(null);
    }

    public void mostrarJuego() {
        cardLayout.show(panelContenedor, "juego");
    }

    public void mostrar() {
        setVisible(true);
    }

    public PanelConfiguracion getPanelConfiguracion() {
        return panelConfiguracion;
    }

    public PanelTablero getPanelTablero() {
        return panelJuego.getPanelTablero();
    }

    public PanelControles getPanelControles() {
        return panelJuego.getPanelControles();
    }
}