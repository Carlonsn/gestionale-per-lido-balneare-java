package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListaOmbrelloniDao;
import model.Ombrellone;

/**
 * Servlet implementation class ListaOmbrelloni
 */
@WebServlet("/ListaOmbrelloni")
public class ListaOmbrelloni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaOmbrelloni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		

		String data_pren = request.getParameter( "data_pren" );
		
       
		ListaOmbrelloniDao ombrelloniDisponibili = new ListaOmbrelloniDao();
		ArrayList<Ombrellone> ombrelloni = ombrelloniDisponibili.listaOmbrelloni( data_pren );
		
        if( !ombrelloni.isEmpty() ) {
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>ID</th>"
        			+ "<th>Riga</th>"
        			+ "<th>Posto</th>"
        			+ "<th>Prezzo</th>"
        			+ "<th>Prenota</th>"
        			+ "</tr>");
        	

        	for( int i = 0; i < ombrelloni.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + ombrelloni.get( i ).getId() + "</td>"
        				+ "<td>" + ombrelloni.get( i ).getRiga() + "</td>"
        				+ "<td>" + ombrelloni.get( i ).getPosto() + "</td>"
        				+ "<td>" + ombrelloni.get( i ).getPrezzo() + "</td>"
        				+ "<td><i class=\"fas fa-cart-plus\" id=\"" + ombrelloni.get( i ).getId() + "\"></i></td>"
       					+ "</tr>");
        	}
        	
        	out.write( "</table>" );
        }
        
        else {
        	
        	out.write( "Non ci sono ombrelloni disponibili per il giorno selezionato");        	
        }        	
	}	
}


