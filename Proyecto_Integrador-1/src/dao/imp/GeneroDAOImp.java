package dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConexionMySQLDB;
import dao.DAO;
import dominio.domain.Genero;

public class GeneroDAOImp implements  ConexionMySQLDB, DAO<Genero, Integer>{


	@Override
	public boolean insertar(Genero entidad) {
		// TODO Auto-generated method stub
		return false;
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
	public Genero buscarPorId(Integer key) {
		Genero generoBuscado =null;
		Connection conexion = getConexion();
		String sentenciaSQL = "SELECT * FROM genero  WHERE genero = ?";
		Statement objetoSentenciaSQL = null;

		try {
			objetoSentenciaSQL = conexion.createStatement();
			ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			
			while(resultado.next()) {
				String genero = resultado.getString("genero");
				String genero01 = resultado.getString("genero01");
				String genero02 = resultado.getString("genero02");
				String genero03 = resultado.getString("genero03");
				generoBuscado = new Genero();
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
				String genero01 = resultado.getString("genero01");
				String genero02 = resultado.getString("genero02");
				String genero03 = resultado.getString("genero03");
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
	public Genero buscarPorNombre(Genero entidad) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
