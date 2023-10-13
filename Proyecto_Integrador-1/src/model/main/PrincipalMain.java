package model.main;

import java.util.List;
import java.util.Scanner;

import dominio.domain.Genero;
import dominio.domain.Pelicula;
import model.util.GestorPeliculas;

public class PrincipalMain {
		
	public static void main(String[] args) {
		
		
		
		GestorPeliculas gestor = new GestorPeliculas();
		Pelicula peliculas = new Pelicula("Busqueda Implacable","imagen",111,"busquedaImplacable.com");
		Genero genero = new Genero("Terror","Suspenso","Accion","+18", peliculas);
		peliculas.agregarGeneros(genero);
		gestor.agregarPelicula(peliculas);
		gestor.visualizarPeliculas();
		
		Scanner scanner = new Scanner(System.in);
		boolean esOpcionValida = true;
		int opcion=0;
		do {
			System.out.println("Como desea realizar su busqueda: ");
			System.out.println("1- codigo");
			System.out.println("2- titulo");
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
			System.out.println("Ingrese el codigo a buscar: ");
			int busquedaGenero = scanner.nextInt();
			gestor.getCodigo(busquedaGenero);
			break;
		}
		case 2:{
			System.out.println("Ingrese el titulo a buscar: ");
			String busquedaTitulo = scanner.next();
			gestor.getPelicula(busquedaTitulo);
		}
		
		
	}
}	
}
