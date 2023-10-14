package model.main;

import java.util.List;
import java.util.Scanner;

import dominio.domain.Genero;
import dominio.domain.Pelicula;
import model.util.GestorPeliculas;

public class PrincipalMain {
	
	static {
		GestorPeliculas gestor = new GestorPeliculas();
		Pelicula peliculas = new Pelicula("Busqueda Implacable", "Imagen", 222, "Busqueda Implacable.com");
		Genero genero = new Genero("Terror","Suspenso","Accion","Triller", peliculas);
		gestor.agregarPelicula(peliculas);
		gestor.agregarGeneros(genero);
	}
		
	public static void main(String[] args) {
		GestorPeliculas.visualizarPeliculas();
		
		int opcion=0;
		while(opcion!=3) {
			opcion = getOpcion();
			procesarOpcion(opcion);
		}

	}
		public static int getOpcion() {
			Scanner scanner = new Scanner(System.in);
			boolean esOpcionValida = true;
			int opcion=0;
			do {
				System.out.println("Bienvenido al buscador de PELICULAS");
				System.out.println("Como desea realizar su busqueda: ");
				System.out.println("1- Genero");
				System.out.println("2- titulo");
				System.out.println("3- Salir");
				String opcionString = scanner.next();
				try {
					opcion = Integer.parseInt(opcionString);
					if(opcion != 1 && opcion!=2 && opcion!=3) {
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
			return opcion;
			}
			public static void procesarOpcion(int opcion) {
				
			Scanner scanner = new Scanner(System.in);
			switch(opcion) {
			
			case 1:{
				System.out.println("Ingrese el genero a buscar: ");
				String busquedaGenero = scanner.next();
				System.out.println("Todas las peliculas con el genero buscado");
				GestorPeliculas.getGenero(busquedaGenero);
				break;
			}
			case 2:{
				System.out.println("Ingrese el titulo a buscar: ");
				String busquedaTitulo = scanner.nextLine();
				System.out.println("Todas las peliculas con el titulo buscado");
				GestorPeliculas.getPelicula(busquedaTitulo);
				
				break;
			}
			case 3:{
				System.out.println("Esta saliendo del buscador");
			}
			
			}
		}
}

