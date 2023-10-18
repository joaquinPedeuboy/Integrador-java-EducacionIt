package dao.imp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConexionMySQLDB;
import dao.DAO;
import dominio.domain.Pelicula;

public class PeliculaDAOImp implements ConexionMySQLDB, DAO<Pelicula, Integer>{

	/**
	 * Implementa la búsqueda por codigo
	 */
	@Override
	public Pelicula buscarPorId(Integer key) {
		Pelicula peliculaBuscada =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM pelicula WHERE codigo = " +key;
		Statement objetoSentenciaSQL = null;
		
		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			
			while(resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String titulo = resultado.getString("titulo");
				
				peliculaBuscada = new Pelicula(titulo,codigo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				objetoSentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return peliculaBuscada;
	}

	/**
	 * Devuelve todas las peliculas
	 */
	@Override
	public List<Pelicula> obtenerTodos() {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM pelicula";
		Statement objetoSentenciaSQL = null;
		
		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			
			while(resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String titulo = resultado.getString("titulo");
				
				Pelicula peliculaBuscada = new Pelicula(titulo,codigo);
				peliculas.add(peliculaBuscada);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				objetoSentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return peliculas;
	}


	/**
	 * Inserta peliculas
	 */
	@Override
	public boolean insertar(Pelicula entidad) {
		boolean isInsert = false;
		Connection conexion = getConexion();
		String sentenciaSQL = "INSERT INTO pelicula (titulo, codigo) VALUES (?, ?)";
		PreparedStatement objetoSentenciaSQL;
		try {
			objetoSentenciaSQL=conexion.prepareStatement(sentenciaSQL);
			objetoSentenciaSQL.setString(1, entidad.getTitulo());
			objetoSentenciaSQL.setInt(2, entidad.getCodigo());
			int result = objetoSentenciaSQL.executeUpdate();
			if(result==1) {
				isInsert=true;
			}
			//objetoSentenciaSQL.close();
			//conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return isInsert;
	}

	/**
	 * Actualiza peliculas
	 */
	@Override
	public void actualizar(Pelicula entidad) {
		Connection conexion = getConexion();
		String sentenciaSQL = "UPDATE pelicula SET titulo='"+entidad.getTitulo()+"', codigo="+entidad.getCodigo() +" WHERE codigo="+entidad.getCodigo();
		Statement objetoSentenciaSQL=null;
		try {
			
			objetoSentenciaSQL = conexion.createStatement();
			objetoSentenciaSQL.executeUpdate(sentenciaSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				objetoSentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		
	/**
	 * Elimina peliculas
	 */
	@Override
	public void eliminar(Pelicula entidad) {
		Connection conexion = getConexion();
		String sentenciaSQL = "DELETE FROM pelicula WHERE codigo="+entidad.getCodigo();
		Statement objetoSentenciaSQL=null;
		try {
			
			objetoSentenciaSQL = conexion.createStatement();
			objetoSentenciaSQL.executeUpdate(sentenciaSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				objetoSentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Implementa la búsqueda por título
	 */
	
	@Override
	public Pelicula buscarPorTitulo(String tituloBuscado) {
		Pelicula peliculaBuscada = null;
	    Connection conexion = getConexion();
	    String sentenciaSQL = "SELECT * FROM pelicula WHERE titulo=?";
	    PreparedStatement objetoSentenciaSQL = null;

	    try {
	        objetoSentenciaSQL = conexion.prepareStatement(sentenciaSQL);
	        objetoSentenciaSQL.setString(1, tituloBuscado); // Asignamos el título como parámetro

	        ResultSet resultado = objetoSentenciaSQL.executeQuery();

	        while (resultado.next()) {
	            int codigo = resultado.getInt("codigo");
	            String titulo = resultado.getString("titulo");

	            peliculaBuscada = new Pelicula(titulo, codigo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            objetoSentenciaSQL.close();
	            conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    return peliculaBuscada;
        
    }

	/**
	 * Pelicula peliculaBuscada =null;
	Connection conexion = getConexion();
	String sentenciaSQL = "SELECT * FROM pelicula WHERE titulo=?";
	Statement objetoSentenciaSQL = null;
	
	try {
		objetoSentenciaSQL = conexion.createStatement();
		ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String titulo = resultado.getString("titulo");
			
			peliculaBuscada = new Pelicula(titulo,codigo);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			objetoSentenciaSQL.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	return peliculaBuscada;
	**/
}
