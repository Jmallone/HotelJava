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
	
	public void AtualizaCombo(JComboBox<ModelCombo> comboBox, String tabela){
		
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
		
}

