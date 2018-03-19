package br.fat.aulaservlet.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.fat.aulaservlet.model.Usuario;

@WebFilter(filterName="FiltroAutenticacao",urlPatterns = {"/ListarAlunos","/CadastrarAluno.html"})
public class FiltroAutenticacao implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		Usuario user = (Usuario)request.getSession().getAttribute("usuario");
		if(user != null) {
			chain.doFilter(req, resp);
		}else {
			response.sendRedirect("/AulaServlet/login.html");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
