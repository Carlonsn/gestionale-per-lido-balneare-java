package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Ordinazione;

public class ListaOrdinazioniDao {
	
	public ArrayList<Ordinazione> listaOrdinazioni( String dataOrdinazione ) {
    	
    	String query ="SELECT * FROM ordinazione WHERE DATA_ORD = ?";
    	
    	
    	ArrayList <Ordinazione> ordinazioni = new ArrayList<Ordinazione>();
    	
    	 try {
         	
     		Context ctx = new InitialContext();
     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
     		
         	try (Connection connection = ds.getConnection(); 
         		PreparedStatement ps = connection.prepareStatement(query);
         		)
         	
         	{	ps.setString(1, dataOrdinazione );
         		
    		
         		try (ResultSet rs = ps.executeQuery();) {
    			
         			while(rs.next() ) {
         				
         				Ordinazione ord = new Ordinazione();
         				ord.setOra_ord( rs.getString("ORA_ORD") );
         				ord.setOrdine( rs.getString("ORDINE") );
         				ord.setUser( rs.getString( "REF_U" ) );
         				
         				ordinazioni.add(ord);

         				}
         			return ordinazioni;
         			}
         		}
         }
    	 catch (Exception e) {
           	
             e.printStackTrace();
         }
         
     	return ordinazioni;
    }

}
