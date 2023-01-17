package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrenotazioneDao;
import model.Prenotazione;


/**
 * Servlet implementation class ListaUtenti
 */
@WebServlet("/ListaPrenotazioni")
public class ListaPrenotazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPrenotazioni() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        
		PrenotazioneDao pren = new PrenotazioneDao();
		ArrayList<Prenotazione> prenotazioni = pren.listaPrenotazioni();   
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>ID Prenotazione</th>"
        			+ "<th>Data</th>"
        			+ "<th>Username</th>"
        			+ "<th>ID Ombrellone</th>"
        			+ "</tr>");
        	
        	for( int i = 0; i < prenotazioni.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + prenotazioni.get( i ).getId_pren() + "</td>"	
        				+ "<td>" + prenotazioni.get( i ).getData() + "</td>"
        				+ "<td>" + prenotazioni.get( i ).getUser() + "</td>"
        				+ "<td>" + prenotazioni.get( i ).getId_ombr() + "</td>"
       					+ "</tr>");
        	}
        	
        	out.write( "</table>" );
        }
}
