package dominio.domain;

import java.util.List;

public class Genero{
	
	/**
	 * nombre del genero
	 */
	private String genero;
	
	private int id;
	

	/**
	 * Constructores
	 */
	public Genero() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Genero(String genero, int id) {
		super();
		this.genero = genero;
		this.id = id;
	}


	public Genero(String genero) {
		super();
		this.genero = genero;
	}


	public Genero(int id) {
		super();
		this.id = id;
	}


	/**
	 * Sets y getters
	 * @return
	 */
	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	

	
}
