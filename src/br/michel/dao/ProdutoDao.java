package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelProduto;

public class ProdutoDao {
	
	Coon Con = new Coon();
	
	public void adicionaProduto(ModelProduto ModelProduto){
		
		String sql = "INSERT INTO `caqui`.`produtos` "
				+ "(`Nome`, `Valor`, `Quantidade`,  `Descricao`, `Grupo_Produtos_idGrupo_Produtos`) "
				+ "VALUES (?, ?, ?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelProduto.getNome());
			stmt.setString(2, ModelProduto.getValor());
			stmt.setString(3, ModelProduto.getQtd());
			stmt.setString(4, ModelProduto.getDesc());;
			stmt.setLong(5, ModelProduto.getIdGrupo());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
