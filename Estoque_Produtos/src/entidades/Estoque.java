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
		System.out.print("Preco: R$ ");
		double preco = sc.nextDouble();
		if(!nome.isEmpty() && quantidade >= 0 && preco > 0.0) {
			
			Produto produto = new Produto (nome, quantidade, preco);
			estoque.add(produto);
			System.out.println("Produto cadastrado.");
			
		} else {
			System.out.println("Nao foi possivel cadastrar o produto:");
			if(nome.isEmpty()) {
				System.out.println("Nome invalido.");	
			};
			if( quantidade < 0) {
				System.out.println("Quantidade invalida.");
			};
			if( preco <= 0.0) {
				System.out.println("Preco invalido.");
			}
		}
		sc.close();
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
}
		
