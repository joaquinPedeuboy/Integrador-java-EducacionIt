package dominio.domain;

import java.util.ArrayList;
import java.util.List;

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
	private String URL;
	
	/**
	 * Lista de los generos de la pelicula
	 */
	private List<Genero> generos;
	
	/**
	 * constructor por defecto
	 */
	
	public Pelicula() {
		generos = new ArrayList<>();
	}
	
	/**
	 * constructor parametrizado
	 */
	
	public Pelicula(String titulo, String imagenPromocional, int codigo, String uRL) {
		this.titulo = titulo;
		this.imagenPromocional = imagenPromocional;
		this.codigo = codigo;
		URL = uRL;
		this.generos = new ArrayList<>();
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
	 * permite agregar generos a la pelicula
	 * @param string
	 */
	public void agregarGeneros (Genero genero) {
		this.generos.add(genero);
	}

	/**
	 * metodo toString
	 */

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", codigo=" + codigo + "]";
	}

	
	
}
