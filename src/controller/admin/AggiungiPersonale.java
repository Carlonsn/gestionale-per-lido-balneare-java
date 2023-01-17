package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import model.Utente;

/**
 * Servlet implementation class AggiungiBagnino
 */
@WebServlet("/AggiungiPersonale")
public class AggiungiPersonale extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiPersonale() {
    	
        super();
        
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String ruolo = request.getParameter("ruolo");

		
		Utente personale = new Utente();
		
		personale.setUsername(username);
		personale.setNome(nome);
		personale.setCognome(cognome);
		personale.setEmail(email);
		personale.setPassword(password);
		personale.setRuolo(ruolo);
		
		UserDao uDao = new UserDao();
		String result = uDao.insert(personale);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		out.write(result);
	}

	
}


