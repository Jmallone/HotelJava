package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelCidade;

public class CidadeDao {
	Coon Con = new Coon();
	
	public void adicionaCidade(ModelCidade ModelCidade){
		
		String sql = "INSERT INTO `caqui`.`cidade` (`Nome`, `Estado_idEstado`) VALUES (?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelCidade.getNome());
			stmt.setLong(2, ModelCidade.getIdEstado());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
