package index;

import dao.*;
import model.*;
import util.*;

public class Main {

	static ListaSeq<Usuario> lista = new ListaSeq<Usuario>();
	static String[][] poltronas = new String[10][10];
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub	
		int opcao;
		do{
			//Keyboard.clrscr();
			opcao = Keyboard.menu("Menu ADM/Comprar Ingressos/Sair");
			switch(opcao){
            case 1:
            	AcaoMenuGerente.realizarLogin();
            	break;
            case 2:       
            	AcaoMenuCliente.realizarLogin();
            	break;
			}			
		}while(opcao < 3);
		
	}
}
