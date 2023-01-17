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
 * Servlet implementation class MostraCarrello
 */
@WebServlet("/MostraCarrello")
public class MostraCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraCarrello() {
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
		
		if( carrello == null || carrello.getLista().size() == 0 ){ 	
			out.write( "<p>Il carrello è vuoto</p>" );
		}
		else {
			out.write( "<table>");
			
			for( int i = 0; i < carrello.getLista().size(); ++i ) {
				out.write( "<tr>"
						+ "<td>" + carrello.getLista().get( i ).getNome() + "</td>"
						+ "<td>&euro;" + carrello.getLista().get( i ).getPrezzo() + " <i class=\"fas fa-minus-square\" id=\"" + i + "\"></i></td>"
						+ "</tr>");
			}
			
			out.write( "<tr>"
					+ "<td>TOTALE</td>"
					+ "<td>&euro;" + carrello.getTotale() + "</td>"
					+ "</tr>"
					+ "</table>" );
		}
	}
}


