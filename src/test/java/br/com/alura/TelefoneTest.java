package br.com.alura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    public void naoDeveCadastrarTelefoneComDddInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("4", null));
    }

    @Test
    public void naoDeveCadastrarTelefoneComNumeroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone("41", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("41", ""));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("41", "123"));
    }

    @Test
    public void deveCadastrarTelefoneComDddENumeroValidos() {
        assertDoesNotThrow(() -> new Telefone("41", "998858861"));
        assertDoesNotThrow(() -> new Telefone("13", "38641091"));
    }

}