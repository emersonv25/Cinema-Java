package model;

public class Usuario {
	
	private int id;
	private String nome;
	private String login;
	private String senha;
	private String matricula;
	private int cargo;
	private boolean flgativo;
	
	public Usuario() {
		super();
	}

	public Usuario(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}	

	public Usuario(int id, String nome, 
			String login, String senha, 
			String matricula, int cargo, 
			boolean flgativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.matricula = matricula;
		this.cargo = cargo;
		this.flgativo = flgativo;
	}

	public void imprimir(){
	      System.out.printf("%7s  \n",this.nome);
	}

	public int getId() {
		return id;
	}
	
	public int getCargo() {
		return cargo;
	}
	
	
}
