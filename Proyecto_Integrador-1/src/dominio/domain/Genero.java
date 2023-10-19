package dominio.domain;

import java.util.List;

public class Genero{
	
	/**
	 * nombre del genero
	 */
	private String genero;
	private Pelicula pelicula;
	

	
	public Genero() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Genero(String genero, Pelicula pelicula) {
		super();
		this.genero = genero;
		this.pelicula = pelicula;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public Pelicula getPelicula() {
		return pelicula;
	}





	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	@Override
	public String toString() {
		return "" + pelicula.MostrarPelicula() + "]";
	}

	
}
