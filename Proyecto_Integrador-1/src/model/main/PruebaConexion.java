package model.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
	
	public static void main(String[] args) {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://@localhost:3306/databaseintegrador";
		Connection conexion = null;
		
		try {
			Class.forName(driver);
			
			conexion = DriverManager.getConnection(url, "root", "joa55joa");
			System.out.println("Conexion establecida");
			conexion.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
