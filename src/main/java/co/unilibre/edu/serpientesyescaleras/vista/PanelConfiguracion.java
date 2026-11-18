package co.unilibre.edu.serpientesyescaleras.vista;

import javax.swing.*;
import java.awt.*;

public class PanelConfiguracion extends JPanel {

    private JComboBox<Integer> comboCantidad;
    private JPanel panelNombres;
    private JTextField[] camposNombres;
    private JButton btnIniciar;

    private static final String[] COLORES = {"rojo", "azul", "verde", "amarillo"};

    public PanelConfiguracion() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        JLabel titulo = new JLabel("Serpientes y Escaleras", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 26f));

        JPanel panelSuperior = new JPanel(new FlowLayout());
        panelSuperior.add(new JLabel("Número de jugadores:"));
        comboCantidad = new JComboBox<>(new Integer[]{2, 3, 4});
        comboCantidad.addActionListener(e -> actualizarCampos());
        panelSuperior.add(comboCantidad);

        panelNombres = new JPanel();
        panelNombres.setLayout(new GridLayout(4, 1, 5, 5));

        btnIniciar = new JButton("Iniciar partida");
        btnIniciar.setFont(btnIniciar.getFont().deriveFont(Font.BOLD, 14f));

        JPanel norte = new JPanel(new BorderLayout());
        norte.add(titulo, BorderLayout.NORTH);
        norte.add(panelSuperior, BorderLayout.CENTER);

        add(norte, BorderLayout.NORTH);
        add(panelNombres, BorderLayout.CENTER);
        add(btnIniciar, BorderLayout.SOUTH);

        actualizarCampos();
    }

    private void actualizarCampos() {
        int cantidad = (Integer) comboCantidad.getSelectedItem();
        panelNombres.removeAll();
        camposNombres = new JTextField[cantidad];

        for (int i = 0; i < cantidad; i++) {
            JPanel fila = new JPanel(new BorderLayout(5, 0));
            JLabel etiqueta = new JLabel("Jugador " + (i + 1) + " (" + COLORES[i] + "):");
            JTextField campo = new JTextField("Jugador " + (i + 1));
            camposNombres[i] = campo;
            fila.add(etiqueta, BorderLayout.WEST);
            fila.add(campo, BorderLayout.CENTER);
            panelNombres.add(fila);
        }

        panelNombres.revalidate();
        panelNombres.repaint();
    }

    public int getCantidadJugadores() {
        return (Integer) comboCantidad.getSelectedItem();
    }

    public String[] getNombres() {
        String[] nombres = new String[camposNombres.length];
        for (int i = 0; i < camposNombres.length; i++) {
            String texto = camposNombres[i].getText().trim();
            nombres[i] = texto.isEmpty() ? ("Jugador " + (i + 1)) : texto;
        }
        return nombres;
    }

    public String getColorPara(int indice) {
        return COLORES[indice];
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }
}