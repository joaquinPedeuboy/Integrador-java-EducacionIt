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
				System.out.println(p.toString());
			}else {
				System.out.println("La pelicula con el titulo " + titulo + " no fue encontrada");
			}
		}
		
		return pelicula;
	}
	
	public static Genero getGenero(String genero) {
		Genero genero1 = null;
		for(Genero g: listaDeGeneros) {
			if(g.getGenero().contains(genero)) {
				genero1 = g;
				System.out.println(g.toString());
			}else {
				System.out.println("La pelicula con el genero " + genero + " no fue encontrada");
			}
		}
		return genero1;
	}
	
	
	public static void visualizarPeliculas() {
		for(Pelicula p:listaDePeliculas) {
			System.out.println(p);
		}
	}
	
	
}
