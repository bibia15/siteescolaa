package br.escola.dao;

import br.escola.util.DBUtil;
import br.escola.model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlunoDAO {

    public Aluno validarLogin(String usuario, String senhaHash) {
        String sql = "SELECT id, nome, usuario, turma, matricula, turno FROM alunos WHERE usuario = ? AND senha_hash = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ps.setString(2, senhaHash);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Aluno a = new Aluno();
                    a.setId(rs.getInt("id"));
                    a.setNome(rs.getString("nome"));
                    a.setUsuario(rs.getString("usuario"));
                    a.setTurma(rs.getString("turma"));
                    a.setMatricula(rs.getString("matricula"));
                    a.setTurno(rs.getString("turno"));
                    return a;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
