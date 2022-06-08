package br.com.alura.escola.aluno;

import br.com.alura.escola.aluno.Telefone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneTest {

    @Test
    public void naoDeveCadastrarTelefoneComDddInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("", null));
        assertThrows(IllegalArgumentException.class, () -> new Telefone("41", null));
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

    @Test
    public void deveCadastrarTelefoneComDddENumeroValidosComAssert() {
        String ddd = "41";
        String numero = "998858861";

        Telefone telefone = new Telefone(ddd, numero);

        assertEquals(ddd, telefone.getDdd());
        assertEquals(numero, telefone.getNumero());
    }

}