package model.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO;
import dao.imp.PeliculaDAOImp;
import dominio.domain.Pelicula;

public class PruebaConexion {
	
	public static void main(String[] args) {
		
		DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
		Pelicula peliculaBuscada = peliculaDAO.buscarPorTitulo("Arma");
		if(peliculaBuscada!=null) {
			System.out.println(peliculaBuscada);
		}else {
			System.out.println("La pelicula no existe con ese codigo");
		}
	}
}
