package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Conector;
import modelo.bean.Rol;

public class RolModelo extends Conector{
	PreparedStatement pt;
	
	public boolean insertarRol(Rol rol) {
		try {
			pt=getCon().prepareStatement("INSERT INTO roles VALUES (?,?)");
			pt.setInt(1, rol.getId());
			pt.setString(2, rol.getNombre());
			pt.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean eliminarRol(int id) {
		try {
			pt=getCon().prepareStatement("DELETE FROM roles WHERE id=?");
			pt.setInt(1, id);
			pt.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean modificarRol(Rol rol) {
		try {
			pt=getCon().prepareStatement("UPDATE roles SET nombre=?, id=? where id=?");
			pt.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public Rol getRol(int id) {
		Rol rol=new Rol();
		
		try {
			pt=getCon().prepareStatement("SELECT * FROM roles WHERE id=?");
			pt.setInt(1, id);
			
			ResultSet result= pt.executeQuery();
			result.next();
			
			rol.setId(result.getInt("id"));
			rol.setNombre(result.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rol;
	}
	public Rol getRol(String nombre) {
		Rol rol=new Rol();
		
		try {
			pt=getCon().prepareStatement("SELECT * FROM roles WHERE nombre=?");
			pt.setString(1, nombre);
			
			ResultSet result= pt.executeQuery();
			result.next();
			
			rol.setId(result.getInt("id"));
			rol.setNombre(result.getString("nombre"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rol;
	}
	
	public ArrayList<Rol> getRoles(){
		ArrayList<Rol> roles = new ArrayList<Rol>();
		
		try {
			pt=getCon().prepareStatement("SELECT * FROM roles");
			
			ResultSet result= pt.executeQuery();
			
			while(result.next()) {
				Rol rol=new Rol();
				
				rol.setId(result.getInt("id"));
				rol.setNombre(result.getString("nombre"));
				
				roles.add(rol);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}
}
