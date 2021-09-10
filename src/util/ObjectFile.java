package util;


//Classe desenvolvida para gravar objetos em arquivos bin�rios
//Programado por Raimundo Machado Costa em 21/08/2008

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectFile {
	private String nomeArq;
	private ObjectOutputStream outputStream;
	private ObjectInputStream  inputStream;
	
	public ObjectFile(String nomeArq){
		this.nomeArq = nomeArq;
		outputStream = null;
		inputStream  = null;
	}	
	
	//Abre o arquivo para leitura
	public boolean reset(){
		try{
			inputStream = new ObjectInputStream(new FileInputStream(nomeArq));
			return true;
		}
		catch(FileNotFoundException e){
			return false;
		}
		catch(IOException e){
			return false;
		}
	}	
	
	//Abre para grava��o, criando um novo arquivo
	public void rewrite(){
		if (outputStream != null)
			closeFile();		
		try{
			outputStream = new ObjectOutputStream(new FileOutputStream(nomeArq));
		}
		catch(IOException e){
			System.out.println("Erro ao abrir o arquivo");
			System.exit(0);
		}		
	}	
	
	//Fecha o arquivo
	public void closeFile(){
		try{
			if (outputStream != null)
				outputStream.close();
		}
		catch(IOException e){
			System.out.println("Erro ao fechar o arquivo");
		}
		outputStream = null;
		inputStream  = null;
	}	
	
	public void flush() throws IOException{
		outputStream.flush();
	}
	
	//Grava um objeto no arquivo
	public void write(Serializable obj){
		try {
			if (outputStream == null)
				System.out.println("Erro: O arquivo nao foi aberto");
			else
				outputStream.writeObject(obj);
		}
		catch(IOException e){
			System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
		}
	}	
	
	//L� um objeto do arquivo
	public Serializable read(){
		
		if (inputStream == null){
			return null;
		}
		else{
			try{
				return (Serializable) inputStream.readObject();
			}
			catch (IOException e){
				return null;
			}
			catch (ClassNotFoundException e){
				return null;
			}
		}
	}		

}
