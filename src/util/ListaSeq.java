package util;

import java.io.Serializable;

public class ListaSeq <E> implements Serializable{

    private E[] lista;
    private int numElementos;
    private int incremento;
    private int corrente;

     public ListaSeq() {
        numElementos = 0;
        incremento = 10;
        lista = (E[]) new Object[10];
    }

    public ListaSeq(int tamanhoInicial) {
        numElementos = 0;
        incremento = 10;
        lista = (E[]) new Object[tamanhoInicial];
    }

    public ListaSeq (int tamanhoInicial, int incremento){
        numElementos = 0;
        this.incremento = 10;
        lista = (E[]) new Object[tamanhoInicial];
    }

    private void redimensione(){
        if (numElementos == lista.length){
            Object[] novoVetor = new Object[numElementos+incremento];
            System.arraycopy(lista, 0, novoVetor, 0, numElementos);
            lista = (E[]) novoVetor;
        }
    }

    private int findPosition(E obj){
        for (int i=0; i<numElementos; i++){
            if (lista[i].equals(obj))
                return i;
        }
        return -1;
    }

	public void insert(E obj){
		   redimensione();
		   lista[numElementos] = obj;
		   numElementos++;
		}

    public boolean delete(E obj){
        int posicao = findPosition(obj);
        if (posicao >= 0){
            for (int i=posicao; i<(numElementos-1); i++){
                lista[i] = lista[i+1];
            }
            numElementos--;
            lista[numElementos] = null;
            return true;
        }
        return false;
    }

    public boolean isThere(E obj){
        return (findPosition(obj)>=0);
    }

    public E retrieve(E obj){
        int posicao = findPosition(obj);
        if (posicao >= 0)
            return lista[posicao];
        else return null;
    }

    public int length(){
        return numElementos;
    }

    public E getFirst(){
        if (numElementos == 0)
            return null;
        else {
            corrente = 0;
            return lista[0];
        }
    }

    public E getNext(){
        if (corrente == numElementos-1)
            return null;
        else
            return lista[++corrente];
    }
}
