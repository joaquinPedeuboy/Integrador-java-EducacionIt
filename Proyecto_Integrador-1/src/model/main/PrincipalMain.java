package model.main;

import java.util.List;
import java.util.Scanner;

import dominio.domain.Genero;
import dominio.domain.Pelicula;
import model.util.GestorPeliculas;

/**
 * En esta clase se inicia la ejecucion de la aplicacion
 */
public class PrincipalMain {
	
	static {
		GestorPeliculas gestor = new GestorPeliculas();
		Pelicula peliculas = new Pelicula("Busqueda Implacable", "Imagen", 222, "Busqueda Implacable.com");
		Genero genero = new Genero("Terror", peliculas);
		Genero genero1 = new Genero("Suspenso", peliculas);
		gestor.agregarPelicula(peliculas);
		gestor.agregarGeneros(genero);
		gestor.agregarGeneros(genero1);
	}
		
	public static void main(String[] args) {
		// Se visualizan las peliculas disponibles
		GestorPeliculas.visualizarPeliculas();
		
		// Se inician las funcionalidades pedidas
		int opcion=0;
		while(opcion!=3) {
			opcion = getOpcion();
			procesarOpcion(opcion);
		}

	}
	
	/**
	 * Permite al usuario decidir por consola como realizar la busqueda de peliculas
	 * @return la opcion elegida por consola
	 */
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
		/**
		 * Permite buscar la pelicula deseada y la muestra
		 * @param opcion elegida anteriormente para la busqueda de peliculas
		 */
			public static void procesarOpcion(int opcion) {
				
			Scanner scanner = new Scanner(System.in);
			switch(opcion) {
			
			case 1:{
				System.out.println("Ingrese el genero a buscar: ");
				String busquedaGenero = scanner.next();
				GestorPeliculas.getGenero(busquedaGenero);
				Scanner scanner1 = new Scanner(System.in);
				boolean esOpcionValida = true;
				int opcion1=0;
				do {
					System.out.println("Si desea ver el detalle completo de la pelicula, ingrese el codigo 1492");
					System.out.println("Si no lo desea ingrese el numero 2");
					String opcionString = scanner1.next();
					try {
						opcion1 = Integer.parseInt(opcionString);
						if(opcion1 != 1492 && opcion1!=2) {
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
				
				switch(opcion1) {
				
				case 1492:{
					GestorPeliculas.visualizarPeliculasCompleta(busquedaGenero);
					break;
				}
				case 2:{
					System.out.println("Esta volviendo al Menu Inicio...");
					System.out.println("------------   ----------");
					break;
				}
				}
				break;
			}
			case 2:{
				System.out.println("Ingrese el titulo a buscar: ");
				String busquedaTitulo = scanner.nextLine();
				GestorPeliculas.getPelicula(busquedaTitulo);
				Scanner scanner1 = new Scanner(System.in);
				boolean esOpcionValida = true;
				int opcion1=0;
				do {
					System.out.println("Si desea ver el detalle completo de la pelicula, ingrese el codigo 1492");
					System.out.println("Si no lo desea ingrese el numero 2");
					String opcionString = scanner1.next();
					try {
						opcion1 = Integer.parseInt(opcionString);
						if(opcion1 != 1492 && opcion1!=2) {
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
				
				switch(opcion1) {
				
				case 1492:{
					GestorPeliculas.visualizarPeliculasCompleta(busquedaTitulo);
					break;
				}
				case 2:{
					System.out.println("Esta volviendo al Menu Inicio...");
					System.out.println("------------   ----------");
					break;
				}
				}
				break;
			}
			case 3:{
				System.out.println("Esta saliendo del buscador");
			}
			
			}
		}
	
}

