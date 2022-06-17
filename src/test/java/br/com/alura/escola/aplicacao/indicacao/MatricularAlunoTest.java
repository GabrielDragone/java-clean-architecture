package br.com.alura.escola.aplicacao.indicacao;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoRepository;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.AlunoRepositoryEmMemoria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatricularAlunoTest {

    AlunoRepository repository;  // A cada teste, vai recomeçar
//    AlunoRepository repository = new AlunoRepositoryEmMemoria();

//    MatricularAluno matricularAluno = new MatricularAluno(repository);

    @BeforeEach
    public void beforceEach() {
        repository = new AlunoRepositoryEmMemoria(); // A cada teste, vai recomeçar
        System.out.println("beforeEach()");
    }

    @Test
    public void alunoDeveriaSerPersistidoEEncontradoPorCPFTest() {
        // MOCK -> Mockito: Poderiamos utilizar para simular a parte de Banco de Dados, mas como estamos usando em memória, não foi necessário.
        String nome = "Fulano";
        String cpf = "123.456.789-10";
        String email = "fulano@email.com";
        MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);

        MatricularAluno matricularAluno = new MatricularAluno(repository);
        matricularAluno.executar(dto);

        Aluno alunoEncontrado = repository.buscarAlunoPorCPF(new CPF(cpf));
        assertEquals(nome, alunoEncontrado.getNome());
        assertEquals(cpf, alunoEncontrado.getCpf());
        assertEquals(email, alunoEncontrado.getEmail());
    }

    @Test
    public void alunoDeveriaSerPersistidoTest() {
        String nome = "Fulano 123";
        String cpf = "123.456.789-12";
        String email = "fulano@email.com";
        MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);

        MatricularAluno matricularAluno = new MatricularAluno(repository);
        matricularAluno.executar(dto);

        List<Aluno> alunosEncontrados = repository.listarTodosAlunosMatriculados();
        assertEquals(1, alunosEncontrados.size());
        assertEquals(nome, alunosEncontrados.get(0).getNome());
        assertEquals(cpf, alunosEncontrados.get(0).getCpf());
        assertEquals(email, alunosEncontrados.get(0).getEmail());
    }

}