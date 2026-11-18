package co.unilibre.edu.serpientesyescaleras;

import co.unilibre.edu.serpientesyescaleras.controlador.ControladorConfiguracion;
import co.unilibre.edu.serpientesyescaleras.vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        new ControladorConfiguracion(ventana);
        ventana.mostrar();
    }
}