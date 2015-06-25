package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelReserva;

public class ReservaDao {

	Coon Con = new Coon();
	
	public void adicionaReserva(ModelReserva ModelReserva){
		
		String sql = "INSERT INTO `caqui`.`reservas` "
				+ "(`Requisitante`, `Telefone`, `Data_Entrada`, `Data_Saida_Prevista`, `Status`, `Hospede_idHospede`, `TipoQuarto_idTipo`, `Funcionarios_idFuncionarios`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelReserva.getRequ());
			stmt.setLong(2, ModelReserva.getTelefone() );
			stmt.setNString(3, ModelReserva.getDataAtual());
			stmt.setNString(4, ModelReserva.getDataFinal());
			stmt.setNString(5, ModelReserva.getStatus());
			
			stmt.setLong(6, ModelReserva.getIdNome());
			stmt.setLong(7, ModelReserva.getIdTipo());
			stmt.setLong(8, ModelReserva.getIdFunc());
			
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
