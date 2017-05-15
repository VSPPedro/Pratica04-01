package br.edu.ifpb.pweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ValidaLoginServlet
 */
@WebServlet("/valide")
public class ValidaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidaLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties passwdFile;
		passwdFile = new Properties();
		try{
			passwdFile.load(this.getServletContext().getResourceAsStream("/WEB-INF/senhas.properties"));
		} catch(IOException e) {
			response.sendError( response.SC_BAD_REQUEST, "Erro ao ler arquivo de senhas!");
			return;  //cai fora do servlet
		}
		
		// pega os parâmetros fornecidos pelo formulário
		String login = request.getParameter("login");
		String senha= request.getParameter("senha");
		
		// verificaseo usuário é valido
		if (passwdFile.containsKey(login) && senha.equals(passwdFile.get(login))) {
			request.setAttribute("login", login);
			request.getRequestDispatcher("loginValido.jsp").forward(request, response);
		} else{
			response.sendRedirect("index.html");
		}
		
		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Login:"+login+"</h1>");
		out.println("<h1>Senha:"+senha+"</h1>");
		out.println("</html></body>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
