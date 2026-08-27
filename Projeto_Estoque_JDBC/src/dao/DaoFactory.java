package dao;

import db.DB;

public class DaoFactory {
	
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC(DB.getConnection());
	}

}
