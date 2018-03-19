package br.fat.aulaservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fat.aulaservlet.dao.Database;
import br.fat.aulaservlet.model.Usuario;

@WebServlet(name="Autenticacao",urlPatterns= {"/autenticacao","/autentique","/ListarAlunos"})
public class FirstServlet extends HttpServlet{

		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("Alunos", Database.alunos);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/ListarAlunos.jsp");        		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		PrintWriter out = resp.getWriter();
						
        List<Usuario> usuarios = Database.usuarios;

        boolean achouUsuario = false;
        Usuario usuarioLogado = null;
        for (Usuario user : usuarios) {
        	if(user.getUsuario().equals(login)){
        		achouUsuario = true;
        		usuarioLogado = user;
        		break;
        	}
        }
        
        if(achouUsuario) {
        	if(usuarioLogado.getSenha().equals(senha)) {
        		req.setAttribute("Alunos", Database.alunos);
        		req.getSession().setAttribute("usuario", usuarioLogado);
        		RequestDispatcher dispatcher = req.getRequestDispatcher("/ListarAlunos.jsp");        		
        		dispatcher.forward(req, resp);
        	}
        else {
        		req.getSession().setAttribute("mensagem", "Senha não confere");
        		resp.sendRedirect("/AulaServlet/message.jsp");
        	}
        }else {
        	req.getSession().setAttribute("mensagem", "Usuário não existe");
    		resp.sendRedirect("/AulaServlet/message.jsp");			
        }
	}
}
