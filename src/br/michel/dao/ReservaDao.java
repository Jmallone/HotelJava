package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	public List<ModelReserva> getLista(String data) {
	     try {
	        
	    	 List<ModelReserva> reserva = new ArrayList<ModelReserva>();
			String sql = "Select idReservas, hospede.Nome, tipoquarto.nome, reservas.Status, reservas.Telefone, TipoQuarto_idTipo "
					+ "FROM reservas LEFT JOIN hospede ON Hospede_idHospede = idHospede "
					+ "LEFT JOIN tipoquarto ON TipoQuarto_idTipo = idtipoquarto where reservas.Data_Entrada "
					+ "like '"+data+"'";
	        
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql); 
			
	    	 ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	        	 
	             // criando o objeto 
	        	 ModelReserva tipo = new ModelReserva();
	        	 tipo.setIdNome(rs.getInt("idReservas"));
	        	 tipo.setNomeCli(rs.getString("hospede.Nome"));
	        	 tipo.setNomeTipo(rs.getString("tipoquarto.nome"));
	        	 tipo.setStatus(rs.getString("reservas.Status"));
	        	 tipo.setTelefone(rs.getInt("reservas.Telefone"));
	        	 tipo.setIdTipo(rs.getInt("TipoQuarto_idTipo"));
	        	 
	             // adicionando o objeto à lista
	             reserva.add(tipo);
	         }
	         rs.close();
	         stmt.close();
	         return reserva;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	public void populaTable(DefaultTableModel model, String data){
		
		List<ModelReserva> reserva = getLista(data);
		
		for (ModelReserva modelReserva : reserva) {
			
			model.addRow( new Object[]{modelReserva.getIdNome(), modelReserva.getNomeCli(), modelReserva.getNomeTipo(), 
					modelReserva.getStatus(),
					modelReserva.getTelefone(),
					modelReserva.getIdTipo()});
			
		}
		
	}
	
	public void deletaTable(JTable table, DefaultTableModel model){
		
		int count = table.getRowCount();
		for(int i=0; i < count; i++){
			
			model.removeRow(0);
		}
		
	}
	
	public void cancelarReserva(ModelReserva ModelReserva, String status){
		
		String sql = "UPDATE `caqui`.`reservas` SET `Status`='"+status+"' WHERE `idReservas`=?";
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setLong(1, ModelReserva.getIdNome());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
	
}
