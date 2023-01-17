package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuadagniDao;

/**
 * Servlet implementation class Guadagni
 */
@WebServlet("/Guadagni")
public class Guadagni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guadagni() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		String dataInizio = request.getParameter( "dataInizio" );
		String dataFine = request.getParameter( "dataFine" );
		String idButton = request.getParameter( "idButton" );
		
		GuadagniDao guadagni = new GuadagniDao();
		
		double totale = guadagni.viewGuadagni( dataInizio, dataFine, idButton);
		
		if( idButton.equals( "totPren" ))

				out.write( "<p>Guadagno da prenotazioni ombrelloni: &euro;" + totale + "</p>");
		
		if( idButton.equals( "totOrd" ))
			out.write( "<p>Guadagno da ordinazioni menu': &euro;" + totale + "</p>");
	}
}
