package gtree;

import java.util.Scanner;

public class Main {

	public static void menu() {
		System.out.println("\n-----------------------------");
		System.out.println("      �rvore Generica          ");
		System.out.println("-------------------------------");
		System.out.println("   1. Iserir um novo N�        ");
		System.out.println("   2. Remover um N�            ");
		System.out.println("   3. Buscar um N�             ");
		System.out.println("   4. Mostrar �rvore           ");
		System.out.println("   5. Mostrar Filhos de um N�  ");
		System.out.println("   0. Fim                      ");
		System.out.println("-----------------------------  ");
		System.out.println("Opcao:");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int fatherValue = -1;

		System.out.println("\nInsira a Raiz da Arvore");
		int root = in.nextInt();

		ITree gt = new GenericTree<Node>();
		ITree node = new Node(root, null);

		gt.add(node);
		int opt;

		do {
			menu();
			opt = in.nextInt();

			switch (opt) {
			case 1: {
				System.out.println("Inserir n�");
				int value = -1;
				do {
					System.out.println("Insira valor para o n�:");
					value=in.nextInt();
					if (gt.searchNode(value)!=null) {
						System.out.println("Valor ja existente");
					}
				} while (gt.searchNode(value)!=null);
				do {
					System.out.println("Insira o PAI do n�:");
					fatherValue = in.nextInt();
					if (gt.searchNode(fatherValue)==null) {
						System.out.println("\nO n� informado para ser PAI nao existe!");
					}
				} while (gt.searchNode(fatherValue)==null);

				ITree father = gt.searchNode(fatherValue);
				ITree node3 = new Node(value, father);

				gt.add(node3);
				father.add(node3);

				if (gt.searchNode(value) != null) {
					System.out.println("No inserido com sucesso!");
				} else {
					System.out.println("O n� n�o foi inserido!");
				}
			}
			break;

			case 2:
				System.out.println("Remover N�");
				System.out.println("Insira o valor do NO a ser Removido");

				int removeNode = in.nextInt();

				if (gt.searchNode(removeNode) != null) {
					ITree node1 = gt.searchNode(removeNode);
					System.out.println("NO: " +gt.searchNode(removeNode).getData());
					gt.remove(node1);
				}
				break;

			case 3:
				System.out.println("Buscar N�");
				System.out.println("Insira o N� a ser pesquisado:");
				int searchNode = in.nextInt();

				if(gt.searchNode(searchNode) == null) {
					System.out.println("N� nao Encontrado!");
				}else {
					System.out.println("O NO " +gt.searchNode(searchNode).getData()+" foi encontrado!");
				}
				break;

			case 4:
				System.out.println("Exibir arvore");
				System.out.println("Arvore: ");
				gt.print();
				break;

			case 5:
				System.out.println("Listar Filhos de um n�");
				System.out.println("Insira o numero do n� para listar os seus filhos");
				int fatherNode = in.nextInt();

				if (gt.searchNode(fatherNode)==null) {
					System.out.println("N� nao encontrado!");
				}else {
					Node listChild = gt.searchNode(fatherNode);
					System.out.print("Filhos: ");
					listChild.print();
				}
				break;


			default:
				System.out.println("Op��o Invalida");;
			}
		} while (opt != 0);
	}

}
