package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//import model.Ombrellone;
import model.Utente;

public class UserDao {
	
	String insert = "INSERT INTO user(USERNAME, NOME, COGNOME, EMAIL, PASSWORD, RUOLO) VALUES (?,?,?,?,?,?)";
    String checkUsername ="SELECT USERNAME FROM user WHERE USERNAME=?";
    String checkEmail ="SELECT EMAIL FROM user WHERE EMAIL=?";
    String deletePersonale ="DELETE FROM user WHERE (USERNAME=? && RUOLO =?)";

    public String insert(Utente user) {
        
        try {
        	
    		Context ctx = new InitialContext();
    		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
    		
        	try (Connection connection = ds.getConnection(); 
        			PreparedStatement psI = connection.prepareStatement(insert); 
        			PreparedStatement psU = connection.prepareStatement(checkUsername);
        			PreparedStatement psE = connection.prepareStatement(checkEmail);
        			)
        	
        	{
        		psU.setString(1, user.getUsername());
        		psE.setString(1, user.getEmail());
        		try (ResultSet rsU = psU.executeQuery(); ResultSet rsE = psE.executeQuery() ) {
        			
                    while(rsU.next() ) {
                    	
                        return "Username esistente";
                    }
                    
                    while (rsE.next() ) {
                    	
                    	return "Email associata ad un altro utente";
                    }
        		}
        		
        		psI.setString(1, user.getUsername());
        		psI.setString(2, user.getNome());
                psI.setString(3, user.getCognome());
                psI.setString(4, user.getEmail());
                psI.setString(5, user.getPassword());
                psI.setString(6, user.getRuolo());
                
                psI.executeUpdate();
                
        	}
        }
        
        catch (Exception e) {
        	
            e.printStackTrace();
        }
        
        return "Registrazione avvenuta con successo"; 
    }
    
    public String rimuoviPersonale(String username, String ruolo) {
    	 
    	try {
         	
     		Context ctx = new InitialContext();
     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
     		
         	try (Connection connection = ds.getConnection(); 
         		PreparedStatement ps = connection.prepareStatement(deletePersonale);
         		
         		)
         	
         		{	
         		
         			ps.setString(1, username);
     				ps.setString(2, ruolo);
            	
     				int test = ps.executeUpdate();
            	
     				if (test!=0) {
            		
     					return username + " rimosso con successo";
         
     				} 
         		} 
    	}
    	
    	 catch (Exception e) {
            	
             e.printStackTrace();
         }
    	
    	return username + " non esiste oppure non hai selezionato il ruolo corretto";
    	
    }
    
    public ArrayList<Utente> listaPersonale(String ruolo) {
    	
    	String query ="SELECT USERNAME, RUOLO FROM user WHERE RUOLO !=?";
    	
    	ArrayList <Utente> personale = new ArrayList<Utente>();
    	
    	 try {
         	
     		Context ctx = new InitialContext();
     		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/madoniainsinna");
     		
         	try (Connection connection = ds.getConnection(); 
         		PreparedStatement ps = connection.prepareStatement(query);
         		)
         		
         	{
         		ps.setString(1, ruolo);	
         	
         		try (ResultSet rs = ps.executeQuery();) {
    			
         			while(rs.next() ) {
         				
         				Utente p = new Utente();
         				p.setUsername(rs.getString("USERNAME"));
         				p.setRuolo(rs.getString("RUOLO"));
         				personale.add(p);

         				}
         			return personale;
         			}
         		}
         }
    	 catch (Exception e) {
           	
             e.printStackTrace();
         }
         
     	return personale;
     	
    }

}
    	