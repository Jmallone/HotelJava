package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelTipoQuarto;

public class TipoQuartoDao {

	Coon Con = new Coon();
	
	public void adicionaTipoQuarto(ModelTipoQuarto ModelTipoQuarto){
		
		String sql = "INSERT INTO `caqui`.`tipoquarto` (`Nome`, `Descricao`, `Valor`) VALUES"
				+ " (?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelTipoQuarto.getNome());
			stmt.setString(2, ModelTipoQuarto.getDesc());
			stmt.setLong(3, ModelTipoQuarto.getValor());
			
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
}
