package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.*;
import util.ListaSeq;

public class SessaoDao {

private ConexaoBanco conexao; 
    
    public SessaoDao() 
    {
        this.conexao = new ConexaoBanco();
    }
  
    public int Insert(Sessao novasessao)
    {    	  	    	
        try
        {       
        	String query = "Insert into sessao (id, data, hora, filme, sala, flgativo ) "
        			+ "values (" + novasessao.getId() + "," 
        			+ "'" + novasessao.getData() + "'," 
        			+ "'" +novasessao.getHora() + "'," 
        			+ "'" +novasessao.getFilme() + "'," 
        			+ "'" +novasessao.getSala() + "'," 
        			+ novasessao.isFlgativo()
        			+ ")";
        	Connection con = conexao.getConnection();                    
            int res = 1;
            if (con != null)          	
            {            	
            	Statement stm = con.createStatement();  
            	System.out.println("> running: " + query + "...");
                res=stm.executeUpdate(query);
        		if (res >= 1)
        		{
        			System.out.println("Inserção realizada com sucesso!");
        		} 
                con.close();        
            }            
            return res;
        }
        catch(SQLException ex){
            System.out.println("Problemas com a conexão\n"+ex.getMessage());
            return 0;
        }
    }
    
    public ListaSeq<Sessao> SelectAll()
    {    	
    	ListaSeq<Sessao> lista = new ListaSeq<Sessao>();
    	Sessao obj = new Sessao();    	
    	Connection con = conexao.getConnection(); 
		Statement stm;
		try {			
			stm = con.createStatement();
			System.out.println("> running...");
			ResultSet rs = stm.executeQuery("select * from sessao");	
			while (rs.next()) {
				obj = new Sessao(rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getBoolean(6));
				lista.insert(obj);
			}	
			con.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
    	return lista;
    }
    
    public int Quantidade()
    {   	
    	Connection con = conexao.getConnection(); 
		Statement stm;
		int qtd = 0;
		try {			
			stm = con.createStatement();
			System.out.println("> running:  select count...");
			ResultSet rs = stm.executeQuery("select count(*) from sessao");	
			if (rs.next()) {
				qtd = rs.getInt(1);
			}	
			con.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
    	return qtd;
    }
    
    public int AtualizarStatus(int id, Boolean flgativo)
    {    	  	    	
        try
        {       
        	String query = "Update sessao set flgativo = "+ flgativo + " where id = " + id;
        	Connection con = conexao.getConnection();                    
            int res = 1;
            if (con != null)          	
            {            	
            	Statement stm = con.createStatement();  
            	System.out.println("> running: " + query + "...");
                res=stm.executeUpdate(query);
        		if (res >= 1)
        		{
        			System.out.println("Solicitação realizada com sucesso!");
        		} 
                con.close();        
            }            
            return res;
        }
        catch(SQLException ex){
            System.out.println("Problemas com a conexão\n"+ex.getMessage());
            return 0;
        }
    }
    
}
