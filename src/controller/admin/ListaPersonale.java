package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.Utente;

/**
 * Servlet implementation class ListaUtenti
 */
@WebServlet("/ListaPersonale")
public class ListaPersonale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaPersonale() {
        super();
        
    }

	

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        
		String ruolo = "U"; // Ruolo che non dobbiamo visualizzare, visto che questa servlet visualizzara' solo il personale
		UserDao p = new UserDao();
		ArrayList<Utente> personale = p.listaPersonale(ruolo);   
        	
        	out.write( "<table>"
        			+ "<tr>"
        			+ "<th>Username</th>"
        			+ "<th>Ruolo</th>"
        			+ "</tr>");
        	
        	for( int i = 0; i < personale.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + personale.get( i ).getUsername() + "</td>"	
        				+ "<td>" + personale.get( i ).getRuolo() + "</td>"
       					+ "</tr>");
        	}
        	
        	out.write( "</table>" );
        }
        
    
		
	}
