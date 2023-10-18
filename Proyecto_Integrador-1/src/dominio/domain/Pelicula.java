package dominio.domain;


public class Pelicula {
	
	/**
	 * titulo de la pelicula
	 */
	private String titulo;
	/**
	 * imagen de la pelicula
	 */
	private String imagenPromocional;
	/**
	 * codigo de la pelicula
	 */
	private int codigo;
	/**
	 * URL de la pelicula
	 */
	private String url;
	
	
	/**
	 * constructor por defecto
	 */
	public Pelicula() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * constructor parametrizado
	 */
	
	public Pelicula(String titulo, String imagenPromocional, int codigo, String url) {
		this.titulo = titulo;
		this.imagenPromocional = imagenPromocional;
		this.codigo = codigo;
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


	/**
	 * metodo toString
	 */

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", codigo=" + codigo + "]";
	}

	public String getImagenPromocional() {
		return imagenPromocional;
	}

	public void setImagenPromocional(String imagenPromocional) {
		this.imagenPromocional = imagenPromocional;
	}

	public String getUrl() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

	
	
}
