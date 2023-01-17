package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.CarrelloBean;


/**
 * Servlet implementation class RimuoviCarrello
 */
@WebServlet("/RimuoviCarrello")
public class RimuoviCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviCarrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		

		
		HttpSession session = request.getSession();
		CarrelloBean carrello = ( CarrelloBean ) session.getAttribute( "carrello" );
			
		if( carrello == null || carrello.getLista().size() == 0 ) {
			out.write( "<p>Il carrello è vuoto</p>" );
		}
		else {
				
			try {
				int idProd = Integer.parseInt( request.getParameter( "idProd" ) );				
				
				 carrello.setTotale(carrello.getTotale() - carrello.getLista().get(idProd).getPrezzo() );
				 carrello.getLista().remove( idProd );
			
				}
				catch( Exception e){
					out.write("<p>Errore</p>");
				}
	
			}

	}
}
