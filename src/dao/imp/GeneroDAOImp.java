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
//		boolean isInsert = false;
//		Connection conexion = getConexion();
//		String sentenciaSQL = "INSERT INTO genero (nombre_genero) VALUES (?)";
//		PreparedStatement objetoSentenciaSQL;
//		try {
//			objetoSentenciaSQL=conexion.prepareStatement(sentenciaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
//			objetoSentenciaSQL.setString(1, entidad.getGenero());
//			int result = objetoSentenciaSQL.executeUpdate();
//			if(result==1) {
//				ResultSet rs = objetoSentenciaSQL.getGeneratedKeys();
//				if (rs.next()) {
//					return rs.getInt(1);
//				}
//				isInsert=true;
//			}
//			//objetoSentenciaSQL.close();
//			//conexion.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//			
//		return isInsert;
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

	@Override
	public Genero buscarPorTitulo(String titulo) {
		
		return null;
	}




//		Genero generoBuscado1 = null;
//	    Connection conexion = getConexion();
//	    String sentenciaSQL = "SELECT * FROM genero G, pelicula PE WHERE G.nombre_genero=PE.genero_gen_id";
//	    PreparedStatement objetoSentenciaSQL = null;
//
//	    try {
//	        objetoSentenciaSQL = conexion.prepareStatement(sentenciaSQL);
//	        objetoSentenciaSQL.setString(1, generoBuscado); // Asignamos el genero como parámetro
//
//	        ResultSet resultado = objetoSentenciaSQL.executeQuery();
//
//	        while (resultado.next()) {
//	        	int idGenero = resultado.getInt("gen_id");
//	        	generoBuscado1 = new Genero(idGenero);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        try {
//	            objetoSentenciaSQL.close();
//	            conexion.close();
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//
//	    }
//
//	    return generoBuscado1;

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
	
	//Obtenemos el ID
	private int obtenerId(String nombre) throws SQLException{
		String sentenciaSQL = "SELECT gen_id FROM genero WHERE nombre_genero=?";
		Connection conexion = getConexion();
	    PreparedStatement objetoSentenciaSQL = null;

	    try {
	        objetoSentenciaSQL = conexion.prepareStatement(sentenciaSQL);
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
	    } finally {
	        // Cerrar el objeto PreparedStatement en el bloque finally
	        if (objetoSentenciaSQL != null) {
	            try {
	                objetoSentenciaSQL.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	//Insertamos el genero
	private int insertarGen(String nombre) throws SQLException{
		String sentenciaSQL = "INSERT INTO genero (nombre_genero) VALUES (?)";
		Connection conexion = getConexion();
		
		try {
			PreparedStatement objetoSentenciaSQL = conexion.prepareStatement(sentenciaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
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

	@Override
	public boolean verificarCodigo(int key) {
		// TODO Auto-generated method stub
		return false;
	}


	
		
}	

