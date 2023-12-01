package dominio.domain;

import java.io.File;

public class Pelicula {
	
	/**
	 * titulo de la pelicula
	 */
	private String titulo;
	/**
	 * imagen de la pelicula
	 */
	private File imagenPromocional;
	/**
	 * codigo de la pelicula
	 */
	private int codigo;
	/**
	 * URL de la pelicula
	 */
	private String url;
	/**
	 * Genero de la pelicula
	 */
	private Genero genero;
	
	
	/**
	 * constructor por defecto
	 */
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor parametrizado
	 */

	
	public Pelicula(String titulo, File imagenPromocional, int codigo, String url, Genero genero) {
		super();
		this.titulo = titulo;
		this.imagenPromocional = imagenPromocional;
		this.codigo = codigo;
		this.url = url;
		this.genero = genero;
	}
	
	/**
	 * Constructores
	 * @param titulo
	 * @param codigo
	 * @param genero
	 */
	
	public Pelicula(String titulo, int codigo, Genero genero) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.genero = genero;
	}


	public Pelicula(String titulo, int codigo, Genero genero, File imagenpromocional, String url) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.genero = genero;
		this.imagenPromocional = imagenpromocional;
		this.url = url;
	}

	public Pelicula(String titulo, int codigo) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
	}

	public Pelicula(String titulo) {
		super();
		this.titulo = titulo;
	}
	
	
	public Pelicula(Genero genero) {
		super();
		this.genero = genero;
	}
	

	public Pelicula(int codigo) {
		super();
		this.codigo = codigo;
	}

	/**
	 * get y set de titulo y codigo
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getUrl() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public String MostrarPelicula() {
		return "[titulo=" + titulo + ", codigo=" + codigo + "]";
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setImagenPromocional(File imagenPromocional) {
		this.imagenPromocional = imagenPromocional;
	}

	public File getImagenPromocional() {
		return imagenPromocional;
	}

	/**
	 * Nos devuelve el detalle de la pelicula buscada con todos sus atributos
	 * @return
	 */
	public String peliculaDetallada() {
		return "[titulo=" + titulo + ", codigo=" + codigo + ", imagen=" + imagenPromocional + ", URL=" + url + ", genero=" + genero.getGenero() + "]";
	}
	
	
}
