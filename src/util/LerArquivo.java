/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author 11160
 */
public class LerArquivo {
  //Linhas_CSV
  public static List<String> lerArquivoPalavra(String caminho) throws IOException{
    List<String> linhasCSV = new ArrayList<>();
    //Palavra p;  
	try {
	  BufferedReader in = new BufferedReader(new FileReader(caminho));
	  String linha;	  
	  while ((linha = in.readLine()) != null) 
          {
              String registro[] = linha.split(";");
              String l = "";
              for(int i = 0; i < registro.length; i++)
              {
            	  l = l + "\'" + registro[i] + "\'"; 
            	  if (i < (registro.length - 1)) 
            	  {            		  
            		l = l + ",";  
            	  }
              }
              linhasCSV.add(l);
          }
		in.close();
		//fecha o arquivo
    }catch (IOException e) {
	//Tratamento do erro
  	  System.out.println("Nao foi possivel localizar o arquivo informado!");
      System.exit(0);
    }
     return linhasCSV;
  }
  
  /*public static List<Palavra> lerArquivoPalavraGrupo(String caminho) throws IOException{
    List<Palavra> listaPalavra = new ArrayList<>();
        Palavra p;  
	try {
	  BufferedReader in = new BufferedReader(new FileReader(caminho));
	  String linha;
	  while ((linha = in.readLine()) != null) 
          {
              String registro[] = linha.split(";");
              int idPalavra = 0;
              String palavra = "";
              List<Integer> idGrupo = new ArrayList<>();              
              for(int i = 0; i < registro.length; i++)
              {
                  if(i == 0)
                  {
                      idPalavra = Integer.parseInt(registro[i]);                      
                  }
                  else
                  {
                        if(i == 1)
                        {
                            palavra = registro[i];
                        }
                        else
                        {
                            idGrupo.add(Integer.parseInt(registro[i]));
                        }
                  }                  
              }
              p = new Palavra(idPalavra, palavra, idGrupo);
              listaPalavra.add(p);
          }
		in.close();
		//fecha o arquivo
    }catch (IOException e) {
	//Tratamento do erro
  	  System.out.println("Nao foi possivel localizar o arquivo informado!");
      System.exit(0);
    }
     return listaPalavra;
  }*/
}
