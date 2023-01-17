package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Ombrellone;
import model.Prenotazione;

public class PrenotazioneDao {
	
	    private String insert = "INSERT INTO prenotazione(ID_PREN, DATA_PREN, DATA, REF_OMBR, REF_PREZZO_OMBR, REF_USER) VALUES (?,?,?,?,?,?)";
	
	    private String deletePren = "DELETE FROM prenotazione WHERE (REF_OMBR = ? && DATA = ?)";
	    
	    public String insert(Prenotazione pren) {
	      

	        try {
	        	
	    		Context ctx = new InitialContext();
	    		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
	    		
	        	try (Connection connection = ds.getConnection(); 
	        			PreparedStatement ps = connection.prepareStatement(insert); 
	        			)
	        	
	        	{

	        		ps.setInt(1, pren.getId_pren());
	        		ps.setString(2, pren.getData_pren());
	                ps.setString(3, pren.getData());
	                ps.setInt(4, pren.getId_ombr());
	                ps.setDouble(5, pren.getPrezzo());
	                ps.setString(6, pren.getUser());
	                
	                int test = ps.executeUpdate();
	                
	                if (test!=0) {
	                	
	                	return "Prenotazione avvenuta con successo";
	                }    
	        	}
	        }
	        
	        catch (Exception e) {
	        	
	            e.printStackTrace();
	        }
	        
	        return "Si è verificato un errore"; 
	    }
	    	
	    public String setInfoOmbr( Ombrellone o ) {
	    		
	    		String query = "SELECT * FROM ombrellone where ID_OMBR = ?";
	    		int idOmbr = o.getId();
	    		
	    		try {
	    			Context ctx = new InitialContext();
	    			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/madoniainsinna" );
	    			
	    			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
	    				
	    				ps.setInt( 1,  idOmbr );
	    				
	    				ResultSet rs = ps.executeQuery();
	    				
	    				if( rs.next() ) {
	    					o.setRiga( rs.getInt( "RIGA" ) );
	    					o.setPosto( rs.getInt( "POSTO" ) );
	    					o.setPrezzo( rs.getDouble( "PREZZO_OMBR" ) );
	    					
	    					return "SUCCESS";
	    					
	    				}
	    			}
	    		}
	    		
	    		catch( Exception e ) {
	    			e.printStackTrace();
	    		}
	    		
	    		return "NOT FOUND";
	    	}
	    
	    public String annullaPrenotazione(int idOmbr, String data) {
	    	
	    	 try {
	         	
	     		Context ctx = new InitialContext();
	     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
	     		
	         	try (Connection connection = ds.getConnection(); 
	         		PreparedStatement ps = connection.prepareStatement(deletePren);
	         		
	         		)
	         	
	         	{	
	         		ps.setInt(1, idOmbr);
	         		ps.setString(2, data);
	         		
	         		int test = ps.executeUpdate();
	                	
	         		if (test!=0) {
	                		
	         			return "La prenotazione dell'ombrellone " + idOmbr + " in data " + data + " è stata rimossa con successo";         				
	         			}
	         	}
	    	 }   	
	    	 catch (Exception e) {
	           	
	             e.printStackTrace();
	         }
	         
	    	 return "La perenotazione dell'ombrellone " + idOmbr + " non esiste, oppure hai selezionato la data errata" ;
	     	
	    }
	    public ArrayList<Prenotazione> listaPrenotazioni() {
	    	
	    	String query ="SELECT ID_PREN, DATA, REF_USER, REF_OMBR FROM prenotazione";
	    	
	    	ArrayList <Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
	    	
	    	 try {
	         	
	     		Context ctx = new InitialContext();
	     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
	     		
	         	try (Connection connection = ds.getConnection(); 
	         		PreparedStatement ps = connection.prepareStatement(query);
	         		)
	         		
	         		
	         	{	
	         		
	         		try (ResultSet rs = ps.executeQuery();) {
	    			
	         			while(rs.next() ) {
	         				
	         				Prenotazione p = new Prenotazione();
	         				p.setId_pren(rs.getInt("ID_PREN"));
	         				p.setData(rs.getString("DATA"));
	         				p.setUser(rs.getString("REF_USER"));
	         				p.setId_ombr(rs.getInt("REF_OMBR"));	
	         				prenotazioni.add(p);

	         				}
	         			return prenotazioni;
	         			}
	         		}
	         }
	    	 catch (Exception e) {
	           	
	             e.printStackTrace();
	         }
	         
	     	return prenotazioni;
	     	
	    }
}
