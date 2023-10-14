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

	@Override
	public Pelicula buscarPorNombre(Pelicula entidad) {
		Pelicula peliculaBuscada =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM pelicula WHERE titulo = " +entidad.getTitulo();
		Statement objetoSentenciaSQL = null;
		
		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			
			while(resultado.next()) {
				String titulo = resultado.getString("titulo");
				
				peliculaBuscada = new Pelicula(titulo);
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
	

	
}
