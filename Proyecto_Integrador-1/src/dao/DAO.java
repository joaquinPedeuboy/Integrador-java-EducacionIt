package dao;

import java.util.List;


public interface DAO <E,K>{
	E buscarPorId(K key);
	List<E> obtenerTodos();
	boolean insertar(E entidad);
	void actualizar(E entidad);
	void eliminar(E entidad);
	E buscarPorTitulo(String tituloBuscado);
}
