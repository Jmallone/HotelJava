package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	
	public void deletaTable(JTable table, DefaultTableModel model){
		
		int count = table.getRowCount();
		for(int i=0; i < count; i++){
			
			model.removeRow(0);
		}
		
	}
	
	public void populaTable(DefaultTableModel model, String data, String cosulta){
		
		List<ModelQuarto> quarto = getLista(data, cosulta);
		
		for (ModelQuarto modelQuarto : quarto) {
			
			model.addRow( new Object[]{modelQuarto.getId(), modelQuarto.getNum(), modelQuarto.getNomeTipo(),modelQuarto.getValor(), modelQuarto.getIdTipo()});
			
		}
		
	}
	
	public List<ModelQuarto> getLista(String dado, String consulta) {
	     try {
	    	 String sql = null;
	    	 List<ModelQuarto> quarto = new ArrayList<ModelQuarto>();
	    	 if (consulta == "ON"){
	    		 
	    	 		sql = "select idQuarto, Numero_Quarto, tipoQuarto.Nome, tipoQuarto.valor, TipoQuarto_idTipo from quarto "
							+ "LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto "
							+ "where Numero_Quarto not in "
							+ "(SELECT quarto.Numero_Quarto FROM caqui.hospedagem  "
							+ "LEFt JOIN Quarto ON Quarto_idQuarto = idQuarto  "
							+ "LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto "
							+ "WHERE hospedagem.Data_Entrada like '"+dado+"' "
							+ "and hospedagem.status like 'Hospedado')";
	    	 		
	    	 }else if (consulta == "OFF"){
	    	 		
	    		 sql = "SELECT idQuarto, quarto.Numero_Quarto, tipoQuarto.Nome,hospede.Nome, tipoQuarto.valor, TipoQuarto_idTipo FROM caqui.hospedagem  "
	    				 	+ "LEFt JOIN hospede ON Hospede_idHospede = idHospede "
							+ "LEFt JOIN Quarto ON Quarto_idQuarto = idQuarto "
							+ "LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto "
							+ "WHERE hospedagem.Data_Entrada like '"+dado+"' "
							+ "and hospedagem.status like 'Hospedado'";
	    		 			
	    	 }
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql); 
			
	    	 ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	        	 
	             // criando o objeto Contato
	        	 ModelQuarto tipo = new ModelQuarto();
	        	 
	        	 tipo.setId(rs.getInt("idQuarto"));
	             tipo.setNum(rs.getString("Numero_Quarto"));
	             tipo.setNomeTipo(rs.getString("Nome"));
	             tipo.setIdTipo(rs.getInt("TipoQuarto_idTipo"));
	             tipo.setValor(rs.getString("tipoQuarto.valor"));
	             // adicionando o objeto à lista
	             quarto.add(tipo);
	         }
	         rs.close();
	         stmt.close();
	         return quarto;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
	
}
