package co.unilibre.edu.serpientesyescaleras.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DadoTest {

    @Test
    void lanzarDebeDevolverValorEntre1y6() {
        Dado dado = new Dado();
        for (int i = 0; i < 100; i++) {
            int valor = dado.lanzar();
            assertTrue(valor >= 1 && valor <= 6, "El valor del dado debe estar entre 1 y 6");
        }
    }

    @Test
    void getUltimoValorDebeCoincidirConElUltimoLanzamiento() {
        Dado dado = new Dado();
        int valor = dado.lanzar();
        assertEquals(valor, dado.getUltimoValor());
    }
}