package dao;

import java.sql.SQLException;
import java.util.List;

import dominio.domain.Pelicula;


public interface DAO <E,K>{
	E buscarPorId(K key);
	List<E> obtenerTodos();
	boolean insertar(E entidad);
	void actualizar(E entidad);
	void eliminar(E entidad);
	E buscarPorTitulo(String tituloBuscado);
	E buscarPorGenero(String generoBuscado);
	E buscarPorCodigo(K key);
	E obtenerOInsertarGenero(String nombre)  throws SQLException;
	boolean verificarCodigo(int key);
}
