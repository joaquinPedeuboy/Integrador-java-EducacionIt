package model.main;


import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.DAO;
import dao.imp.GeneroDAOImp;
import dao.imp.PeliculaDAOImp;
import dominio.domain.Genero;
import dominio.domain.Pelicula;
public class PruebaConexion {
	
	public static void main(String[] args) {
		
//		DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
//		Pelicula peliculaBuscada = peliculaDAO.buscarPorTitulo("Arma");
//		if(peliculaBuscada!=null) {
//			System.out.println(peliculaBuscada);
//		}else {
//			System.out.println("La pelicula no existe con ese codigo");
//		}
//		DAO<Genero, Integer> generoDAO = new GeneroDAOImp();
//		DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
//		Genero archivo = new Genero("Suspenso", 2);
//		Pelicula nuevaPelicula = new Pelicula("robocop", "img", 9, "robocop.com", archivo);
//		
//		peliculaDAO.insertar(nuevaPelicula);
		
//		DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
//		Pelicula peliculaBuscada = peliculaDAO.buscarPorGenero("Terror");
//		
//		DAO<Genero, Integer> generoDAO = new GeneroDAOImp();
//		
//		Pelicula pelicula = new Pelicula();
//		pelicula.setGenero(generoDAO.buscarPorId(pelicula.getGenero().getId()));
//		System.out.println("Titulo: "+pelicula.getTitulo()+ ", codigo: "+pelicula.getCodigo());
		
		System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));
        System.out.println("Directorio del usuario: " + System.getProperty("user.home"));
        System.out.println("Separador de archivos: " + File.separator);
        System.out.println(System.getProperty("user.home"));
	}
}
