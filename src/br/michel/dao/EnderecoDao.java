package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.michel.modelo.ModelFuncionario;
import br.michel.modelo.ModelHospede;

public class EnderecoDao {

	Coon Con = new Coon();
	
	public void adicionaEndereco(ModelHospede ModelHospede){
		
		//TODO: colocar o atributo 'CEP' na tabela 'Endereco'
		String sql = "INSERT INTO `caqui`.`endereco` "
				+ "(`Numero`, `Bairro`, `CEP`, `Logradouro`, `Cidade_idCidade`) "
				+ "VALUES (?, ?, ?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, ModelHospede.getNumero());
			stmt.setString(2, ModelHospede.getBairro());
			stmt.setString(3, ModelHospede.getCEP());
			stmt.setString(4, ModelHospede.getLogradouro());
			stmt.setLong(5, ModelHospede.getId());

			//executa
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	//TODO: Ver como resolve essa redundancia
	//Redundancia Detected 
	public void adicionaEndereco2(ModelFuncionario ModelFuncionario){
		
		//TODO: colocar o atributo 'CEP' na tabela 'Endereco'
		String sql = "INSERT INTO `caqui`.`endereco` "
				+ "(`Numero`, `Bairro`, `CEP`, `Logradouro`, `Cidade_idCidade`) "
				+ "VALUES (?, ?, ?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, ModelFuncionario.getNumero());
			stmt.setString(2, ModelFuncionario.getBairro());
			stmt.setString(3, ModelFuncionario.getCEP());
			stmt.setString(4, ModelFuncionario.getLogradouro());
			stmt.setLong(5, ModelFuncionario.getId());

			//executa
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	//Pega o ultimo id cadastrado na tabela Endereço e retorna
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
