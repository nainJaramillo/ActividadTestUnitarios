package es.fplumara.dam1.operaciones;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperacionesTestCalificacion {

    @ParameterizedTest
    @CsvSource({
            "4.99, INSUFICIENTE",
            "5.0, APROBADO",
            "6.99, APROBADO",
            "7.0, NOT, NOTABLE",
            "9.0, SOBRESALIENTE",
            "10.0, SOBRESALIENTE"

    })
    @DisplayName("Comprueba las notas")
    public void clasificacionNotasValidas(double nota, String resultadoEsperado) {
        String resultado = Operaciones.calificacion(nota);
        assertEquals(resultadoEsperado,resultado);

    }
}
