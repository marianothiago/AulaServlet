package br.fat.aulaservlet.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fat.aulaservlet.dao.Database;
import br.fat.aulaservlet.model.Aluno;
import br.fat.aulaservlet.model.Usuario;

/**
 * Servlet implementation class CadastrarUsuarioServ
 */
@WebServlet(name="/CadastrarAluno",urlPatterns={"/cadastraraluno"})
public class CadastrarAluno extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Aluno al = new Aluno(req.getParameter("nome"), req.getParameter("matricula"), req.getParameter("email"), req.getParameter("tel"));
	    Database.alunos.add (al);
	    req.getSession().setAttribute("mensagem", "Aluno cadastrado com sucesso.");
	    resp.sendRedirect("/AulaServlet/message.jsp");
	}
}
