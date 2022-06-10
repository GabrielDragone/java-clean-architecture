package br.com.alura.escola.infra;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoRepository;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Telefone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlunoRepositoryJDBC implements AlunoRepository {

    private final Connection connection;

    // Quem for instanciar essa classe, vai ser responsável por passar essa connection.
    // Ou seja, não será a classe ALunoRepositoryJDBC que vai se preocupar com isso.
    // Inversão de depêndencia.
    public AlunoRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf()); // Primeiro "?"
            ps.setString(2, aluno.getNome()); // Segundo "?"
            ps.setString(3, aluno.getEmail()); // Terceiro "?"
            ps.execute(); // Dispara o INSERT lá no banco de dados

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone: aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());  // Primeiro "?"
                ps.setString(2, telefone.getNumero()); // Segundo "?"
                ps.execute(); // Dispara o INSERT lá no banco de dados
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarAlunoPorCPF(CPF cpf) {
        try {
            String sql = "SELECT * FROM ALUNO WHERE CPF = '" + cpf.getNumero() + "'";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            String sql = "SELECT * FROM ALUNO";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
