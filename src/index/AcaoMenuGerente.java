package index;



import dao.*;
import model.*;
import util.*;

public class AcaoMenuGerente {
	
	public static void realizarLogin()
	{
		Keyboard.clrscr();
		System.out.println("                    GERENTE                  \n ");
		String login = Keyboard.readString("Login: ");
		String senha = Keyboard.readString("Senha: ");
		UsuarioDao gdao = new UsuarioDao();
		Usuario gerente = gdao.selectUsuarioLogin(login, senha);
		if(gerente.getId() > 0) 
		{		
			if (gerente.getCargo() > 0) 
			{
				int opcao;
				do{
					Keyboard.clrscr();
					System.out.print("Bem vindo! ");
					gerente.imprimir();
					opcao = Keyboard.menu("Cadastrar Sessao/Listar Sessões/Atualizar Status da Sessao/Sair");
					switch(opcao){
		            case 1:
		            	CadastrarSessao();
		            	Keyboard.waitEnter();
		            	break;
		            case 2:	            	
		            	ListarSessoes();
		            	Keyboard.waitEnter();
		            	break;	            
		            case 3:	            	
		            	AtualizarStatusSessao();
		            	Keyboard.waitEnter();
		            	break;
					}				
				}while(opcao < 3);
			}
			else
			{
				System.out.println("O USUARIO NÃO É UM ADMINISTRADOR !");
			}
			
		}
		else {
			System.out.println("Login ou senha invalido!");
		}		
	}	
	
	private static void AtualizarStatusSessao() {
		ListaSeq<Sessao> lista = new ListaSeq<Sessao>();
		Keyboard.clrscr();
		System.out.println("                     ATUALIZAR STATUS SESSAO                  \n ");		
		SessaoDao gdao = new SessaoDao();
		ListarSessoes();		
		int id = Keyboard.readInt("Id: ");
		int flg = Keyboard.readInt("flgativo: 1 - Ativo; 2- Desativo: ");
		Boolean flgativo = false;
		if(flg == 1) {
			flgativo = true;
		}
		//verifica se é uma sessao valida
		gdao.AtualizarStatus(id, flgativo);			
	}

	private static void ListarSessoes() {
		ListaSeq<Sessao> lista = new ListaSeq<Sessao>();
		Keyboard.clrscr();
		System.out.println("                    SESSOES CADASTRADAS                  \n ");
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

	private static void CadastrarSessao() 
	{
		Keyboard.clrscr();
		System.out.println("                    CADASTRAR SESSAO                  \n ");
		SessaoDao gdao = new SessaoDao();
		String data = Keyboard.readString("Data(dd/mm/yyyy):");
		String hora = Keyboard.readString("Hora(hh:mm): ");
		String filme = Keyboard.readString("Filme: ");
		String sala = Keyboard.readString("Sala: ");
		Boolean flgativo = true;
		int id = gdao.Quantidade() + 1;
		Sessao novasessao = new Sessao(id, data, hora, filme, sala, flgativo);
		gdao.Insert(novasessao);
	}

	public static void listarUsuarios() {
		ListaSeq<Usuario> lista = new ListaSeq<Usuario>();
		Keyboard.clrscr();
		System.out.println("                    GERENTE                  \n ");
		UsuarioDao gdao = new UsuarioDao();
		lista = gdao.selectAll();
		Usuario u = (Usuario) lista.getFirst();
		while(u != null) {			
			u.imprimir();
			u = (Usuario) lista.getNext();
		}	
	}
}
