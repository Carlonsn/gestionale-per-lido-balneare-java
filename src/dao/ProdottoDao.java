package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import model.Prodotto;

public class ProdottoDao {

	public String setProdotto( Prodotto p ) {
		
		String query = "SELECT * FROM prodotto WHERE ID_PROD = ?";
		
		int idProd = p.getId();
		
		System.out.println(idProd);
		try {
			Context ctx = new InitialContext();
			DataSource ds = ( DataSource ) ctx.lookup( "java:comp/env/jdbc/madoniainsinna" );
			
			try( Connection conn = ds.getConnection(); PreparedStatement ps = conn.prepareStatement( query ) ){
				
				ps.setInt( 1,  idProd );
				
				ResultSet rs = ps.executeQuery();
				
				if( rs.next() ) {
					p.setNome( rs.getString( "NOME_PROD" ) );
					p.setDesc( rs.getString( "DESC" ) );
					p.setPrezzo( rs.getDouble( "PREZZO_PROD" ) );
					
					return "SUCCESS";
					
				}
			}
		}
		catch( Exception e ) {
			e.printStackTrace();
		}
		
		return "NOT FOUND";
	}
	
	public ArrayList<Prodotto> viewMenu() {
    	
    	String query ="SELECT * FROM prodotto";
    	
    	
    	ArrayList <Prodotto> menu = new ArrayList<Prodotto>();
    	
    	 try {
         	
     		Context ctx = new InitialContext();
     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
     		
         	try (Connection connection = ds.getConnection(); 
         		PreparedStatement ps = connection.prepareStatement(query);
         		)
         	
         	{
         		try (ResultSet rs = ps.executeQuery();) {
    			
         			while(rs.next() ) {
         				
         				Prodotto p = new Prodotto();
         				p.setId( rs.getInt("ID_PROD") );
         				p.setNome( rs.getString("NOME_PROD") );
         				p.setDesc( rs.getString("DESC") );
         				p.setPrezzo( rs.getDouble("PREZZO_PROD") );
         				
         				menu.add( p );

         				}
         			return menu;
         			}
         		}
         }
    	 catch (Exception e) {
           	
             e.printStackTrace();
         }
         
     	return menu;
     	
    }
}
