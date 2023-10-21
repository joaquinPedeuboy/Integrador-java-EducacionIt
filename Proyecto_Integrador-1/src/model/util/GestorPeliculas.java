package model.util;

import java.util.ArrayList;
import java.util.List;

import dominio.domain.Genero;
import dominio.domain.Pelicula;

public class GestorPeliculas {
	
	/**
	 * Simula los registros de peliculas
	 */
	private static List<Pelicula> listaDePeliculas;
	private static List<Genero> listaDeGeneros;
	
	static {
		listaDePeliculas = new ArrayList<>();
		listaDeGeneros = new ArrayList<>();
	}

	/**
	 * Agrega una pelicula a los registros
	 * @param pelicula la pelicula a agregar
	 */
	public void agregarPelicula(Pelicula pelicula) {
		listaDePeliculas.add(pelicula);
	}
	/**
	 * Agrega un genero a una pelicula
	 * @param genero el genero a agregar
	 */
	public void agregarGeneros (Genero genero) {
		listaDeGeneros.add(genero);
	}
	
	/**
	 * Busca una pelicula en los registros
	 * @param titulo el titulo a buscar
	 * @return una pelicula si existe de lo contrario null
	 */
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
	
	/**
	 * Busca un genero en los registros
	 * @param genero genero de la pelicula a buscar
	 * @return una pelicula con el genero buscado
	 */
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
	
	/**
	 * Permite visualizar todas las peliculas existentes
	 */
	public static void visualizarPeliculas() {
		for(Pelicula p:listaDePeliculas) {
			System.out.println(p);
			System.out.println("------------   ----------");
		}
	}
	
	/**
	 * Permite visualizar el detalle completo de las peliculas existentes por parametro
	 * @param busquedaTitulo el titulo de la pelicula buscada
	 */
	public static void visualizarPeliculasCompleta(String busquedaTitulo) {
		for(Pelicula p:listaDePeliculas) {
			System.out.println(p.toString());
			System.out.println("------------   ----------");
		}
	}

}
