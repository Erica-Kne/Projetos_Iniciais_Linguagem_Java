package entidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
	
	Scanner sc = new Scanner(System.in);
	private List<Produto> estoque = new ArrayList<>();
	
	
	public void cadastrarProduto() {
		
		System.out.print("Nome do produto: ");
		String nome = sc.nextLine().trim();
		System.out.print("Quantidade: ");
		int quantidade = sc.nextInt();
		System.out.print("Preço: R$ ");
		double preco = sc.nextDouble();
		sc.nextLine();
		if(!nome.isEmpty() && quantidade >= 0 && preco > 0.0) {
			
			Produto produto = new Produto (nome, quantidade, preco);
			estoque.add(produto);
			System.out.println("Produto cadastrado.");
			
		} else {
			System.out.println("Não foi possível cadastrar o produto:");
			if(nome.isEmpty()) {
				System.out.println("Nome inválido.");	
			};
			if( quantidade < 0) {
				System.out.println("Quantidade inválida.");
			};
			if( preco <= 0.0) {
				System.out.println("Preço inválido.");
			}
		}
	};
	
	public void listarProdutos() {
		for(Produto produto : estoque) {
			System.out.println(produto);
		};
	};
	
	public Produto buscarProduto(String nome) {
		for(Produto produto : estoque) {
			if(produto.getNome().equalsIgnoreCase(nome)) {
			return produto;
			}
		} return null;
		}
	public void removerProduto (String nome) {
		boolean remover = estoque.removeIf(produto -> produto.getNome().equalsIgnoreCase(nome));
		if(remover) {
			System.out.print(nome + " removido do estoque.%n");	
		} else {
			System.out.print(nome + " não encontrado no estoque.%n");
		}
		}
	
	public void adicionarQuantidade(String nome, int quantidade) {
		boolean encontrado = false;
		for(Produto produto : estoque){
			if (produto.getNome().equalsIgnoreCase(nome)) {
				if(quantidade > 0){
					produto.setQuantidade(produto.getQuantidade() + quantidade);
					System.out.println("Quantidade adicionada com sucesso");
					encontrado = true;
					break;
					} else {
						System.out.println("Valor inválido.");
						encontrado = true;
						}
				}
			} 
		if(!encontrado) {
			System.out.println("Produto não encontrado.");
			}
		}
	
	public void removerQuantidade(String nome, int quantidade) {
		boolean encontrado = false;
		for(Produto produto : estoque) {
			if(produto.getNome().equalsIgnoreCase(nome)) {
				if(quantidade > 0 && quantidade <= produto.getQuantidade()) {
					produto.setQuantidade( produto.getQuantidade() - quantidade);
					System.out.println("Quantidade removida com sucesso.");
					} else {
						System.out.println("Valor inválido. A quantidade deve ser maior que zero e menor ou igual ao estoque.");
						}
				encontrado = true;
				break;
				}
			}
		if(!encontrado) {
			System.out.println("Produto não encontrado.");
			}
		}
	
	public void valorTotalEstoque() {
		double valorTotal = 0.0;
		for(Produto produto : estoque) {
			valorTotal += produto.getValorTotal();
		}
		System.out.printf("Valor total em estoque: R$ %.2f\n", valorTotal);
	}
	}

		
