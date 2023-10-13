package dominio.domain;

public class Genero {
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





	@Override
	public String toString() {
		return "Genero [nombreGenero=" + genero + "]";
	}
	
	
}
