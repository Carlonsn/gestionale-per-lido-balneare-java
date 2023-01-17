package controller.cuoco;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListaOrdinazioniDao;
import model.Ordinazione;

/**
 * Servlet implementation class ListaOrdinazioni
 */
@WebServlet("/ListaOrdinazioni")
public class ListaOrdinazioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaOrdinazioni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		String data_ord = request.getParameter( "dataToday" );
		
		ListaOrdinazioniDao ordini = new ListaOrdinazioniDao();
		ArrayList<Ordinazione> ordinazioni = ordini.listaOrdinazioni( data_ord );
		
        if( !ordinazioni.isEmpty() ) {
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>Ora</th>"
        			+ "<th>Ordine</th>"
        			+ "<th>Utente</th>"
        			+ "</tr>");
        	

        	for( int i = 0; i < ordinazioni.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + ordinazioni.get( i ).getOra_ord() + "</td>"
        				+ "<td>" + ordinazioni.get( i ).getOrdine() + "</td>"
        				+ "<td>" + ordinazioni.get( i ).getUser() + "</td>"
       					+ "</tr>");
        	}
        	
        	out.write( "</table>" );
        }
        
        else {
        	out.write("<p>Non ci sono ordinazioni per il giorno corrente</p>");
        }
		
	}
}
