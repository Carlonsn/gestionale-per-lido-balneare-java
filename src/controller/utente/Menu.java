package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProdottoDao;
import model.Prodotto;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

		ProdottoDao prodotto = new ProdottoDao();
		ArrayList<Prodotto> menu = prodotto.viewMenu();
		
        	out.write( "<table class=\"form\">"
        			+ "<tr>"
        			+ "<th>ID</th>"
        			+ "<th>Prodotto</th>"
        			+ "<th>Prezzo</th>"
        			+ "</tr>");
        	

        	for( int i = 0; i < menu.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + menu.get( i ).getId() + "</td>"
        				+ "<td> <b>" + menu.get( i ).getNome() + "</b> </td>"
        				+ "<td>" + menu.get( i ).getPrezzo() + "</td>"
        				+ "<td><i class=\"fas fa-plus-square\" id=\"" + menu.get( i ).getId() + "\"></i></td>"
       					+ "</tr>"
       					+ "<tr><td></td><td>" + menu.get( i ).getDesc() + "</td>");
        	}
        	
        	out.write( "</table>" );
        }
            	
}

