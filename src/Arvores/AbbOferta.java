package Arvores;

import model.Cliente;

public class AbbOferta {
	private class Arvore {
		Cliente cliente;
		Arvore esq;
		Arvore dir;
	}

	public Arvore root = null;

	public Arvore inserir(Arvore p, Cliente clienteAux) {
		if (p == null) {
			p = new Arvore();
			p.cliente = clienteAux;
			p.esq = null;
			p.dir = null;
		}
		else if (clienteAux.getTotalGasto() < p.cliente.getTotalGasto())
			p.esq = inserir(p.esq, clienteAux);
		else
			p.dir = inserir(p.dir, clienteAux);
		return p;
	}

	public void show(Arvore p) {
		if (p != null) {
			show(p.esq);
			p.cliente.show();
			show(p.dir);
		}
	}
	public void procuraCliente(Arvore p, String cpf) {
		if(p!=null) {
			if(cpf.compareTo(p.cliente.getCPF())==0) {
				p.cliente.show();
			}else if(cpf.compareTo(p.cliente.getCPF())<0) {
				procuraCliente(p,cpf);
			}else if(cpf.compareTo(p.cliente.getCPF())>0)
				procuraCliente(p,cpf);
		}else {
			System.out.println("Cliente com cpf " + cpf + " não encontrado!");
		}
	}

	public Arvore removeValor(Arvore p, String cpf) {
		if (p != null) {
			if (cpf.compareTo(p.cliente.getCPF()) == 0) {
				if (p.esq == null && p.dir == null) // nó a ser removido é nó folha
					return null;
				if (p.esq == null) { // se não há sub-árvore esquerda o ponteiro passa apontar para a sub-árvore
										// direita
					return p.dir;
				} else {
					if (p.dir == null) { // se não há sub-árvore direita o ponteiro passa apontar para a sub-árvore
											// esquerda
						return p.esq;
					} else { /*
								 * o nó a ser retirado possui sub-arvore esquerda e direita, então o nó que será
								 * retirado deve-se encontrar o menor valor na sub-árvore á direita
								 */
						Arvore aux, ref;
						ref = p.dir;
						aux = p.dir;
						while (aux.esq != null)
							aux = aux.esq;
						aux.esq = p.esq;
						return ref;
					}
				}
			} else { // procura dado a ser removido na ABB
				if (cpf.compareTo(p.cliente.getCPF()) < 0)
					p.esq = removeValor(p.esq, cpf);
				else
					p.dir = removeValor(p.dir, cpf);
			}
		}
		return p;
	}

	public Cliente retiraDecrescente(Arvore p) {
		Cliente cliente = null;
		if (p != null) {
			retiraDecrescente(p.esq);
			retiraDecrescente(p.dir);
			cliente = p.cliente;
			removeValor(p, p.cliente.getCPF());
		}
		return cliente;
	}
	
	public void gerarFilaDecrescente(Arvore p, FilaCliente fila) {
	    if (p != null) {
	        gerarFilaDecrescente(p.dir, fila);
	        fila.enqueue(p.cliente);
	        gerarFilaDecrescente(p.esq, fila); 
	    }
	}
	
}
