package model;

import java.util.Date;

public class Sessao {
	
	int id;
	String data;
	String hora;
	String filme;
	String sala;
	boolean flgativo;
	
	public Sessao() {
		super();
	}

	public Sessao(int id, String data, String hora, 
			String filme, String sala, boolean flgativo) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.filme = filme;
		this.sala = sala;
		this.flgativo = flgativo;
	}

	public int getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public String getFilme() {
		return filme;
	}

	public String getSala() {
		return sala;
	}

	public boolean isFlgativo() {
		return flgativo;
	}
	
	/*public void imprimir(){
	      System.out.printf("%7d        %-15s        %-15s\n",this.id,this.data,curso.getCurso());
	}*/

}
