package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.michel.modelo.ModelEndereco;

//Address Inserts
public class EnderecoDao {

	Coon Con = new Coon();
	
	public void adicionaEndereco(ModelEndereco ModelEndereco){
		
		//TODO: colocar o atributo 'CEP' na tabela 'Endereco'
		String sql = "INSERT INTO `caqui`.`endereco` "
				+ "(`Numero`, `Bairro`, `CEP`, `Logradouro`, `Cidade_idCidade`) "
				+ "VALUES (?, ?, ?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelEndereco.getNumero());
			stmt.setString(2, ModelEndereco.getBairro());
			stmt.setString(3, ModelEndereco.getCEP());
			stmt.setString(4, ModelEndereco.getLogradouro());
			stmt.setLong(5, ModelEndereco.getIdCidade());

			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void deletaEndereco(ModelEndereco ModelEndereco){
		
		String sql = "DELETE FROM `caqui`.`endereco` WHERE `idEndereco`=?";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setLong(1, ModelEndereco.getIdCidade());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	// Get the last id on table Address and return
	public int ultimoID(){
		int ids = 0;
		try {
			
			PreparedStatement stmt = Con.Conecta().prepareStatement("SELECT MAX(idEndereco) FROM endereco" );
			ResultSet rs = stmt.executeQuery();
			
			 while(rs.next()){ 
				ids = rs.getInt( "MAX(idEndereco)");
			 }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ids;	
	}
	
}
