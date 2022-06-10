package br.com.alura.escola.infra;

import br.com.alura.escola.dominio.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            String sql = "SELECT id, nome, email FROM ALUNO WHERE CPF = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet rs = ps.executeQuery(); // Como é uma consulta, precisamos usar o ResultSet com executeQuery

            boolean encontrou = rs.next();
            if (!encontrou) {
                // Essa exception está dentro do pacote de Dominio, mas não tem problema, pois no Clean Archicteture,
                // podemos acessar as classes INTERNAS através das EXTERNAS. Ao contrário não poderia.
                throw new AlunoNaoEncontradoException(cpf);
            }

            String nome = rs.getString("nome");
            Email email = new Email(rs.getString("email"));
            Aluno aluno = new Aluno(cpf, nome, email);

            Long idAluno = rs.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            PreparedStatement psTelefone = connection.prepareStatement(sql);
            ps.setLong(1, idAluno);
            ResultSet rsTelefone = psTelefone.executeQuery(); // Como é uma consulta, precisamos usar o ResultSet com executeQuery

            while (rsTelefone.next()) { // Percorre a lista para atribuir os valores do Telefone do Aluno.
                String ddd = rsTelefone.getString("ddd");
                String numero = rsTelefone.getString("numero");
                aluno.adicionarTelefone(ddd, numero);
            }

            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        try {
            List<Aluno> listaAlunos = new ArrayList<>();

            String sql = "SELECT id, nome, email FROM ALUNO";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CPF cpf = new CPF(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);

                Long idAluno = rs.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                PreparedStatement psTelefone = connection.prepareStatement(sql);
                ps.setLong(1, idAluno);
                ResultSet rsTelefone = psTelefone.executeQuery(); // Como é uma consulta, precisamos usar o ResultSet com executeQuery

                while (rsTelefone.next()) { // Percorre a lista para atribuir os valores do Telefone do Aluno.
                    String ddd = rsTelefone.getString("ddd");
                    String numero = rsTelefone.getString("numero");
                    aluno.adicionarTelefone(ddd, numero);
                }

                listaAlunos.add(aluno);
            }

            return listaAlunos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
