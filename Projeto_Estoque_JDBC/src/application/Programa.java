package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.ProdutoDao;
import entities.Produto;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		Integer opcao = null;
		String nome, descricao;
		int quantidade;
		double preco;
		List<Produto> produtos = new ArrayList<>();
		
		do {
			System.out.println("==== SISTEMA DE ESTOQUE ====\n"
					+ "1 - Cadastrar produto\n"
					+ "2 - Listar produtos\n"
					+ "3 - Buscar produto\n"
					+ "4 - Atualizar produto\n"
					+ "5 - Excluir produto\n"
					+ "6 - Entrada de estoque\n"
					+ "7 - Saída de estoque\n"
					+ "0 - Sair");
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
				case 1 -> {
					System.out.print("Nome : ");
					nome = sc.nextLine();
					System.out.print("Descrição : ");
					descricao = sc.nextLine();
					System.out.print("Preço : ");
					preco = sc.nextDouble();
					System.out.print("Quantidade : ");
					quantidade = sc.nextInt();
					sc.nextLine();
					Produto produto = new Produto(nome,descricao, preco, quantidade);
					produtoDao.insert(produto);
				}
				case 2 -> {
					produtos = produtoDao.findAll();
					for(Produto p : produtos) {
						System.out.println(p);
						System.out.println("_____________________________________");
					}
				}
				case 3 -> {
					System.out.print("Digite o ID do produto: ");
					Integer id = Integer.valueOf(sc.nextInt());
					Produto produto = produtoDao.findById(id);
					if(produto != null) {
						System.out.println(produto);
					}else {
						System.out.println("Produto não encontrado.");
						}
					}
				case 4 -> {
					System.out.print("Digite o ID do produto a ser alterado: ");
					int id = sc.nextInt();
					sc.nextLine();
					Produto produto = produtoDao.findById(id);
					if(produto!= null) {
						System.out.println("INSIRA AS ALTERAÇÕES");
						System.out.print("Nome : ");
						produto.setNome(sc.nextLine());
						System.out.print("Descrição : ");
						produto.setDescricao(sc.nextLine());
						System.out.print("Preço : ");
						produto.setPreco(sc.nextDouble());
						System.out.print("Quantidade : ");
						produto.setQuantidade(sc.nextInt());
						sc.nextLine();
						produtoDao.update(produto);
						System.out.println("Produto alterado!");
						}
					}
				}
			
		} while(opcao != 0);
		
		sc.close();

	}
}
