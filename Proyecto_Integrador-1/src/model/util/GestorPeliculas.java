package model.util;

import java.util.ArrayList;
import java.util.List;

import dominio.domain.Genero;
import dominio.domain.Pelicula;


public class GestorPeliculas {
	
	private static List<Pelicula> listaDePeliculas;
	private static List<Genero> listaDeGeneros;
	
	static {
		listaDePeliculas = new ArrayList<>();
		listaDeGeneros = new ArrayList<>();
	}

	public void agregarPelicula(Pelicula pelicula) {
		listaDePeliculas.add(pelicula);
	}
	
	public void agregarGeneros (Genero genero) {
		listaDeGeneros.add(genero);
	}
	
	public static Pelicula getPelicula(String titulo) {
		Pelicula pelicula = null;
		for(Pelicula p: listaDePeliculas) {
			if(p.getTitulo().contains(titulo)) {
				pelicula = p;
				System.out.println("Todas las peliculas con el titulo buscado");
				System.out.println(p.MostrarPelicula());
				System.out.println("------------   ----------");
			}
		}
		
		return pelicula;
	}
	
	public static Genero getGenero(String genero) {
		Genero genero1 = null;
		for(Genero g: listaDeGeneros) {
			if(g.getGenero().contains(genero)) {
				genero1 = g;
				System.out.println("Todas las peliculas con el genero buscado: ");
				System.out.println(g.toString());
				System.out.println("------------   ----------");
			}
		}
		return genero1;
	}
	
	
	public static void visualizarPeliculas() {
		for(Pelicula p:listaDePeliculas) {
			System.out.println(p);
			System.out.println("------------   ----------");
		}
	}
	
	public static void visualizarPeliculasCompleta() {
		for(Pelicula p:listaDePeliculas) {
			System.out.println(p.toString());
			System.out.println("------------   ----------");
		}
	}
}
