package br.com.alura.escola.dominio.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FabricaDeAlunoTest {

    @Test
    public void deveCriarAluno() {
        String nome = "Gabriel Alves";
        String cpf = "123.456.789-10";
        String email = "gabriel.alves@email.com";
        String ddd = "13";
        String numero = "12345678";

        FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();
        Aluno alunoCriado = fabricaDeAluno.comNomeCFPEmail(nome, cpf, email)
                .comTelefone(ddd, numero)
                .criar();

        assertEquals(nome, alunoCriado.getNome());
        assertEquals(cpf, alunoCriado.getCpf().getNumero());
        assertEquals(email, alunoCriado.getEmail().getEndereco());
        assertEquals(ddd, alunoCriado.getTelefones().get(0).getDdd());
        assertEquals(numero, alunoCriado.getTelefones().get(0).getNumero());
    }

}