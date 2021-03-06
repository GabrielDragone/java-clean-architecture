package br.com.alura.escola.infra.aluno;

import br.com.alura.escola.infra.aluno.CifradorDeSenhaComMD5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CifradorDeSenhaComMD5Test {

    CifradorDeSenhaComMD5 cifradorDeSenhaComMD5 = new CifradorDeSenhaComMD5();;

    @Test
    void validarSenhaCifrada() {
        String senha = "Gabriel123#";
        String senhaCifrada = cifradorDeSenhaComMD5.cifrarSenha(senha);

        assertTrue(cifradorDeSenhaComMD5.validarSenhaCifrada(senhaCifrada, senha));
    }
}