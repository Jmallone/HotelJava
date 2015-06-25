package br.michel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//connection databse 
public class Coon {
	static String url = "jdbc:mysql://localhost:3306/caqui";
	static String usr = "root";
	static String pwd = "ifpr123";
	Connection conexao ;
		 
	public Connection Conecta(){
		try {
			
			conexao = (Connection) DriverManager.getConnection(url, usr, pwd );
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return conexao;
	}
	
	//TODO: FECHAR A CONEXAO .CLOSE OU USAR SINGLETON
}
