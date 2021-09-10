/*  ALUNOS:
Emerson de Jesus Santos  - 16017157
Matheus Felipe Vieira Santiago - 16016955
 */


package model;

public class Ingresso {
	private int id;
	private int sessao;
	private String poltrona;
	private double valorPago;
	private String datacompra;
	private String horacompra;
	private boolean flgativo;

	
	public Ingresso() {
		super();
	}
	
	public Ingresso(int sessao, String poltrona) {
		super();
		this.sessao = sessao;
		this.poltrona = poltrona;
		this.datacompra = "22/07/2020"; // ai fica chato informar a data e hora toda vez 
		this.horacompra = "00:00";      // ou usar alguma função pra puxar a hora do sistema, se dê tempo eu faço isso.
		this.valorPago = 10;
		this.flgativo = true;
	}
	
	public String getPoltrona() {
		return poltrona;
	}
	
	public String getDataCompra() {
		return datacompra;
	}
	
	public String horaCompra() {
		return horacompra;
	}
	
	public int getId() {
		return id;
	}
	
	public int getSessao() {
		return sessao;
	}
	
	public double getValor() {
		return valorPago;
	}
	
	public String getData() {
		return datacompra;
	}
	
	public String getHora() {
		return horacompra;
	}
}
