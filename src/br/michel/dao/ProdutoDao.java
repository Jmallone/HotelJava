package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.michel.modelo.ModelProduto;

public class ProdutoDao {
	
	Coon Con = new Coon();
	
	public void adicionaProduto(ModelProduto ModelProduto){
		
			String sql = "INSERT INTO `caqui`.`produtos` "
					+ "(`Nome`, `Valor`, `Quantidade`,  `Descricao`, `Grupo_Produtos_idGrupo_Produtos`) "
					+ "VALUES (?, ?, ?, ?, ?)";

		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelProduto.getNome());
			stmt.setString(2, ModelProduto.getValor());
			stmt.setString(3, ModelProduto.getQtd());
			stmt.setString(4, ModelProduto.getDesc());;
			stmt.setLong(5, ModelProduto.getIdGrupo());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public List<ModelProduto> getLista(String dado) {
	     try {
	        
	    	 List<ModelProduto> produto = new ArrayList<ModelProduto>();
	    	 String sql;
	    	 if(dado == ""){
	    		 sql = "SELECT * FROM caqui.produtos";
	    	 }else {
	    		 
	    		 sql = "SELECT * FROM caqui.produtos where idProdutos = "+dado+"";
	    	 }
	        
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql); 
			
	    	 ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	        	 
	             // criando o objeto Contato
	        	 ModelProduto tipo = new ModelProduto();
	        	 
	        	 tipo.setId(rs.getInt("idProdutos"));
	             tipo.setNome(rs.getString("Nome"));
	             tipo.setValor(rs.getString("Valor"));
	             tipo.setQtd(rs.getString("Quantidade"));
	             tipo.setDesc(rs.getString("Descricao"));
	             tipo.setIdGrupo(rs.getInt("Grupo_Produtos_idGrupo_Produtos"));

	             // adicionando o objeto à lista
	             produto.add(tipo);
	         }
	         rs.close();
	         stmt.close();
	         return produto;
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
	
	public void deletarProduto(ModelProduto ModelProduto){
		
		String sql = "DELETE FROM `caqui`.`produtos` WHERE `idProdutos`=?";
		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setLong(1, ModelProduto.getId());

			
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void editarProduto(ModelProduto ModelProduto){
		
		String sql = "UPDATE `caqui`.`produtos` "
				+ "SET `Nome`=?, `Valor`=?, `Quantidade`=?, `Descricao`=?, `Grupo_Produtos_idGrupo_Produtos`=? WHERE `idProdutos`=?";
		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelProduto.getNome());
			stmt.setString(2, ModelProduto.getValor());
			stmt.setString(3, ModelProduto.getQtd());
			stmt.setString(4, ModelProduto.getDesc());;
			stmt.setLong(5, ModelProduto.getIdGrupo());
			stmt.setLong(6, ModelProduto.getId());
			
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}

		
	}
	
	public void populaTable(DefaultTableModel model){
		
		List<ModelProduto> produto = getLista("");
		
		for (ModelProduto modelProduto : produto) {
			
			model.addRow( new Object[]{modelProduto.getId(), modelProduto.getNome(), modelProduto.getValor(), modelProduto.getQtd(), modelProduto.getIdGrupo()});
			
		}
		
	}

	
}
