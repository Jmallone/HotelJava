package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.michel.modelo.ModelSaida;
import br.michel.modelo.ModelTipoQuarto;

public class SaidaDao {
	Coon Con = new Coon();
	
	public List<ModelSaida> getLista(String data) {
	     try {
	        
	    	 List<ModelSaida> hospede = new ArrayList<ModelSaida>();
			String sql = "SELECT hospedagem.idHospedagem, hospedagem.Data_Saida_Prevista, hospede.Nome FROM hospedagem  LEFt JOIN hospede ON Hospede_idHospede = idHospede  WHERE hospedagem.Data_Saida_Prevista "
					+ "like '"+data+"'";
	        
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql); 
			
	    	 ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	        	 
	             // criando o objeto Contato
	        	 ModelSaida tipo = new ModelSaida();
	             tipo.setIdHospedagem(rs.getInt("idHospedagem"));
	             tipo.setNome(rs.getString("Nome"));
	             // adicionando o objeto à lista
	             hospede.add(tipo);
	         }
	         rs.close();
	         stmt.close();
	         return hospede;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void adicionaSaida(ModelSaida ModelSaida){
		
		String sql = "UPDATE `caqui`.`hospedagem` SET `Status`=?, `Data_Saida`=?, `Hora_Saida`=? WHERE `idHospedagem`=?";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelSaida.getStatus() );
			stmt.setString(2, ModelSaida.getDataSaida());
			stmt.setString(3, ModelSaida.getHorarioSaida());
			stmt.setLong(4, ModelSaida.getIdHospedagem());
		
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
}
