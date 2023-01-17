package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrenotazioneDao;

/**
 * Servlet implementation class AnnullaPrenotazione
 */
@WebServlet("/AnnullaPrenotazione")
public class AnnullaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnullaPrenotazione() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idOmbr;
		
		try {
			 idOmbr = Integer.parseInt( request.getParameter( "idOmbr" ) );
			
		}
		catch( Exception e ) {
			 idOmbr = 0;
		}

		String data = request.getParameter("data");
		PrenotazioneDao prenotazioneDao = new PrenotazioneDao();
		String result = prenotazioneDao.annullaPrenotazione(idOmbr, data);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.write(result);
	}

}
