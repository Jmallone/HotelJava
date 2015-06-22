package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.michel.modelo.ModelFuncionario;

//Staff Inserts
public class FuncionarioDao {
	
	Coon Con = new Coon();
	
	public void adicionaFuncionario(ModelFuncionario ModelFuncionario){
	
		String sql = "INSERT INTO `caqui`.`funcionarios` "
				+ "(`Nome`, `RG`, `CPF`, `Telefone`, `Data_Nascimento`, `Numero_Carteira_Trabalho`, `Celular`, `Email`, `Data_Admissao`, `Funcao`, `Endereco_idEndereco`) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelFuncionario.getNome());
			stmt.setString(2, ModelFuncionario.getRG());
			stmt.setString(3, ModelFuncionario.getCPF());
			stmt.setString(4, ModelFuncionario.getTelefone());
			stmt.setNString(5, ModelFuncionario.getNasci());
			stmt.setNString(6, ModelFuncionario.getCarteira());
			stmt.setString(7, ModelFuncionario.getCelular());
			stmt.setString(8, ModelFuncionario.getEmail());
			stmt.setString(9, ModelFuncionario.getAdmissao());
			stmt.setString(10, ModelFuncionario.getFuncao());
			stmt.setLong(11, ModelFuncionario.getId_end());
			
			//execute and close 
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
		
}
