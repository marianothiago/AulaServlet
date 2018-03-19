package br.fat.aulaservlet.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fat.aulaservlet.dao.Database;
import br.fat.aulaservlet.model.Usuario;

/**
 * Servlet implementation class CadastrarUsuarioServ
 */
@WebServlet(name="/CadastrarUsuarioServ",urlPatterns={"/cadastrarUsuario"})
public class CadastrarUsuarioServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    Usuario user = new Usuario(req.getParameter("login"), req.getParameter("senha"));
	    Database.usuarios.add(user);
	}
}
