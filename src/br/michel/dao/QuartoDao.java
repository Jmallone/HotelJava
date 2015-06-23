package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelQuarto;

public class QuartoDao {

	Coon Con = new Coon();
	
	public void adicionaQuarto(ModelQuarto ModelQuarto){
		
		String sql = "INSERT INTO `caqui`.`quarto` (`Numero_Quarto`, `Status`, `TipoQuarto_idTipo`) VALUES "
				+ "(?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelQuarto.getNum());
			stmt.setString(2, ModelQuarto.getStatus());
			stmt.setLong(3, ModelQuarto.getIdTipo());
			
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
}
