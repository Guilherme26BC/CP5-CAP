package Aplicacao;

import java.util.Scanner;

import Arvores.AbbCliente;
import Arvores.AbbOferta;
import Arvores.FilaCliente;
import model.Cliente;

public class DivulgaOferta {
	/*
	 * NOMES E RM dos alunos que compõem o grupo
	 */
	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		AbbCliente cadastro = new AbbCliente();
		AbbOferta oferta = new AbbOferta();
	
		FilaCliente filaOferta = new FilaCliente();
		//filaOferta.init();
		
		int opcao, op;
		String nome, whatsapp, cpf;
		double totalGasto;
		do {
			System.out.println(" 0 - Encerrar o programa");
			System.out.println(" 1 - Inscricao um cliente");
			System.out.println(" 2 - Oferta de novo produto/promocacao");
			System.out.println(" 3 – Entrar no Submenu ");
			System.out.println(" 4 - Remove um cliente do cadastro");
			opcao = le.nextInt();
			switch (opcao) {
			case 0:
				System.out.println("\n\nClientes que não aceitaram ou não estavam adequados para a oferta");
				cadastro.showFalse(cadastro.root);
				opcao = 0;
				break;
			case 1:
				System.out.print("Digite nome: ");
				le.nextLine();
				nome = le.nextLine();
				System.out.print("Digite CPF: ");
				cpf = le.next();
				System.out.print("Whatsapp: ");
				whatsapp = le.next();
				System.out.print("Informe total gasto do cliente R$: ");
				totalGasto = le.nextDouble();
				/*
				 * Intancia um objeto da classe Cliente e insere na ABB cadastro organizada pelo
				 * CPF
				 */
				Cliente cliente = new Cliente(nome, cpf, whatsapp, totalGasto);
				cadastro.root = cadastro.inserir(cadastro.root, cliente);
				break;
			case 2:
				System.out.print("Qual o valor de saldo minimo exigido: R$ ");
				totalGasto = le.nextDouble();
				
				oferta.root= oferta.inserir(oferta.root, cadastro.verificaOferta(cadastro.root, totalGasto));
				oferta.show(oferta.root);
				oferta.retiraDecrescente(oferta.root);
				/*
				 * Percorrendo a ABB de cadastro gera ABB oferta usando como criterio de
				 * organizacao o total de gasto do cliente.
				 *
				 * Usando um método de percurso gerar uma fila de clientes para contactar via
				 * whatsapp, em ordem decrescente de gastos (o primeiro cliente deve ser o com
				 * maior valor de gasto.
				 *
				 * Esvazia ABB oferta.
				 */
				/*
				 * Nesse trecho de programa que é simulada a tentativa de fazer o contato com
				 * cada um dos clientes presentes na fila. Até nao ter mais clientes para
				 * contactar.
				 *
				 * Cada cliente que aceita a oferta tem o atributo apto para oferta alterado
				 * para false no seu cadastro
				 */
				break;
			case 3:
				do {
					System.out.println("\t 1) Consulta cliente buscando pelo CPF");
					System.out.println("\t 2) Apresenta o total de gasto de todos os clientes");
					System.out.println("\t 3) Apresenta a quantidade de clientes com saldo acima de um valor a ser consultado");
					System.out.println("\t 4) Volta menu principal");
					op = le.nextInt();
					switch (op) {
					case 1:
						System.out.print("Informe CPF para consulta");
						cpf = le.next();
						Cliente client =cadastro.procuraCliente(cadastro.root, cpf);
						if(client!=null) {
							client.show();
						}else {
							System.out.println("Cliente não encontrado");
						}
						break;
					case 2:
						double soma=0;
						System.out.println("Total de gasto de todos os clientes: " + cadastro.somaTodos(cadastro.root, soma));
						break;
					case 3:
						System.out.print("Qual valor minimo de gastos para consulta? R$ ");
						double minimo = le.nextDouble();
						int cont=0;
						cont =cadastro.qntMaior(cadastro.root, minimo, cont);
						System.out.println("Existem " + cont + " clientes com gastos superior a " + minimo);
						break;
					case 4:
						break;
					default:
						System.out.println("Opcao invalida");
					}
				} while (op != 4);
				break;
			case 4:
				System.out.print("Informe CPF do cliente que deseja ser retirado do cadastro");
				cpf = le.next();
				if(cadastro.procuraCliente(cadastro.root, cpf)!=null) {
					cadastro.removeValor(cadastro.root, cpf);					
				}else {
					System.out.println("Cliente não encontrado!");
				}

				break;
			default:
				System.out.println("Opcao invalida");
			}
		} while (opcao != 0);
		le.close();
	}
}
