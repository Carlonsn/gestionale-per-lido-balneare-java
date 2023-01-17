package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Ombrellone;

import java.util.ArrayList;

public class ListaOmbrelloniDao {

	
	public ArrayList<Ombrellone> listaOmbrelloni( String dataPrenotazione ) {
    	
    	String query ="SELECT * FROM ombrellone WHERE ID_OMBR NOT IN (" +
    					"SELECT REF_OMBR FROM prenotazione WHERE DATA = ?)";
    	
    	
    	ArrayList <Ombrellone> ombrelloni = new ArrayList<Ombrellone>();
    	
    	 try {
         	
     		Context ctx = new InitialContext();
     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
     		
         	try (Connection connection = ds.getConnection(); 
         		PreparedStatement ps = connection.prepareStatement(query);
         		)
         	
         	{	ps.setString(1, dataPrenotazione);
         		
    		
         		try (ResultSet rs = ps.executeQuery();) {
    			
         			while(rs.next() ) {
         				
         				Ombrellone ombr = new Ombrellone();
         				ombr.setId( rs.getInt("ID_OMBR") );
         				ombr.setRiga( rs.getInt("RIGA") );
         				ombr.setPosto( rs.getInt("POSTO") );
         				ombr.setPrezzo( rs.getDouble("PREZZO_OMBR") );
         				
         				ombrelloni.add(ombr);

         				}
         			return ombrelloni;
         			}
         		}
         }
    	 catch (Exception e) {
           	
             e.printStackTrace();
         }
         
     	return ombrelloni;
     	
    }
	
	public ArrayList<Ombrellone> vistaOmbrelloniDisponibili( String dataToday ) {
    	
    	String query ="SELECT * FROM ombrellone WHERE ID_OMBR NOT IN (" +
    					"SELECT REF_OMBR FROM prenotazione WHERE DATA = ?)";
    	
    	
    	ArrayList <Ombrellone> ombrelloni = new ArrayList<Ombrellone>();
    	
    	 try {
         	
     		Context ctx = new InitialContext();
     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
     		
         	try (Connection connection = ds.getConnection(); 
         		PreparedStatement ps = connection.prepareStatement(query);
         		)
         	
         	{	ps.setString(1, dataToday);
         		
    		
         		try (ResultSet rs = ps.executeQuery();) {
    			
         			while(rs.next() ) {
         				
         				Ombrellone ombr = new Ombrellone();
         				ombr.setId( rs.getInt("ID_OMBR") );
         				ombr.setRiga( rs.getInt("RIGA") );
         				ombr.setPosto( rs.getInt("POSTO") );
         				
         				ombrelloni.add(ombr);

         				}
         			return ombrelloni;
         			}
         		}
         }
    	 catch (Exception e) {
           	
             e.printStackTrace();
         }
         
     	return ombrelloni;
    }

	public ArrayList<Ombrellone> vistaOmbrelloniOccupati( String dataToday ) {
	
		String query ="SELECT ombrellone.ID_OMBR, ombrellone.RIGA, ombrellone.POSTO, prenotazione.REF_USER FROM ombrellone, prenotazione WHERE ID_OMBR = REF_OMBR && ID_OMBR IN (" +
					"SELECT REF_OMBR FROM prenotazione WHERE DATA = ?)";
	
	
		ArrayList <Ombrellone> ombrelloni = new ArrayList<Ombrellone>();
	
		try {
     	
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
 		
			try (Connection connection = ds.getConnection(); 
					
				PreparedStatement ps = connection.prepareStatement(query);
     		)
     	
		   {	ps.setString(1, dataToday);
     		
		
     			try (ResultSet rs = ps.executeQuery();) {
			
     				while(rs.next() ) {
     				
     					Ombrellone ombr = new Ombrellone();
     					ombr.setId( rs.getInt("ID_OMBR") );
     					ombr.setRiga( rs.getInt("RIGA") );
     					ombr.setPosto( rs.getInt("POSTO") );
     					ombr.setUser(rs.getString("REF_USER"));
     				
     					ombrelloni.add(ombr);

     				}
     				return ombrelloni;
     			}
     		}
		}
		catch (Exception e) {
       	
         e.printStackTrace();
         
		}
     
		return ombrelloni;
 	
	}
}
