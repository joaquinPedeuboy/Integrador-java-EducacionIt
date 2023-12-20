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
import dominio.domain.Genero;
import dominio.domain.Pelicula;

public class GeneroDAOImp implements  ConexionMySQLDB, DAO<Genero, Integer>{


	@Override
	public boolean insertar(Genero entidad) {
		return true;
	}

	@Override
	public void actualizar(Genero entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Genero entidad) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Genero buscarPorTitulo(String titulo) {
		
		return null;
	}
	

	@Override
	public Genero buscarPorCodigo(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genero buscarPorGenero(String generoBuscado) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean verificarCodigo(int key) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Se realiza la busqueda por ID
	 */
	@Override
	public Genero buscarPorId(Integer key) {
		Genero generoBuscado =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM genero WHERE gen_id= "+key;
		Statement objetoSentenciaSQL = null;

		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			
			while(resultado.next()) {
				String nombre = resultado.getString("nombre_genero");
				generoBuscado = new Genero(nombre);
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
		
		return generoBuscado;
	}
	

	/**
	 * Se realiza la busqueda de todos los generos
	 */
	@Override
	public List<Genero> obtenerTodos() {
		List<Genero> generos = new ArrayList<Genero>();
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM genero";
		Statement objetoSentenciaSQL = null;
		
		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			
			while(resultado.next()) {
				String genero = resultado.getString("genero");
				Genero generoBuscado = new Genero();
				generos.add(generoBuscado);
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
		
		return generos;
	}
	
	/**
	 * Obtenemos o insertamos el genero si no existe
	 */
	@Override
	public Genero obtenerOInsertarGenero(String nombre) throws SQLException {
		int idGenero = obtenerId(nombre);
			
		if(idGenero == -1) {
			idGenero = insertarGen(nombre);
		}
		
		return new Genero(nombre, idGenero);
	}
	
	/**
	 * Obtenemos el ID
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	private int obtenerId(String nombre) throws SQLException{

	    try (Connection conexion = getConexion();
	    		PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("SELECT gen_id FROM genero WHERE nombre_genero=?");){
	    	
	        objetoSentenciaSQL.setString(1, nombre);
	        
	        ResultSet result = objetoSentenciaSQL.executeQuery();

	        if (result.next()) {
	            return result.getInt("gen_id");
	        } else {
	            return -1;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return -1; // Devolver un valor indicativo de error
	    }
	}
	
	/**
	 * Insertamos el genero
	 * @param nombre
	 * @return
	 * @throws SQLException
	 */
	private int insertarGen(String nombre) throws SQLException{
		
		try (Connection conexion = getConexion();
				PreparedStatement objetoSentenciaSQL = conexion.prepareStatement("INSERT INTO genero (nombre_genero) VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);){
			
	        objetoSentenciaSQL.setString(1, nombre);
	        
	        int ins = objetoSentenciaSQL.executeUpdate();

	        if (ins==1) {
	        	 try(ResultSet result = objetoSentenciaSQL.getGeneratedKeys()){
	        		 if (result.next()) {
		        		 return result.getInt(1);
		        	 } 
	        	 }
	        }
	        return -1;
		}catch (SQLException e) {
	        e.printStackTrace();
	        return -1;
	    }
	}		
}	

