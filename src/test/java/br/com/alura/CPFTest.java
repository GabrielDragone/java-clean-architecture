package br.com.alura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void deveCriarCPFComNumerosValidosComAssert() {
        String numeroCfp = "123.456.789-10";

        CPF cpf = new CPF(numeroCfp);

        assertEquals(numeroCfp, cpf.getNumero());
    }

}