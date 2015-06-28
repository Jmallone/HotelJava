package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import br.michel.modelo.ModelCombo;

public class ComboDao {

	Coon Con = new Coon();
		 
	//Get FK ComboBox and return
	public int FkRadio(JComboBox<?> comboBox){ 
		
		ModelCombo i = (ModelCombo) comboBox.getSelectedItem();  
		return i.id;
		
	}
	
	public String nomefk(JComboBox<?> comboBox){ 
		
		ModelCombo i = (ModelCombo) comboBox.getSelectedItem();  
		return i.nome;
		
	}
	
	public void AtualizaCombo(JComboBox<ModelCombo> comboBox, String tabela){
		
		comboBox.removeAllItems();
		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement("SELECT * from "+tabela);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//Creating object 
				int id = rs.getInt("id"+tabela);  
		        String nome = rs.getString("Nome");  
		        comboBox.addItem(new ModelCombo(id,nome));
				
			}
			
			rs.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
        
		}
	}
	
	
	//POG
	public void AtualizaComboNum(JComboBox<ModelCombo> comboBox, String data){
		
		comboBox.removeAllItems();
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement("select idQuarto, Numero_Quarto, Nome from quarto LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto where Numero_Quarto not in (SELECT quarto.Numero_Quarto FROM caqui.hospedagem LEFt JOIN Quarto ON Quarto_idQuarto = idQuarto LEFt JOIN TipoQuarto ON TipoQuarto_idTipo = idtipoquarto WHERE hospedagem.Data_Entrada like '"+data+"' and hospedagem.status like 'Hospedado')");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//Creating object 
				int id = rs.getInt("idQuarto");  
		        String nome = rs.getString("Numero_Quarto");  
		        comboBox.addItem(new ModelCombo(id,nome));
				
			}
			
			rs.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
        
		}
	}
	
	public void AtualizaComboSaida(JComboBox<ModelCombo> comboBox, String data){
		
		comboBox.removeAllItems();
		try{
			String sql = "SELECT hospedagem.idHospedagem, hospedagem.Data_Saida_Prevista, hospede.Nome FROM hospedagem  LEFt JOIN hospede ON Hospede_idHospede = idHospede  WHERE hospedagem.Data_Saida_Prevista "
					+ "like '"+data+"'  and hospedagem.status like 'Hospedado'";
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				//Creating object 
				int id = rs.getInt("idHospedagem");  
		        String nome = rs.getString("Nome");  
		        comboBox.addItem(new ModelCombo(id,nome));
				
			}
			
			rs.close();
			stmt.close();
			
		}catch (SQLException e) {
			
			throw new RuntimeException(e);
        
		}
	}

		
}

