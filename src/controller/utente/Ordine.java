package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrdinazioneDao;
import model.CarrelloBean;
import model.Ordinazione;


/**
 * Servlet implementation class Carrello
 */
@WebServlet("/Ordine")
public class Ordine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ordine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dataOrd = request.getParameter( "dataToday" );
		String oraOrd = request.getParameter( "oraToday" );
		
		HttpSession session = request.getSession();
		
		CarrelloBean c = (CarrelloBean) session.getAttribute("carrello"); 
		
		String ordine ="";
		int i = 0;
		for( ; i < c.getLista().size()-1; ++i ) {
			ordine += c.getLista().get( i ).getNome() + ", ";
		}
		ordine += c.getLista().get( i ).getNome();
		
		Ordinazione ord = new Ordinazione();
		
		ord.setData_ord( dataOrd );
		ord.setOra_ord( oraOrd );
		ord.setTotale( c.getTotale() );
		ord.setUser( request.getRemoteUser() );
		ord.setOrdine( ordine ); 
		
		OrdinazioneDao ordDao = new OrdinazioneDao();
		
		String result = ordDao.insert( ord );
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("<p>" + result + "</p>" );
		
		session.removeAttribute("carrello");
	}
}

