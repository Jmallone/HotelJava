package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelGrupoProd;

public class GrupoProdDao {

	Coon Con = new Coon();
	
	public void adicionaGrupoProd(ModelGrupoProd ModelGrupoProd){
		
		String sql = "INSERT INTO `caqui`.`grupo_produtos` (`Nome`, `Descricao`) "
				+ "VALUES (?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelGrupoProd.getNome());
			stmt.setString(2, ModelGrupoProd.getDesc());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
