package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelEstado;

public class EstadoDao {
	
	Coon Con = new Coon();
	
	public void adicionaEstado(ModelEstado ModelEstado){
		
		String sql = "INSERT INTO `caqui`.`estado` (`Nome`) VALUES (?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelEstado.getNome());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
		
}