package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao{
	
	private Connection conn;
	
	public ProdutoDaoJDBC(Connection conn) {
		this.conn= conn;	}

	
	private Produto instanciarProduto(ResultSet rs) throws SQLException {
		Produto produto = new Produto();
		produto.setId(rs.getInt("id"));
		produto.setNome(rs.getString("nome"));
		produto.setDescricao(rs.getString("descricao"));
		produto.setPreco(rs.getDouble("preco"));
		produto.setQuantidade(rs.getInt("quantidade"));
		return produto;
	}
	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM produto WHERE id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Produto produto = instanciarProduto(rs);
				return produto;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Produto> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List <Produto> list = new ArrayList<>();
		try {
			st = conn.prepareStatement("SELECT * FROM produto");
			rs = st.executeQuery();
			if(rs.next()) {
				Produto produto = instanciarProduto(rs);
				list.add(produto);
			}
		} catch (SQLException e) {
			throw new DbException (e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		} return list;
	}

	@Override
	public void update(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
