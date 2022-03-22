package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

	
	public Connection conectarBD() {
		Connection con = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&password=";
			con = DriverManager.getConnection(url);
			
		}
		catch(SQLException e) {
			System.out.println("Erro: " + e.getMessage());		
		}
		
		
		return con;
	}
	
	
}
