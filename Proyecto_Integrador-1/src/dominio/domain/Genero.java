package dominio.domain;

import java.util.List;

public class Genero{
	
	/**
	 * nombre del genero
	 */
	private String genero;
	private String genero01;
	private String genero02;
	private String genero03;
	private Pelicula pelicula;
	

	
	public Genero() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Genero(String genero, String genero01, String genero02, String genero03, Pelicula pelicula) {
		super();
		this.genero = genero;
		this.genero01 = genero01;
		this.genero02 = genero02;
		this.genero03 = genero03;
		this.pelicula = pelicula;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}





	public String getGenero01() {
		return genero01;
	}





	public void setGenero01(String genero01) {
		this.genero01 = genero01;
	}





	public String getGenero02() {
		return genero02;
	}





	public void setGenero02(String genero02) {
		this.genero02 = genero02;
	}





	public String getGenero03() {
		return genero03;
	}





	public void setGenero03(String genero03) {
		this.genero03 = genero03;
	}





	public Pelicula getPelicula() {
		return pelicula;
	}





	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}


	@Override
	public String toString() {
		return "" + pelicula + "]";
	}


	
	
	

	
}
