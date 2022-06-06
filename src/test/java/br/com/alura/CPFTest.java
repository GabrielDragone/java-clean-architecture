package br.com.alura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CPFTest {

    @Test
    public void naoDeveriaCriarCPFComNumerosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("123"));
    }

    @Test
    public void deveCriarCPFComNumerosValidos() {
        assertDoesNotThrow(() -> new CPF("123.456.789-10"));
        assertDoesNotThrow(() -> new CPF("553.975.819-30"));
    }

}