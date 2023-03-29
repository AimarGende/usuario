package modelo.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Usuario;

public class UsuarioModelo extends Conector{
	PreparedStatement pt;
	
	public boolean crearUsuario(Usuario usuario){
		try {
			pt= getCon().prepareStatement("INSERT INTO usuario (Nombre,Contrasena,login,id_rol) VALUES (?,?,?,?)");
			pt.setString(1, usuario.getNombre());
			pt.setString(2, usuario.getContrasena());
			pt.setDate(3, new Date (usuario.getFecha_login().getTime()));
			pt.setInt(4, usuario.getRol().getId());
			pt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean eliminarUsuario(int id) {
		try {
			pt=getCon().prepareStatement("DELETE FROM usuario WHERE id=?");
			pt.setInt(1, id);
			pt.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean modificarUsuario(Usuario usuario) {
		try {
			pt=getCon().prepareStatement("UPDATE usuario SET Nombre=?, Contrasena=?, login=?, id_rol=? WHERE id=?");
			pt.setString(1, usuario.getNombre());
			pt.setString(2, usuario.getContrasena());
			pt.setDate(3, new Date (usuario.getFecha_login().getTime()) );
			pt.setInt(4, usuario.getRol().getId());
			pt.setInt(5, usuario.getId());
			pt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Usuario getUsuario(int id) throws SQLException {
		Usuario usu=new Usuario();

		pt=getCon().prepareStatement("SELECT * FROM usuario WHERE id=?");
		
		pt.setInt(1, id);
		
		ResultSet result= pt.executeQuery();
		result.next();
		
		usu.setId(result.getInt("id"));
		usu.setNombre(result.getString("Nombre"));
		usu.setContrasena(result.getString("Contrasena"));
		usu.setFecha_login(result.getDate("login"));
		
		try {
			RolModelo gest= new RolModelo();
			gest.conectar();
			usu.setRol(gest.getRol(result.getInt("id_rol")));
			gest.cerrar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return usu;
	}
	
	public ArrayList<Usuario> getUsuarios() throws SQLException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		pt=getCon().prepareStatement("SELECT * FROM usuario");
		
		ResultSet result= pt.executeQuery();
		
		while(result.next()) {
			
			Usuario usu=new Usuario();
			
			usu.setId(result.getInt("id"));
			usu.setNombre(result.getString("Nombre"));
			usu.setContrasena(result.getString("Contrasena"));
			usu.setFecha_login(result.getDate("login"));
			try {
				RolModelo gest= new RolModelo();

				gest.conectar();
				usu.setRol(gest.getRol(result.getInt("id_rol")));
				gest.cerrar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			usuarios.add(usu);
		}
		return usuarios;
	}
	

}
