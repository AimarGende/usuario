package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioModelo gest= new UsuarioModelo();
		int id=Integer.parseInt(request.getParameter("id"));
		String Srol= request.getParameter("rol");
		String name=request.getParameter("nombre");
		String contrasena=request.getParameter("contrasena");
		
		SimpleDateFormat fecha_login= new SimpleDateFormat("yyyy-mm-dd") ; 
		
		Usuario usu= new Usuario();
		Rol rol=null;
		
		RolModelo gestR=new RolModelo();
		
		try {
			gestR.conectar();
			rol = gestR.getRol(Srol);
			gestR.cerrar();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			usu = new Usuario(id,name,contrasena,fecha_login.parse(request.getParameter("fecha")),rol);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(usu.comprobarContraseña());
		if(usu.comprobarContraseña()) {
			try {
				gest.conectar();
				gest.modificarUsuario(usu);
				gest.cerrar();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("EMV").forward(request, response);	
		}
		else {
			System.out.println("perro");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
