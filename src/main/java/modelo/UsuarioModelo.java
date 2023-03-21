package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioModelo extends Conector{
	PreparedStatement pt;
	
	public boolean crearUsuario(String nombre){
		try {
			pt= getCon().prepareStatement("INSERT INTO usuario (Nombre) VALUES (?)");
			pt.setString(1, nombre);
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
			pt=getCon().prepareStatement("UPDATE usuario SET Nombre=? WHERE id=?");
			pt.setString(1, usuario.getNombre());
			pt.setInt(2, usuario.getId());
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
			
			usuarios.add(usu);
		}
		return usuarios;
	}
}
