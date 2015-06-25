package br.michel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.michel.modelo.ModelEntrada;
import br.michel.modelo.ModelTipoQuarto;

public class EntradaDao {
	Coon Con = new Coon();
	
	public void adicionaEntrada(ModelEntrada ModelEntrada){
		String sql = "INSERT INTO `caqui`.`hospedagem` "
				+ "(`Status`, `Data_Entrada`, `Hora_Entrada`, `Data_Saida_Prevista`, `Funcionarios_idFuncionarios`, `Hospede_idHospede`, `Quarto_idQuarto`, `Reservas_idReservas`) VALUES "
				+ "('hospedado', '2015-02-02', '13:00', '2015-02-02', '3', '12', '1', '2')";

		
		try{
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql);
			
			//Set values
			stmt.setString(1, ModelEntrada.getStatus() );
			stmt.setString(2, ModelEntrada.getDataAtual());
			stmt.setString(3, ModelEntrada.getHorarioEntrada());
			stmt.setString(4, ModelEntrada.getDataPrev());
			stmt.setLong(5, ModelEntrada.getIdFunc());
			stmt.setLong(6, ModelEntrada.getIdNome());
			stmt.setLong(7, ModelEntrada.getIdNum());
			stmt.setLong(8, ModelEntrada.getIdReserva());
			
			//execute and close
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	
	public List<ModelTipoQuarto> getLista(String fk) {
	     try {
	        
	    	 List<ModelTipoQuarto> valor = new ArrayList<ModelTipoQuarto>();
			String sql = "SELECT quarto.TipoQuarto_idTipo, tipoquarto.valor FROM quarto LEFT JOIN tipoquarto ON idtipoquarto =TipoQuarto_idTipo where Numero_Quarto like '"+fk+"'";
	        
			PreparedStatement stmt = Con.Conecta().prepareStatement(sql); 
			
	    	 ResultSet rs = stmt.executeQuery();
	 
	         while (rs.next()) {
	        	 
	             // criando o objeto Contato
	             ModelTipoQuarto tipo = new ModelTipoQuarto();
	             tipo.setValor(rs.getInt("Valor"));
	             
	             // adicionando o objeto à lista
	             valor.add(tipo);
	         }
	         rs.close();
	         stmt.close();
	         return valor;
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	 }
	
}
