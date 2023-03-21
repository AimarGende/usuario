package modelo;

public class Usuario {
	int id;
	String nombre;
	
	public Usuario(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
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

	@Override
	public String toString() {
		return  id + "     " + nombre ;
	}
	
	
	
}
