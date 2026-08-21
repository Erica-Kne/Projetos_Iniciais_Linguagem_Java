package dao;

import java.util.List;

import entities.Produto;

public interface ProdutoDao {
	
	void insert();
	Produto findById();
	List<Produto> findAll();
	void update(Produto produto);
	void deleteById(Integer id);
	
	

}
