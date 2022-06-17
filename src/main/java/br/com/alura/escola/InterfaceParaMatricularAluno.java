package br.com.alura.escola;

import br.com.alura.escola.aplicacao.indicacao.MatricularAluno;
import br.com.alura.escola.aplicacao.indicacao.MatricularAlunoDto;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoRepository;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.infra.aluno.AlunoRepositoryEmMemoria;

public class InterfaceParaMatricularAluno {

    public static void main(String[] args) {

        try {
            //modoAntigo(); // Era assim antes de implementar a regra dentro da aplicação > MatricularAluno.

            // Após isolar o trecho de código, utilizando padrão Use Case/Service e DTO.
            // Dessa forma, sempre seguiremos um padrão qnd for implementado outras interfaces, como endpoints.
            modoNovo();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }

    }

    private static void modoNovo() {
        String nome = "Gabriel Dragone";
        String cpf ="123.456.789-10";
        String email = "gabriel.dragone@email.com";

        AlunoRepository repository = new AlunoRepositoryEmMemoria();
        MatricularAluno matricularAluno = new MatricularAluno(repository);
        MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);
        matricularAluno.executar(dto);
    }

    private static void modoAntigo() {
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
    }

}
