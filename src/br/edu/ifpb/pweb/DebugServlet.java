package br.edu.ifpb.pweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DebugServlet
 */
@WebServlet("/debug")
public class DebugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DebugServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// pega os parâmetros fornecidos pelo formulário
		String login = request.getParameter("login");
		String senha= request.getParameter("senha");
		String method = request.getMethod();
		String servletName = request.getHeader(getServletName());
		String servletInfo = request.getHeader(getServletInfo());
		
		System.out.println("Login: " + login);
		System.out.println("Senha: " + senha);
		System.out.println("Method: " + method);
		System.out.println("Servlet Name: " + servletName);
		System.out.println("Servlet Infor: " + servletInfo);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
