 package dao.imp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.sql.Blob;

import java.io.InputStream;
import java.net.URL;

import dao.ConexionMySQLDB;
import dao.DAO;
import dominio.domain.Genero;
import dominio.domain.Pelicula;
import model.util.GestorArchivos;

public class PeliculaDAOImp implements ConexionMySQLDB, DAO<Pelicula, Integer>{

	/**
	 * Implementa la búsqueda por codigo
	 */
	@Override
	public Pelicula buscarPorId(Integer key) {
		Pelicula peliculaBuscada =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM pelicula WHERE genero_gen_id=?";
		
		try {
			PreparedStatement objectSentenceSQL=conexion.prepareStatement(sentenciaSQL);
			objectSentenceSQL.setInt(1, key);
			ResultSet result = objectSentenceSQL.executeQuery();
			while(result.next()) {
				int codigo = result.getInt("genero_gen_id");
				String titulo = result.getString("titulo");
				peliculaBuscada = new Pelicula();
				peliculaBuscada.setCodigo(codigo);
				peliculaBuscada.setTitulo(titulo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	    try (Connection conexion = getConexion();
	         PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("INSERT INTO pelicula (titulo, codigo, imagen_promocional, URL, genero_gen_id) VALUES (?, ?, ?, ?, ?)");
	    		InputStream inputStream = new FileInputStream(entidad.getImagenPromocional()); ){

	        objetoSentenciaSQL.setString(1, entidad.getTitulo());
	        objetoSentenciaSQL.setInt(2, entidad.getCodigo());
	        objetoSentenciaSQL.setBlob(3, inputStream);
	        objetoSentenciaSQL.setString(4, entidad.getUrl());
	        objetoSentenciaSQL.setInt(5, entidad.getGenero().getId());
	        
	        int result = objetoSentenciaSQL.executeUpdate();

	        if (result == 1) {
	            isInsert = true;
	        }
	        objetoSentenciaSQL.close();
			conexion.close();

	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	    return isInsert;
	}

	/**
	 * Actualiza peliculas
	 */
	@Override
	public void actualizar(Pelicula entidad) {	
	    try (Connection conexion = getConexion();
	         PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("UPDATE pelicula SET titulo=?, imagen_promocional=?, URL=?, genero_gen_id=? WHERE codigo=?");
	         InputStream inputStream = new FileInputStream(entidad.getImagenPromocional())) {

	        objetoSentenciaSQL.setString(1, entidad.getTitulo());
	        objetoSentenciaSQL.setBlob(2, inputStream);
	        objetoSentenciaSQL.setString(3, entidad.getUrl());
	        objetoSentenciaSQL.setInt(4, entidad.getGenero().getId());
	        objetoSentenciaSQL.setInt(5, entidad.getCodigo());

	        int result = objetoSentenciaSQL.executeUpdate();

	        objetoSentenciaSQL.close();
	        conexion.close();
	    } catch (SQLException | IOException e) {
	        e.printStackTrace();
	    }
	}
//	public void actualizar(Pelicula entidad) {	
//		try (Connection conexion = getConexion();
//	        PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("UPDATE pelicula SET titulo=?, imagen_promocional=?, URL=?, genero_gen_id=? WHERE codigo=?");
//			InputStream inputStream = new FileInputStream(entidad.getImagenPromocional()); ){
//				
//				objetoSentenciaSQL.setString(1, entidad.getTitulo());
//		        objetoSentenciaSQL.setInt(2, entidad.getCodigo());
//		        objetoSentenciaSQL.setBlob(3, inputStream);
//		        objetoSentenciaSQL.setString(4, entidad.getUrl());
//		        objetoSentenciaSQL.setInt(5, entidad.getGenero().getId());
//		        int result = objetoSentenciaSQL.executeUpdate();
//		        
//				objetoSentenciaSQL.close();
//				conexion.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	}
		
	/**
	 * Elimina peliculas
	 */
	@Override
	public void eliminar(Pelicula entidad) {
		
		try(Connection conexion = getConexion();
				PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("DELETE FROM pelicula WHERE codigo=?");
				) {
			objetoSentenciaSQL.setInt(1, entidad.getCodigo());
			int filasAfectadas = objetoSentenciaSQL.executeUpdate();
			
			if(filasAfectadas > 0) {
				System.out.println("Pelicula eliminada");
				System.out.println();
			} else {
				System.out.println("No se encontro la pelicula para ser eliminada");
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Error al eliminar: " + e.getMessage());
			e.printStackTrace();
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
	    String nombreUnico = UUID.randomUUID().toString();
		String rutaImagenPromocional = System.getProperty("user.dir") + File.separator + "recursos" + File.separator + "imagenes" + File.separator + nombreUnico;
		
	    try {
	        objetoSentenciaSQL = conexion.prepareStatement(sentenciaSQL);
	        objetoSentenciaSQL.setString(1, tituloBuscado); // Asignamos el título como parámetro

	        ResultSet resultado = objetoSentenciaSQL.executeQuery();

	        while (resultado.next()) {
	            int codigo = resultado.getInt("codigo");
	            String titulo = resultado.getString("titulo");
	            String url = resultado.getString("URL");
	            int genero = resultado.getInt("genero_gen_id");
	            Blob blob = resultado.getBlob("imagen_promocional");
	            InputStream inputStream = blob.getBinaryStream();
	            File archivoImagen = new File(rutaImagenPromocional);
				GestorArchivos.copyInputStreamToFile(inputStream, archivoImagen);
				//C:\Users\Joaqu\eclipse-workspace\Proyecto_Integrador-1\recursos\imagenes
			
	            Genero gen = new GeneroDAOImp().buscarPorId(genero);

	            peliculaBuscada = new Pelicula(titulo, archivoImagen, codigo, url, gen);
	        
	        }
	    }catch (SQLException e ) {
	            e.printStackTrace();
	    	}
	    return peliculaBuscada;
	}
	
	/**
	 * Implementa la búsqueda por genero
	 */
	
	@Override
	public Pelicula buscarPorGenero(String generoBuscado) {
		Pelicula peliculaBuscada = null;
	    String nombreUnico = UUID.randomUUID().toString();
		String rutaImagenPromocional = System.getProperty("user.dir") + File.separator + "recursos" + File.separator + "imagenes" + File.separator + nombreUnico;

	    try(Connection conexion = getConexion();
	         PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("SELECT * FROM pelicula WHERE genero_gen_id = (SELECT gen_id FROM genero WHERE nombre_genero=?)");) {
	    	
	        objetoSentenciaSQL.setString(1, generoBuscado); // Asignamos el genero como parámetro

	        ResultSet resultado = objetoSentenciaSQL.executeQuery();

	        while (resultado.next()) {
	        	
	        	
	            int codigo = resultado.getInt("codigo");
	            String titulo = resultado.getString("titulo");
	            String url = resultado.getString("URL");
	            int genero = resultado.getInt("genero_gen_id");
	            Blob blob = resultado.getBlob("imagen_promocional");
	            InputStream inputStream = blob.getBinaryStream();
	            File archivoImagen = new File(rutaImagenPromocional);
				GestorArchivos.copyInputStreamToFile(inputStream, archivoImagen);
				
				Genero gen = new GeneroDAOImp().buscarPorId(genero);

	            peliculaBuscada = new Pelicula(titulo, archivoImagen, codigo, url, gen);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return peliculaBuscada;
        
    }
	/**
	 * Implementa la busqueda por codigo
	 */

	@Override
	public Pelicula buscarPorCodigo(Integer key) {
		Pelicula peliculaBuscada =null;

		String nombreUnico = UUID.randomUUID().toString();
		String rutaImagenPromocional = System.getProperty("user.dir") + File.separator + "recursos" + File.separator + "imagenes" + File.separator + nombreUnico;
		
		try (Connection conexion = getConexion();
				PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("SELECT * FROM pelicula WHERE codigo = " +key);){
			
			ResultSet resultado = objetoSentenciaSQL.executeQuery();
			
			while(resultado.next()) {
				int codigo = resultado.getInt("codigo");
				String titulo = resultado.getString("titulo");
				String url = resultado.getString("URL");
	            int genero = resultado.getInt("genero_gen_id");
	            Blob blob = resultado.getBlob("imagen_promocional");
	            InputStream inputStream = blob.getBinaryStream();
	            File archivoImagen = new File(rutaImagenPromocional);
				GestorArchivos.copyInputStreamToFile(inputStream, archivoImagen);
				
				Genero gen = new GeneroDAOImp().buscarPorId(genero);

				peliculaBuscada = new Pelicula(titulo, archivoImagen, codigo, url, gen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return peliculaBuscada;
	}

	@Override
	public Pelicula obtenerOInsertarGenero(String nombre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Verifica la existencia del codigo
	 */
	@Override
	public boolean verificarCodigo(int key) {
		boolean existeCodigo = false;
		try(Connection conexion = getConexion();
			PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("SELECT * FROM pelicula WHERE codigo =? ");
			){
			objetoSentenciaSQL.setInt(1, key);
			ResultSet resultado = objetoSentenciaSQL.executeQuery();
			
			if (resultado.next()) {
	            existeCodigo = true;
	        }
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return existeCodigo;
	}
}
