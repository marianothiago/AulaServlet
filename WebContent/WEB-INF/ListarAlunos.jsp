<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@page import="java.util.Iterator" %>
    <%@page import="br.fat.aulaservlet.model.Aluno" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Lista de alunos</h1>
	
	<%List alunos = (List) request.getAttribute("Alunos"); %>
	<%if (alunos.size()>0 ){
	out.println("<table>");
	out.println("<tr><td>Nome</td><td>Matricula</td><td>Email</td><td>Telefone</td></tr>");
	Iterator itr=alunos.iterator();
	while(itr.hasNext()){
		Aluno alu = (Aluno) itr.next();
		out.println("<tr><td>"+alu.getNome()+"</td><td>"+alu.getMatricula()+"</td><td>" + alu.getEmail()+ "</td> <td>" + alu.getTel()+"</td></tr>");
	}
	out.println("</table>");
	
	}else 
	{
		out.println ("<h1> Não tem Alunos </h1>");
	}
	%>
	<table></table>	
</body>
</html>