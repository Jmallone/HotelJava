package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.michel.modelo.ModelHospede;

public class HospedeDao {
	
	Coon Con = new Coon();
	/*static String url = "jdbc:mysql://localhost:3306/caqui";
	static String usr = "root";
	static String pwd = "ifpr123";*?
	//Connection conexao ;
		 
	public HospedeDao(){
		/*try {
			
			this.conexao = (Connection) DriverManager.getConnection(url, usr, pwd );
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}*/
	
	public void adicionaHospede(ModelHospede ModelHospede){
		
		String sql = "INSERT INTO `caqui`.`hospede` "
				+ "(`Nome`, `RG`, `CPF`, `Telefone`, `Celular`, `Email`, `Endereco_idEndereco`) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?)";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, ModelHospede.getNome());
			stmt.setString(2, ModelHospede.getRG());
			stmt.setString(3, ModelHospede.getCPF());
			stmt.setString(4, ModelHospede.getTelefone());
			stmt.setString(5, ModelHospede.getCelular());
			stmt.setString(6, ModelHospede.getEmail());
			stmt.setLong(7, ModelHospede.getId_end());
			
			//executa e fecha 
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	
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