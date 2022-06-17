package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;

// DTO: Data Transfer Object, vai ser a classe responsável por transferir os dados através de endpoint.
// A ideia da mesma é abstrair o objeto em menor tamanho para evitar que muitos dados desnecessários sejam transferidos de um lado para o outro.
public class MatricularAlunoDto {
    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    // O próprio DTO será responsável pela criação do Aluno e irá retornar para as classes utilizadas, encapsulando assim esses
    // parâmetros primitivos:
    public Aluno criarAluno() {
        return new Aluno(
                new CPF(cpfAluno),
                nomeAluno,
                new Email(emailAluno)
        );
    }
}
