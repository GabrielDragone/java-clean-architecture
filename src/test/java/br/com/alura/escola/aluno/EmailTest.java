package br.com.alura.escola.aluno;

import br.com.alura.escola.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    public void naoDeveriaCriarEmailsComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    public void deveCriarEmailsComEnderecosValidos() {
        assertDoesNotThrow(() -> new Email("gabriel.alves@email.com"));
        assertDoesNotThrow(() -> new Email("helo.fagundes@email.com.br"));
    }

}