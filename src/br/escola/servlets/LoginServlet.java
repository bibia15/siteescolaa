package br.escola.servlets;

import br.escola.dao.AlunoDAO;
import br.escola.model.Aluno;
import br.escola.util.SecurityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AlunoDAO dao = new AlunoDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");

        String hash = SecurityUtil.sha256(senha);

        Aluno aluno = dao.validarLogin(usuario, hash);
        if (aluno != null) {
            HttpSession session = req.getSession(true);
            // guardar dados básicos em sessão para o painel
            session.setAttribute("usuario", aluno.getUsuario());
            session.setAttribute("nome", aluno.getNome());
            session.setAttribute("turma", aluno.getTurma());
            session.setAttribute("matricula", aluno.getMatricula());
            session.setAttribute("turno", aluno.getTurno());
            resp.sendRedirect("aluno.jsp");
        } else {
            // redireciona de volta com erro
            resp.sendRedirect("login.html?erro=1");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.html");
    }
}
