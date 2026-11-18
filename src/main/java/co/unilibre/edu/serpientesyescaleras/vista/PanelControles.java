package co.unilibre.edu.serpientesyescaleras.vista;

import co.unilibre.edu.serpientesyescaleras.modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelControles extends JPanel {

    private JLabel lblTurno;
    private PanelDado panelDado;
    private JButton btnLanzar;
    private JTextArea areaMensajes;

    public PanelControles() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(220, 0));

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));

        lblTurno = new JLabel("Turno de: -");
        lblTurno.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTurno.setFont(lblTurno.getFont().deriveFont(Font.BOLD, 14f));

        panelDado = new PanelDado();
        panelDado.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnLanzar = new JButton("Lanzar dado");
        btnLanzar.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelSuperior.add(lblTurno);
        panelSuperior.add(Box.createVerticalStrut(10));
        panelSuperior.add(panelDado);
        panelSuperior.add(Box.createVerticalStrut(10));
        panelSuperior.add(btnLanzar);

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        areaMensajes.setLineWrap(true);

        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(areaMensajes), BorderLayout.CENTER);
    }

    public void actualizarTurno(Jugador jugador) {
        lblTurno.setText("Turno de: " + jugador.getNombre());
    }

    public void actualizarDado(int valor) {
        panelDado.setValor(valor);
    }

    public void agregarMensaje(String mensaje) {
        areaMensajes.append(mensaje + "\n");
    }

    public JButton getBtnLanzar() {
        return btnLanzar;
    }
}