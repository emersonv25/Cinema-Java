package dao;

import java.sql.*;
import javax.swing.JOptionPane;
	 
	public class ConexaoBanco {
	    private String url;
	    private String usr;
	    private String pass;
	    
	    public ConexaoBanco() {     
	    	/*url="jdbc:postgresql://localhost:5432/cinema";
	        usr="usrcinema";
	        pass="123456";*/
	    	url="jdbc:postgresql://localhost:5432/";
	        usr="postgres";
	        pass="cfik7e";


	    }
	    
	    protected Connection getConnection(){
	        try {
	        	System.out.println("> Conectando com o banco de dados...");
	            Class.forName("org.postgresql.Driver");	           
	            Connection con = DriverManager.getConnection(url, usr, pass);
	            System.out.println("> Conexão estabelecida...");
	            return con;
	        }catch(ClassNotFoundException ex){
	        	//https://jdbc.postgresql.org/download.html
	            JOptionPane.showMessageDialog(null, "O driver não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
	            return null;
	        }catch(SQLException ex){
	            JOptionPane.showMessageDialog(null, "Problemas com a conexão\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	            return null;
	        }
	    }
	}

