package es.fplumara.dam1.facturacion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FacturaTest {

    @Mock
    Calculadora calculadora;

    @Test
    @DisplayName("totalConIva(100) devuelve 121")
    void testTotalConIva100() {

        when(calculadora.sumar(100, 21)).thenReturn(121);

        FacturaService service = new FacturaService(calculadora);

        int resultado = service.totalConIva(100);

        assertEquals(121, resultado);

        verify(calculadora, times(1)).sumar(100, 21);
        verifyNoMoreInteractions(calculadora);
    }

    @Test
    @DisplayName("totalConIva(0) devuelve 21")
    void testTotalConIva0() {
        when(calculadora.sumar(0, 21)).thenReturn(21);
        FacturaService service = new FacturaService(calculadora);

        int resultado = service.totalConIva(0);

        assertEquals(21, resultado);
        verify(calculadora, times(1)).sumar(0, 21);
        verifyNoMoreInteractions(calculadora);
    }
}

