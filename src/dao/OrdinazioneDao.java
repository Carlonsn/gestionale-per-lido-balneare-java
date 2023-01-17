package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Ordinazione;

public class OrdinazioneDao {

		private String insert = "INSERT INTO ordinazione(DATA_ORD, ORA_ORD, ORDINE, TOTALE, REF_U) VALUES (?,?,?,?,?)";
	    
	    public String insert( Ordinazione ord) {
	      

	        try {
	        	
	    		Context ctx = new InitialContext();
	    		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
	    		
	        	try (Connection connection = ds.getConnection(); 
	        			PreparedStatement ps = connection.prepareStatement(insert); 
	        			)
	        	
	        	{	
	        		ps.setString(1, ord.getData_ord() );
	        		ps.setString(2, ord.getOra_ord() );
	        		ps.setString(3, ord.getOrdine() );
	                ps.setDouble(4, ord.getTotale() );
	                ps.setString(5, ord.getUser() );
	                
	                int test = ps.executeUpdate();
	                
	                if (test!=0) {
	                	
	                	return "Ordine avvenuto con successo";
	                }    
	        	}
	        }
	        catch (Exception e) {
	        	
	            e.printStackTrace();
	        }
	        
	        return "Si è verificato un errore"; 
	    }
}

