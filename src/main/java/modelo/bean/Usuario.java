package modelo.bean;

import java.util.Date;

public class Usuario {
	int id;
	String nombre;
	String contrasena;
	Date fecha_login;
	Rol rol;
	
	public Usuario(int id, String nombre, String contrasena, Date fecha_login,Rol rol) {
		this.id = id;
		this.nombre = nombre;
		this.contrasena= contrasena;
		this.fecha_login=fecha_login;
		this.rol=rol;
	}
	
	public Usuario(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	

	public Date getFecha_login() {
		return fecha_login;
	}

	public void setFecha_login(Date fecha_login) {
		this.fecha_login = fecha_login;
	}
	
	
	
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public boolean comprobarContraseña() {
		boolean apto=false;
		if(this.contrasena.length()<8) {
			apto=false;
		}
		
		for (char c: this.contrasena.toCharArray()) {
			if (Character.isDigit(c)) {
				apto=true;
			}
		}
		return apto;
	}
	
	@Override
	public String toString() {
		return  id + "     " + nombre+"     "+contrasena+"     "+fecha_login+"     "+rol;
	}
	
	
	
}
