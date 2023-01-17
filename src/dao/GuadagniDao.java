package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class GuadagniDao {

	public double viewGuadagni(String dataInizio, String dataFine, String idButton) {
	    	
	    	String queryord ="SELECT sum(TOTALE) AS totOrd FROM ordinazione WHERE DATA_ORD >= ? && DATA_ORD <= ?";
	    	String querypren ="SELECT sum(REF_PREZZO_OMBR) AS totPren FROM prenotazione WHERE DATA_PREN >= ? && DATA_PREN <= ?";
	    	String query="";
	    	double totale = 0;
	    	
	    	
	    	if (idButton.equals("totPren"))
	    		query = querypren;
	    	if (idButton.equals("totOrd"))
    			query = queryord;
    	
	    	 try {
	    
	     		Context ctx = new InitialContext();
	     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
	     		
	         	try (Connection connection = ds.getConnection(); 
	         		PreparedStatement ps = connection.prepareStatement( query );
	         		)
	         		
	         	{
	         		ps.setString(1, dataInizio);
	         		ps.setString(2, dataFine);
	         	
	         		try (ResultSet rs = ps.executeQuery()) {
	         			while(rs.next() ) {
	         				if (idButton.equals("totPren") ) {

	         					totale = rs.getDouble("totPren");
	         				}

	         				if (idButton.equals("totOrd") ) {

	         					totale = rs.getDouble("totOrd");
	         				}
	         			}		
	         		}
	         	}
	    	 }
	    	 catch (Exception e) {
	           	
	             e.printStackTrace();
	         }
	    	 
	     	return totale;
	}
	
	public double viewGuadagnoTotale(String dataToday) {
    	
    	String queryord ="SELECT sum(TOTALE) AS totOrd FROM ordinazione WHERE DATA_ORD >= '2020-01-01' && DATA_ORD <= ?";
    	String querypren ="SELECT sum(REF_PREZZO_OMBR) AS totPren FROM prenotazione WHERE DATA_PREN >= '2020-01-01' && DATA_PREN <= ?";
    	double totale = 0;
    	
    	 try {
    
     		Context ctx = new InitialContext();
     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
     		
         	try (Connection connection = ds.getConnection(); 
         		PreparedStatement psOrd = connection.prepareStatement( queryord );
         		PreparedStatement psPren = connection.prepareStatement( querypren );	
         		)
         		
         	{
         		psOrd.setString(1, dataToday);
         		psPren.setString(1, dataToday);

         	
         		try (ResultSet rsPren = psPren.executeQuery()) {
         			while(rsPren.next() ) {
         				
         					totale += rsPren.getDouble("totPren");
         				}
         		}
         		try (ResultSet rsOrd = psOrd.executeQuery()) {
         			while(rsOrd.next() ) {
         				
         					totale += rsOrd.getDouble("totOrd");
         				}
         		}
         	}
         	
    	 }
    	 catch (Exception e) {
           	
             e.printStackTrace();
         }
    	 
    	return totale;
	}
}
