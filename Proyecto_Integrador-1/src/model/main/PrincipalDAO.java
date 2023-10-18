package model.main;

import java.util.List;
import java.util.Scanner;

import dao.DAO;
import dao.imp.GeneroDAOImp;
import dao.imp.PeliculaDAOImp;
import dominio.domain.Genero;
import dominio.domain.Pelicula;
import model.util.GestorPeliculas;

public class PrincipalDAO {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean esOpcionValida = true;
		int opcion=0;
		do {
			System.out.println("----------MENU----------");
			System.out.println("Buscador de Peliculas");
			System.out.println("1-Por codigo");
			System.out.println("2-Por titulo");
			System.out.println("\nIngrese una opción: ");
			String opcionString = scanner.next();
			try {
				opcion = Integer.parseInt(opcionString);
				if(opcion != 1 && opcion!=2) {
					System.err.println("Debe ingresar una opción válida");
					esOpcionValida = false;
				}else {
					esOpcionValida=true;
				}
			}catch(Exception ex) {
				System.err.println("Debe ingresar una opción válida");
				esOpcionValida=false;
			}
			
		}while(esOpcionValida!=true);
		
		switch(opcion) {
		case 1:{
			System.out.println("Ingrese el codigo a buscar");
			int codigo = scanner.nextInt();
			DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
			Pelicula peliculaBuscada = peliculaDAO.buscarPorId(codigo);
			if(peliculaBuscada!=null) {
				System.out.println(peliculaBuscada);
			}else {
				System.out.println("La pelicula no existe con ese codigo");
			}
			break;
		}
		case 2:{
			System.out.println("Ingrese el titulo a buscar");
			String titulo = scanner.next();
			DAO<Pelicula, Integer> peliculaDAO = new PeliculaDAOImp();
			Pelicula peliculaBuscada = peliculaDAO.buscarPorTitulo(titulo);
			System.out.println(peliculaBuscada);
			break;
		}
	}
	}
	
}
