package br.michel.pacote1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Control {
	static Connection con = Conn.conectaMySQL();
	
	static void Click(JComboBox comboBox, String tabela){
		
		comboBox.removeAllItems(); // Remove todos os Itens dentro do ComboBox
		
		try {
			ResultSet resposta = Conn.consulta("SELECT * from "+tabela); // Bad pratic '*'
			
			while( resposta.next()) {
				
				int id = resposta.getInt("id"+tabela);  
		        String nome = resposta.getString("Nome");  
		        comboBox.addItem(new Item(id,nome));
 
			}
		} catch( Exception e1 ) {
			JOptionPane.showMessageDialog(null, "Aconteceu um erro \n "+e1 );
		}
		
	}
	
	static int FkRadio(JComboBox comboBox){ // pega a Fk do comboBox e retorna
		
		Item i = (Item) comboBox.getSelectedItem();  
		//int id = i.id;
		return i.id;
		
	}
	
}
