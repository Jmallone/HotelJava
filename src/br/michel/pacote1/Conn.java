package br.michel.pacote1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Conn{
	
	 static String url = "jdbc:mysql://localhost:3306/caqui";
	 static String usr = "root";
	 static String pwd = "ifpr123";
	 
	public static void ConectaSql(String sql) {

		try {
			
			Statement sessao = (Statement) conectaMySQL().createStatement();
			sessao.executeUpdate( sql );
			
			//POG
			if(sql.contains("INSERT")){
				
				JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
				
			}else if(sql.contains("DELETE")){
				
				JOptionPane.showMessageDialog(null, "Deletado com sucesso!","Deletado",JOptionPane.ERROR_MESSAGE);  
				
			}
			//END POG
			
		} catch( Exception e ) {
			JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR! \n "+e);
		}finally {
			//sessao.close();
	         }
	}
	
		public static Connection conectaMySQL() {
			
			Connection conexao = null;

			try {
				conexao = (Connection) DriverManager.getConnection(url, usr, pwd );

			} catch (SQLException e) {
				

			} 
			return conexao;
		}
		
		public static ResultSet consulta(String sql){
			
			try{
				
				Statement sessao = (Statement) conectaMySQL().createStatement();
				ResultSet resposta = sessao.executeQuery( sql );
				return resposta;
				
			} catch (SQLException e) {
				
			}
			
			return null;
			
		}
}

