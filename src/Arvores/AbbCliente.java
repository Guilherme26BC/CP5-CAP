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
			p.cliente.show();
			show(p.dir);
		}
	}

	public Cliente procuraCliente(Arvore p, String cpf) {
		if(p!=null) {
			if(cpf.compareTo(p.cliente.getCPF())==0) {
				return p.cliente;
			}else if(cpf.compareTo(p.cliente.getCPF())<0) {
				procuraCliente(p,cpf);
			}else if(cpf.compareTo(p.cliente.getCPF())>0)
				procuraCliente(p,cpf);
		}else {
			return null;
		}
		return null;
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
					p.dir = removeValor(p.dir,cpf);
			}
		}
		return p;
	}
	public void verificaOferta(Arvore p, double valorO, AbbOferta oferta) {
	    if (p != null) {
	        verificaOferta(p.esq, valorO, oferta);
	        if (p.cliente.getTotalGasto() >= valorO && p.cliente.isAptoOferta()) {
	            oferta.root = oferta.inserir(oferta.root, p.cliente);
	        }
	        verificaOferta(p.dir, valorO, oferta);
	    }
	}
	
	public void showFalse(Arvore p) {
		if (p != null) {
			show(p.esq);
			if(p.cliente.isAptoOferta()) {
				p.cliente.show();
				
			}
			show(p.dir);
		}
	}
	public double somaTodos(Arvore p, double soma) {
		if(p!=null) {
		soma += p.cliente.getTotalGasto();
		soma= somaTodos(p.esq, soma);
		soma= somaTodos(p.dir, soma);
		}
		return soma;
	}
	public int qntMaior(Arvore p, double valor,int cont) {
		if(p!=null) {
			if(p.cliente.getTotalGasto()>valor) {
				cont++;
			}
			cont = qntMaior(p.esq,valor,cont);
			cont = qntMaior(p.dir,valor,cont);
		}
		return cont;
	}
}
