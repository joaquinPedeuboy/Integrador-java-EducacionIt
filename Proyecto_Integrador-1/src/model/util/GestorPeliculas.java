package model.util;

import java.util.ArrayList;
import java.util.List;

import dominio.domain.Pelicula;


public class GestorPeliculas {
	
	private static List<Pelicula> listaDePeliculas;
	
	static {
		listaDePeliculas = new ArrayList<>();
	}

	public static void agregarPelicula(Pelicula pelicula) {
		listaDePeliculas.add(pelicula);
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
	
	public static Pelicula getCodigo(int codigo) {
		Pelicula pelicula = null;
		for(Pelicula p: listaDePeliculas) {
			if(p.getCodigo()== codigo) {
				pelicula = p;
				System.out.println(p.toString());
			}else {
				System.out.println("La pelicula con el codigo " + codigo + " no fue encontrada");
			}
		}
		return pelicula;
	}
	
	
	public static void visualizarPeliculas() {
		for(Pelicula p:listaDePeliculas) {
			System.out.println(p.toString());
		}
	}
	
	
}
