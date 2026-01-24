package es.fplumara.dam1.coche;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CocheServiceTest {

    private CocheService cocheService = new CocheService(null); // null porque no necesitamos repo aquí

    @ParameterizedTest
    @ValueSource(strings = {"1234ABC", "0000ZZZ", "9876QWE"})
    void testValidaMatriculaValida(String matricula) {
        assertTrue(cocheService.validaMatricula(matricula));
    }

    @ParameterizedTest
    @CsvSource({
            "123ABC",
            "12345ABC",
            "1234AB",
            "1234A1C",
            "1234-ABC",
            "1234 ABC",
            "1234abc"
    })
    void testValidaMatriculaInvalida(String matricula) {
        assertFalse(cocheService.validaMatricula(matricula));
    }
}
