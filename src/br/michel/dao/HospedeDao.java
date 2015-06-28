package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	public void deletaHospede(ModelHospede ModelHospede){
		
		String sql = "DELETE FROM `caqui`.`hospede` WHERE `idHospede`=?";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			System.out.println("\n ID: "+ModelHospede.getId()+"\n ");
			stmt.setLong(1, ModelHospede.getId());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List<ModelHospede> getLista() {
	     try {
	        
	    	 List<ModelHospede> hospede = new ArrayList<ModelHospede>();
			String sql = "SELECT hospede.idHospede, hospede.Nome, hospede.Email, hospede.Telefone, Endereco_idEndereco  FROM hospede ";
	        
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql); 
			
	    	 ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	        	 
	             // criando o objeto Contato
	        	 ModelHospede tipo = new ModelHospede();
	        	 tipo.setId(rs.getInt("idHospede"));
	             tipo.setNome(rs.getString("Nome"));
	             tipo.setEmail(rs.getString("Email"));
	             tipo.setTelefone(rs.getString("Telefone"));
	             tipo.setId_end(rs.getInt("Endereco_idEndereco"));
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
	
	public void deletaTable(JTable table, DefaultTableModel model){
		
		int count = table.getRowCount();
		for(int i=0; i < count; i++){
			
			model.removeRow(0);
		}
		
	}
	
	public void populaTable(DefaultTableModel model){
		
		List<ModelHospede> hospede = getLista();
		
		for (ModelHospede modelHospede : hospede) {
			
			model.addRow( new Object[]{modelHospede.getId() ,modelHospede.getNome(), modelHospede.getEmail(), modelHospede.getTelefone(), modelHospede.getId_end()});
			
		}
		
	}
	
	
}