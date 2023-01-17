package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProdottoDao;
import model.CarrelloBean;
import model.Prodotto;


@WebServlet("/AggiuntaCarrello")
public class AggiuntaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiuntaCarrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		

		int idProd;
		
		try {
			idProd = Integer.parseInt( request.getParameter( "idProd" ) );
		}
		catch( Exception e ) {
			idProd = 0;
		}
		

		Prodotto prod = new Prodotto();
		prod.setId( idProd );

		ProdottoDao prodotto = new ProdottoDao();
		String rs = prodotto.setProdotto( prod );
		
		if( rs.equals( "SUCCESS" ) ) {
			
			HttpSession session = request.getSession();
			CarrelloBean carrello = ( CarrelloBean ) session.getAttribute( "carrello" );
			
			if( carrello == null ) {
				carrello = new CarrelloBean();
			}
			
			carrello.getLista().add( prod );
			double totale = carrello.getTotale() + prod.getPrezzo();
			carrello.setTotale( totale );
			
			session.setAttribute("carrello", carrello );
			out.write(prod.getNome() + " è stato aggiunto al carrello" );
		}

		else {
			out.write( "Errore" );

		}
	
	}
}
