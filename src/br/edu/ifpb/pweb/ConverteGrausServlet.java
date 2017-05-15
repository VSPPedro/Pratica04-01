package br.edu.ifpb.pweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConverteGrausServlet
 */
@WebServlet("/converte")
public class ConverteGrausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConverteGrausServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tp = request.getParameter("tp");
		String valor = request.getParameter("valor");
		
		double result;
		String titulo, temp1, temp2; 
		
		if (tp.equals("C"))
		{
			titulo = "Converter Celsius para Fahrenheit";
			temp1 = valor + " C";
			result = Double.parseDouble(valor)*1.8 + 32;
			temp2 = Double.toString(result) + " F";
		}
		else
		{
			titulo = "Converter Fahrenheit para Celsius";
			temp1 = valor + " F";
			result = (Float.parseFloat(valor) - 32)/1.8;
			temp2 = Double.toString(result) + " C";
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>"+titulo+"</h1>");
		out.println("<h2>Converter: "+temp1+"</h2>");
		out.println("<h2>Resultado: "+temp2+"</h2>");
		out.println("</html></body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
