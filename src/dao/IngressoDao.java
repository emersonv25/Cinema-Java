/*  ALUNOS:
Emerson de Jesus Santos  - 16017157
Matheus Felipe Vieira Santiago - 16016955
 */


package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Ingresso;
import model.Sessao;
import util.ListaSeq;

public class IngressoDao {
	private ConexaoBanco conexao;
	
	
	public IngressoDao()
	{
		this.conexao = new ConexaoBanco();
	}
	
	public int Insert(Ingresso novoingresso)
	{
		try
		{
			String query = "Insert into ingresso (id_sessao, poltrona, valorpago, datacompra, horacompra )"
				+ "values (" + novoingresso.getSessao() + ","
				+ "'" + novoingresso.getPoltrona() + "',"
				+ "'" + novoingresso.getValor() + "',"
				+ "'" + novoingresso.getData() + "',"
				+ "'" + novoingresso.getHora() + "'"
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
	
	public ArrayList<String> Select(int sessao)
	{
		ArrayList <String> listaIngresso = new ArrayList<String>();
		//Ingresso obj = new Ingresso();
		
		try
		{
			String query = "select poltrona from ingresso where id_sessao ="  +  sessao;
			Connection con = conexao.getConnection();
        	Statement stm = con.createStatement();  
        	
        	System.out.println("> running: " + query + "...");
        	
        	ResultSet rs=stm.executeQuery(query);
        	
        	while (rs.next()) 
        	{
        		listaIngresso.add(rs.getString(1));
        		//System.out.println(rs.getString(1));
        	}
                con.close();      
            //System.out.println(listaIngresso.get(0));
            return listaIngresso;
			
		}
        catch(SQLException ex){
            System.out.println("Problemas com a conexão\n"+ex.getMessage());
            return null;
        }
	}
	
	
}
