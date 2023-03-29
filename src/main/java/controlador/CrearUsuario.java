package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Rol;
import modelo.bean.Usuario;
import modelo.dao.RolModelo;
import modelo.dao.UsuarioModelo;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RolModelo gest = new RolModelo();
		ArrayList<Rol> roles=new ArrayList<Rol>();
		try {
			gest.conectar();
			roles=gest.getRoles();
			gest.cerrar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("roles", roles);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("FormularioCrear.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		RolModelo gestR = new RolModelo();
		
		String rol = request.getParameter("rol");
		String nombre= (String) request.getParameter("nombre");
		String contrasena= request.getParameter("contrasena");
		SimpleDateFormat fecha_login= new SimpleDateFormat("yyyy-mm-dd") ; 
		Usuario usu= new Usuario();
		usu.setContrasena(contrasena);
		usu.setNombre(nombre);
		try {
			usu.setFecha_login(fecha_login.parse(request.getParameter("fecha")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			gestR.conectar();
			usu.setRol(gestR.getRol(rol));
			gestR.cerrar();
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		UsuarioModelo gest= new UsuarioModelo();
		
		
		
		if(usu.comprobarContraseña()) {
			try {
				gest.conectar();
				gest.crearUsuario(usu);
				gest.cerrar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("formulariousuario.jsp").forward(request, response);
		}
		else {
			
		}
		
	
	}

}
