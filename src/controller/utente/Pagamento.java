package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrenotazioneDao;
import model.Ombrellone;
import model.Prenotazione;

/**
 * Servlet implementation class Pagamento
 */
@WebServlet("/Pagamento")
public class Pagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagamento() {
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
		// TODO Auto-generated method stub
		
		String dataToday = request.getParameter( "dataToday" );
		
		Ombrellone o = (Ombrellone) request.getSession().getAttribute("ombrellone"); 
		
		Prenotazione pren = new Prenotazione();

		pren.setData_pren( dataToday );
		pren.setData( o.getData() );
		pren.setId_ombr( o.getId() );
		pren.setPrezzo( o.getPrezzo() );
		pren.setUser( request.getRemoteUser() );
		
		PrenotazioneDao prenDao = new PrenotazioneDao();
		
		String result = prenDao.insert( pren );
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<p>" + result + "</p>" );
		
	}
}
