package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PrenotazioneDao;
import model.Ombrellone;


/**
 * Servlet implementation class ConfermaPrenotazione
 */
@WebServlet("/ConfermaPrenotazione")
public class ConfermaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfermaPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		
		int idOmbr;
		String dataPren = request.getParameter( "dataPren" );
		
		try {
			idOmbr = Integer.parseInt( request.getParameter( "idOmbr" ) );
			
		}
		catch( Exception e ) {
			idOmbr = 0;
		}
		
		
		Ombrellone ombr = new Ombrellone();
		ombr.setId( idOmbr );
		ombr.setData( dataPren );
		
		PrenotazioneDao confermaPagamento = new PrenotazioneDao();
		String result = confermaPagamento.setInfoOmbr( ombr );
		
		if( result == "SUCCESS") {
			HttpSession session = request.getSession();
			session.setAttribute( "ombrellone", ombr );
			
			out.write("SUCCESS");
		}
		else {
			
			out.write("Errore");
		}	
	}
}
