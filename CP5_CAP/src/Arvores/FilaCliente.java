package Arvores;

import model.Cliente;

public class FilaCliente {
    
	private class NO {
		Cliente cliente;
		NO prox;
	}

	public NO lista = null;


	public boolean isEmpty() {
		return (lista == null);
	}
	
    public void enqueue(Cliente cliente) {
        NO novoNo = new NO();
        novoNo.cliente = cliente;
        novoNo.prox = null;

        if (isEmpty()) {
			lista = novoNo;
			novoNo.prox = null;;
        } else {
        	if (novoNo.cliente.getTotalGasto() > lista.cliente.getTotalGasto()) {
				novoNo.prox = lista;
				lista = novoNo;
        	}else {
				NO aux = lista;
				boolean achou = false;
				while (aux.prox != null && !achou) {
					if (aux.prox.cliente.getTotalGasto() > novoNo.cliente.getTotalGasto())
						aux = aux.prox;
					else {
						achou = true;
					}
				}
				novoNo.prox = aux.prox;
				aux.prox = novoNo;
			}
        }
    }
    public void show() {
    	System.out.println("************** list **************");
		NO aux = lista;
		while (aux != null) {
			aux.cliente.show();
			aux = aux.prox;
		}
		System.out.println();
    }

    public Cliente dequeue() {
		Cliente cliente = null;
    	if (!isEmpty()) {
    		cliente=lista.cliente;
    		lista=lista.prox;
			}

        return cliente;
    }

}
