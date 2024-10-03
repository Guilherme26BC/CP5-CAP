package Arvores;

import model.Cliente;

public class FilaCliente {
    
    private class NO {
        Cliente cliente;
        NO prox;
    }

    private NO inicio, fim;

    public FilaCliente() {
        inicio = null;
        fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(Cliente cliente) {
        NO novoNo = new NO();
        novoNo.cliente = cliente;
        novoNo.prox = null;

        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.prox = novoNo;
            fim = novoNo;
        }
    }

    public Cliente dequeue() {
        if (isEmpty()) {
            return null;
        }

        Cliente cliente = inicio.cliente;
        inicio = inicio.prox;

        if (inicio == null) {
            fim = null;
        }

        return cliente;
    }

}
