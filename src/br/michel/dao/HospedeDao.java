package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelHospede;

//Guests Inserts
public class HospedeDao {
	
	Coon Con = new Coon();
	
	public void adicionaHospede(ModelHospede ModelHospede){
		
		String sql = "INSERT INTO `caqui`.`hospede` "
				+ "(`Nome`, `RG`, `CPF`, `Telefone`, `Celular`, `Email`, `Endereco_idEndereco`) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelHospede.getNome());
			stmt.setString(2, ModelHospede.getRG());
			stmt.setString(3, ModelHospede.getCPF());
			stmt.setString(4, ModelHospede.getTelefone());
			stmt.setString(5, ModelHospede.getCelular());
			stmt.setString(6, ModelHospede.getEmail());
			stmt.setLong(7, ModelHospede.getId_end());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
}