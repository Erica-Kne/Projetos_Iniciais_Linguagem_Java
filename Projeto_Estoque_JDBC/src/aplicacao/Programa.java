package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;

public class Programa {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		
		String sql = "INSERT INTO pessoas(nome, idade, email) VALUES (? , ?, ?)";
		
		try{
			PreparedStatement ps =  conn.prepareStatement(sql);
			
			ps.setString(1, "Maria");
			ps.setInt(2, 29);
			ps.setString(3, "maria@gmail.com");
			
			int linhas = ps.executeUpdate();	
			System.out.println("Linhas alteradas: " + linhas);
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	
		DB.closeConnection();
		
	}

}
