package br.com.alura.escola;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoRepository;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.infra.aluno.AlunoRepositoryEmMemoria;

public class MatricularAluno {

    public static void main(String[] args) {

        try {
            // Estamos simulando uma aplicação, sem a parte de Input, diretamente no código:
            // Imagina como se fosse uma API, aqui estamos preocupados apenas com fluxo.
            String nome = "Gabriel Dragone";
//            CPF cpf = new CPF("123.456.789-10");
        CPF cpf = new CPF("123.456.789"); // Devido à validação, isso vai dar erro.
            Email email = new Email("gabriel.dragone@email.com");
//        Email email = new Email("gabriel.dragoneemail.com"); // Devido à validação, isso vai dar erro.

            Aluno aluno = new Aluno(cpf, nome, email);

            AlunoRepository repository = new AlunoRepositoryEmMemoria();
            repository.matricular(aluno);

            System.out.println("Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }

    }

}
