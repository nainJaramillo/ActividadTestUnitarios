package es.fplumara.dam1.operaciones;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import es.fplumara.dam1.operaciones.Operaciones;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class OperacionesMediaTest {

    @ParameterizedTest
    @MethodSource("Media")
    @DisplayName("Media con notas distintas")
    void testMedia(double[] notas, double esperado) {
        double resultado = Operaciones.media(notas);
        assertEquals(esperado, resultado, 0.0001);

    }

    static Stream<Arguments> Media() {
        return Stream.of(
                Arguments.of(new double[]{5.0, 7.0}, 6.0),
                Arguments.of(new double[]{10.0}, 10.0),
                Arguments.of(new double[]{0.0, 0.0, 0.0}, 0.0)
        );
    }

    void mediaConAseertAll(){
        assertAll(
                () -> assertEquals(6.0, Operaciones.media(5.0, 7.0), 0.0001),
                () -> assertEquals(10.0, Operaciones.media(10.0), 0.0001),
                () -> assertEquals(0.0, Operaciones.media(0.0, 0.0, 0.0), 0.0001)
        );
    }
    void mediaNull(){
        assertThrows(IllegalArgumentException.class,
                () -> Operaciones.media((double[]) null));
    }
}
