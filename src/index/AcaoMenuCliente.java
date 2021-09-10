/*  ALUNOS:
Emerson de Jesus Santos  - 16017157
Matheus Felipe Vieira Santiago - 16016955
 */


package index;

import java.util.ArrayList;

import dao.IngressoDao;
import dao.SessaoDao;
import dao.UsuarioDao;
import model.Ingresso;
import model.Sessao;
import model.Usuario;
import util.Keyboard;
import util.ListaSeq;

public class AcaoMenuCliente {
	
	static String[][] poltronas = new String[10][10];
	static ListaSeq<Sessao> lista = new ListaSeq<Sessao>();
	
	public static void realizarLogin()
	{
		Keyboard.clrscr();
		System.out.println("                    CLIENTE                  \n ");
		
		int opcao;
		do{
			Keyboard.clrscr();
			System.out.print("Bem vindo! ");
			opcao = Keyboard.menu("Comprar Ingresso/Listar Sessões/Sair");
			switch(opcao){
            case 1: 
            	ComprarIngresso();
            	Keyboard.waitEnter();
            	break;
            case 2:	            	
            	ListarSessoes();
            	Keyboard.waitEnter();
            	break;
			}				
		}while(opcao < 2);
				
	}
	
	
	private static void ComprarIngresso() {
		ListarSessoes(); // lista as sessoes
		int idSessao = Keyboard.readInt("Sessão: "); // escolhe a id da sessao
		int numeroIngressos = Keyboard.readInt("Quantos ingressos deseja comprar ? ");
		imprimirPoltronas(idSessao); // imprimi a poltrona
		
		String poltrona[] = new String[numeroIngressos]; // uma lista para armazenar os ignressos
		
		
		for(int i = 0 ; i < numeroIngressos; i++) { // 
			
			poltrona[i] = Keyboard.readString(i+1 + "º Poltrona: ").toUpperCase(); // armazena as poltronas na lista
		}
		
		System.out.println("Poltronas Selecionadas: ");
		for(int i = 0 ; i < numeroIngressos; i++)
		{
			System.out.print(poltrona[i] + "  "); // printa as poltronas selecionadas
		}
		
		System.out.println("\nValor a pagar: R$" + numeroIngressos * 10); // multiplica pelo preço padrão do ingresso
		int confirmar = Keyboard.menu("Confirmar/Cancelar");
		switch(confirmar) { // podia ser um if ? podia, mas funciona do msm jeito
			case 1:
				// IngressoDao AQUI
				IngressoDao idao = new IngressoDao();
				
				for(int i = 0 ; i < numeroIngressos; i++) // armazena o ingresso em um objeto e depois salva no banco
				{
					Ingresso novoingresso = new Ingresso(idSessao, poltrona[i]); 
					idao.Insert(novoingresso);
				}
				
				System.out.println("Ingressos Comprados com sucessos !");
				
				break;
		}
		
		
	}
	
	
	
	private static void ListarSessoes() {
		Keyboard.clrscr();
		System.out.println("                    SESSOES DISPONIVEIS                \n ");
		SessaoDao gdao = new SessaoDao();
		lista = gdao.SelectAll();
		Sessao s = (Sessao) lista.getFirst();
		while(s != null) {
			System.out.print("id: " + s.getId());
			System.out.print(" | data: " + s.getData());
			System.out.print(" | hora: " + s.getHora());
			System.out.print(" | filme: " + s.getFilme());
			System.out.print(" | sala: " + s.getSala());
			System.out.println(" | flgativo: " + s.isFlgativo());
			s = (Sessao) lista.getNext();
		}	
	}
	
	public static void imprimirPoltronas(int sessao)
	{
		IngressoDao idao = new IngressoDao(); 
		ArrayList <String> listaIngresso = new ArrayList<String>(); // arraylist >>> array
		listaIngresso = idao.Select(sessao); // chama uma função select criada no Dao
		
		//System.out.println(listaIngresso);
		
		
    	String letras[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    	String cadeira;
    	for(int i = 0; i < 10; i++) {
        	for(int j = 0; j < 10; j++) {
        		cadeira = (j+1) + letras[i];
        		if (listaIngresso.contains(cadeira)) { // COMPARA COM O BANCO ANTES DE ARMAZENAR NA MATRIZ
        			poltronas[i][j] = "**";
        			//System.out.println("X");
        		}
        		else {
        			//System.out.println("NO");
        			poltronas[i][j] = cadeira;
        		}
        		
        	}
    	}
    	
    	//pergunta quantos ingresso vai comprar 
    	//deixa selecionar a quantidade de poltronas de acordo com os ingressos
    	//informa o valor a ser pago e confirma a reserva
    	//exibe as informações da sessao
    	System.out.println("                    POLTRONAS                  \n ");            	
    	for(int i = 0; i < 10; i++) {
        	for(int j = 0; j < 10; j++) {
        		// IF DE COMPARAÇÃO SE EXISTIR NO BANCO IRA PRITNAR X
        		System.out.print(poltronas[i][j] + " ");
        	}
        	System.out.println(" ");
    	}
	}
	
}
