package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public void insert(Produto produto) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO estoque"
					+ " (nome, descricao, preco, quantidade)"
					+ "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);		
			st.setString(1, produto.getNome());
			st.setString(2, produto.getDescricao());
			st.setDouble(3, produto.getPreco());
			st.setInt(4, produto.getQuantidade());
			
			int linhasAlteradas = st.executeUpdate();
			
			if(linhasAlteradas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					produto.setId(id);
				} DB.closeResultSet(rs);
			}else{
				throw new DbException("ERRO: produto não adicionado.");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			}
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
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE estoque"
					+ " SET nome = ? , descricao = ? , preco = ? , quantidade = ?"
					+ "WHERE id = ?");		
			st.setString(1, produto.getNome());
			st.setString(2, produto.getDescricao());
			st.setDouble(3, produto.getPreco());
			st.setInt(4, produto.getQuantidade());
			st.setInt(5, produto.getId());
			st.executeUpdate();
			} catch(SQLException e) {
				throw new DbException(e.getMessage());
			}finally {
				DB.closeStatement(st);
		}
	}
		
		
	

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM estoque WHERE id = ?");
			st.setInt(1, id);
			int linhasAlteradas = st.executeUpdate();
			if(linhasAlteradas > 0) {
				System.out.println("Produto deletado com sucesso.");
			}else{
				throw new DbException("ERRO: o produto não existe.");
			}
		} catch(SQLException e) {
			throw new DbException(e.getLocalizedMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

}
