package Arvores;

import model.Cliente;

public class AbbCliente {

	private class Arvore {
		Cliente cliente;
		Arvore esq;
		Arvore dir;
	}

	public Arvore root = null;

	public Arvore inserir(Arvore p, Cliente clienteAux) {
		// insere elemento em uma ABB, insere a raiz
		if (p == null) {
			p = new Arvore();
			p.cliente = clienteAux;
			p.esq = null;
			p.dir = null;
		}
		// compara o valor com "p" e analisa em qual lugar ele fica
		else if (clienteAux.getCPF().compareTo(p.cliente.getCPF()) < 0)
			p.esq = inserir(p.esq, clienteAux);
		else
			p.dir = inserir(p.dir, clienteAux);
		return p;
	}

	public void show(Arvore p) {
		if (p != null) {
			show(p.esq);
			System.out.println("\t" + p.cliente.getNome());
			System.out.println("\t" + p.cliente.getCPF());
			System.out.println("\t" + p.cliente.getWhatsapp());
			System.out.println("\t" + p.cliente.getTotalGasto());
			show(p.dir);
		}
	}

	public Arvore removeValor(Arvore p, Cliente clienteAux) {
		if (p != null) {
			if (clienteAux.getCPF().compareTo(p.cliente.getCPF()) == 0) {
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
				if (clienteAux.getCPF().compareTo(p.cliente.getCPF()) < 0)
					p.esq = removeValor(p.esq, clienteAux);
				else
					p.dir = removeValor(p.dir, clienteAux);
			}
		}
		return p;
	}
	public Arvore verificaOferta(Arvore p, double valorO) {
		if(p!=null) {
			verificaOferta(p.esq, valorO);
			
			verificaOferta(p.dir, valorO);
			
		}
	}
}
