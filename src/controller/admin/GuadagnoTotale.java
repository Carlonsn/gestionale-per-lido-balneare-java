package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuadagniDao;

/**
 * Servlet implementation class GuadagnoTotale
 */
@WebServlet("/GuadagnoTotale")
public class GuadagnoTotale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuadagnoTotale() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		
		String dataToday = request.getParameter( "dataToday" );
		
		GuadagniDao guadagni = new GuadagniDao();
		
		double totale = guadagni.viewGuadagnoTotale( dataToday );
		
		out.write("&euro; " + " " + totale);
	}

}
