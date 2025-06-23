package entidades;

public class Produto {
	
	private String nome;
	private int quantidade = 0;
	private double preco = 0.0;
	private double valorTotal = 0.0;
	
	
	
	public Produto(String nome, int quantidade, double preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
		
	};
	
	public Produto() {};
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public double getPreco() {
		return preco;
	};
	
	public void setPreco(double preco) {
		this.preco = preco;
	};
	
	@Override
	public String toString() {
		return String.format("NOME: %s%nPRECO: %.2f%nQUANTIDADE: %d%n", nome, preco, quantidade);
	};
	
	public void adicionarAoEstoque(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void removerDoEstoque(int quantidade) {
		this.quantidade -= quantidade;
	}
	
	public double getValorTotal() {
		return quantidade * preco;
	};
	
}
