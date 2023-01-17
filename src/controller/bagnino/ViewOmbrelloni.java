package controller.bagnino;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListaOmbrelloniDao;
import model.Ombrellone;

/**
 * Servlet implementation class ViewOmbrelloni
 */
@WebServlet("/ViewOmbrelloni")
public class ViewOmbrelloni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOmbrelloni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		String dataToday = request.getParameter( "dataToday" );
		
		ListaOmbrelloniDao ombrelloniDisponibili = new ListaOmbrelloniDao();
		ArrayList<Ombrellone> ombrelloniD = ombrelloniDisponibili.vistaOmbrelloniDisponibili( dataToday );
		ArrayList<Ombrellone> ombrelloniO = ombrelloniDisponibili.vistaOmbrelloniOccupati( dataToday );
		
		if( !ombrelloniD.isEmpty() ) {
        	
        	out.write( "<p>Ombrelloni Disponibili</p><table>"
        			+ "<tr>"
        			+ "<th>ID</th>"
        			+ "<th>Riga</th>"
        			+ "<th>Posto</th>"
        			+ "</tr>");
        	
        	
        	for( int i = 0; i < ombrelloniD.size(); ++i ) {
        		out.write( "<tr>"
        				+ "<td>" + ombrelloniD.get( i ).getId() + "</td>"
        				+ "<td>" + ombrelloniD.get( i ).getRiga() + "</td>"
        				+ "<td>" + ombrelloniD.get( i ).getPosto() + "</td>"
       					+ "</tr>");
        	}
        	
        	out.write( "</table><br /><br />" );
        	
        	if( !ombrelloniO.isEmpty() ) {
            	
            	out.write( "<p>Ombrelloni Occupati</p><table>"
            			+ "<tr>"
            			+ "<th>ID</th>"
            			+ "<th>Riga</th>"
            			+ "<th>Posto</th>"
            			+ "<th>Utente</th>"
            			+ "</tr>");
            	
            	for( int i = 0; i < ombrelloniO.size(); ++i ) {
            		out.write( "<tr>"
            				+ "<td>" + ombrelloniO.get( i ).getId() + "</td>"
            				+ "<td>" + ombrelloniO.get( i ).getRiga() + "</td>"
            				+ "<td>" + ombrelloniO.get( i ).getPosto() + "</td>"
            				+ "<td>" + ombrelloniO.get( i ).getUser() + "</td>"
           					+ "</tr>");
            	}
        	
        	out.write( "</table>" );
        	}		
        }
    }
}
