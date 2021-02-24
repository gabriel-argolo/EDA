package gtree;

import java.util.Scanner;

public class Main {

	public static void menu() {
		System.out.println("\n-----------------------------");
		System.out.println("      Árvore Generica          ");
		System.out.println("-------------------------------");
		System.out.println("   1. Iserir um novo Nó        ");
		System.out.println("   2. Remover um Nó            ");
		System.out.println("   3. Buscar um Nó             ");
		System.out.println("   4. Mostrar Árvore           ");
		System.out.println("   5. Mostrar Filhos de um Nó  ");
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
				System.out.println("Inserir nó");
				int value = -1;
				do {
					System.out.println("Insira valor para o nó:");
					value=in.nextInt();
					if (gt.searchNode(value)!=null) {
						System.out.println("Valor ja existente");
					}
				} while (gt.searchNode(value)!=null);
				do {
					System.out.println("Insira o PAI do nó:");
					fatherValue = in.nextInt();
					if (gt.searchNode(fatherValue)==null) {
						System.out.println("\nO nó informado para ser PAI nao existe!");
					}
				} while (gt.searchNode(fatherValue)==null);

				ITree father = gt.searchNode(fatherValue);
				ITree node3 = new Node(value, father);

				gt.add(node3);
				father.add(node3);

				if (gt.searchNode(value) != null) {
					System.out.println("No inserido com sucesso!");
				} else {
					System.out.println("O nó não foi inserido!");
				}
			}
			break;

			case 2:
				System.out.println("Remover NÓ");
				System.out.println("Insira o valor do NO a ser Removido");

				int removeNode = in.nextInt();

				if (gt.searchNode(removeNode) != null) {
					ITree node1 = gt.searchNode(removeNode);
					System.out.println("NO: " +gt.searchNode(removeNode).getData());
					gt.remove(node1);
				}
				break;

			case 3:
				System.out.println("Buscar Nó");
				System.out.println("Insira o Nó a ser pesquisado:");
				int searchNode = in.nextInt();

				if(gt.searchNode(searchNode) == null) {
					System.out.println("Nó nao Encontrado!");
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
				System.out.println("Listar Filhos de um nó");
				System.out.println("Insira o numero do nó para listar os seus filhos");
				int fatherNode = in.nextInt();

				if (gt.searchNode(fatherNode)==null) {
					System.out.println("Nó nao encontrado!");
				}else {
					Node listChild = gt.searchNode(fatherNode);
					System.out.print("Filhos: ");
					listChild.print();
				}
				break;


			default:
				System.out.println("Opção Invalida");;
			}
		} while (opt != 0);
	}

}
