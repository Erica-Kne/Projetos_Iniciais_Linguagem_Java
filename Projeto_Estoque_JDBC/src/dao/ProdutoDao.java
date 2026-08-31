package dao;

import java.util.List;

import entities.Produto;

public interface ProdutoDao {
	
	void insert(Produto produto);
	Produto findById(Integer id);
	List<Produto> findAll();
	void update(Produto produto);
	void deleteById(Integer id);
	
	

}
