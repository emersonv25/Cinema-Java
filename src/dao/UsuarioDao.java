
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;
import util.*;


/*  ALUNOS:
Emerson de Jesus Santos  - 16017157
Matheus Felipe Vieira Santiago - 16016955
 */

public class UsuarioDao {

    private ConexaoBanco conexao; 
    
    public UsuarioDao() 
    {
        this.conexao = new ConexaoBanco();
    }
      
    public Usuario selectUsuarioLogin (String login, String senha)
    {    	    	
    	Usuario usuario = new Usuario();
    	int id = 0;
    	String nome = "";
    	String matricula = "";
    	int cargo = 0;
    	boolean flgativo = false;
    	
    	Connection con = conexao.getConnection(); 
		Statement stm;
		try {			
			stm = con.createStatement();
			System.out.println("> running: select * from usuario where login = ? and senha = ? ...");
			ResultSet rs = stm.executeQuery("select * from usuario where \"login\" = '" + login + "' and \"senha\" = '" + senha + "'");	
			if (rs.next()) {
				id = rs.getInt(1);
				nome = rs.getString(2);
				login = rs.getString(3);
				senha = rs.getString(4);
				matricula = rs.getString(5);
				cargo = rs.getInt(6);
				flgativo = rs.getBoolean(7);
				usuario = new Usuario(id, nome, login, senha, matricula, cargo, flgativo);
			}	
			con.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
    	return usuario;
    }
    
    public ListaSeq<Usuario> selectAll ()
    {    	
    	ListaSeq<Usuario> lista = new ListaSeq<Usuario>();
    	Usuario usuario = new Usuario();
    	int id = 0;
    	String nome = "";
    	String login = "";
    	String senha = "";
    	String matricula = "";
    	int cargo = 0;
    	boolean flgativo = false;
    	
    	Connection con = conexao.getConnection(); 
		Statement stm;
		try {			
			stm = con.createStatement();
			System.out.println("> running: select * from usuario ...");
			ResultSet rs = stm.executeQuery("select * from usuario");	
			while (rs.next()) {
				id = rs.getInt(1);
				nome = rs.getString(2);
				login = rs.getString(3);
				senha = rs.getString(4);
				matricula = rs.getString(5);
				cargo = rs.getInt(6);
				flgativo = rs.getBoolean(7);
				usuario = new Usuario(id, nome, login, senha, matricula, cargo, flgativo);
				lista.insert(usuario);
			}	
			con.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
    	return lista;
    }
}
