package aplicacao;
import java.util.Scanner;
import java.util.Locale;
import entidades.Produto;
import entidades.Estoque;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale brasil = Locale.forLanguageTag("pt-BR");
		Produto produto = new Produto();
		Estoque estoque = new Estoque();
		int opcao;
		int quantidade;
		String nome;
		
		do {
			System.out.println("\nSELECIONE UMA OPÇÃO\n1. Cadastrar produto\n2. Listar produtos\n3. Buscar produto\n"
					+ "4. Adicionar estoque\n5. Remover do estoque\n6. Remover produto\n7. Exibir valor total em estoque\n"
					+ "0. Sair do sistema\n");
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
			case 1:
				estoque.cadastrarProduto();
				break;
			case 2:
				estoque.listarProdutos();
				break;
			case 3:
				System.out.print("Pesquisar produto: ");
				nome = sc.nextLine();
				produto = estoque.buscarProduto(nome);
				System.out.print(produto);
				break;
			case 4:
				System.out.print("Nome do produto: ");
				nome = sc.nextLine();
				System.out.print("Quantidade a ser adicionada: ");
				quantidade = sc.nextInt();
				sc.nextLine();
				estoque.adicionarQuantidade(nome, quantidade);
				break;
			case 5: 
				System.out.print("Nome do produto: ");
				nome = sc.nextLine();
				System.out.print("Quantidade a ser removida: ");
				quantidade = sc.nextInt();
				sc.nextLine();
				estoque.removerQuantidade(nome, quantidade);
				break;
			case 6:
				System.out.print("Remover produto:");
				nome = sc.nextLine();
				estoque.removerProduto(nome);
				break;
			case 7:
				estoque.valorTotalEstoque();
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;	
			}
			
		} while (opcao != 0);
		
		
		sc.close();
	}

}
