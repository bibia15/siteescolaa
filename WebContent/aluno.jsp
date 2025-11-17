<%@ page import="javax.servlet.http.*" %>
<%
  HttpSession sess = request.getSession(false);
  if (sess == null || sess.getAttribute("usuario") == null) {
    response.sendRedirect("login.html");
    return;
  }
  String nome = (String) sess.getAttribute("nome");
  String usuario = (String) sess.getAttribute("usuario");
  String turma = (String) sess.getAttribute("turma");
  String matricula = (String) sess.getAttribute("matricula");
  String turno = (String) sess.getAttribute("turno");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <title>Painel - <%= nome %></title>
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header>
  <h1>Bem-vindo, <%= nome %></h1>
  <a href="logout" class="btn-logout">Sair</a>
</header>

<main class="container">
  <section>
    <h2>Dados do Aluno</h2>
    <p><b>Usuário:</b> <%= usuario %></p>
    <p><b>Turma:</b> <%= turma %></p>
    <p><b>Matrícula:</b> <%= matricula %></p>
    <p><b>Turno:</b> <%= turno %></p>
  </section>

  <section>
    <h2>Boletim</h2>
    <!-- aqui você pode buscar notas no BD e exibir dinamicamente -->
    <table>
      <tr><th>Disciplina</th><th>Nota</th></tr>
      <tr><td>Português</td><td>8.5</td></tr>
      <tr><td>Matemática</td><td>7.8</td></tr>
      <tr><td>História</td><td>9.0</td></tr>
    </table>
  </section>

  <section>
    <h2>Avisos</h2>
    <ul>
      <li>Prova final: 07/12</li>
      <li>Entrega do TCC: 05/12</li>
    </ul>
  </section>
</main>
</body>
</html>
