package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Usuario;
import modelo.dao.RolModelo;
import modelo.dao.UsuarioModelo;

/**
 * Servlet implementation class ModificarUsuarioForm
 */
@WebServlet("/ModificarUsuarioForm")
public class ModificarUsuarioForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuarioForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsuarioModelo gest= new UsuarioModelo();
		Usuario usu=new Usuario();
		int id= Integer.parseInt(request.getParameter("id"));
		
		try {
			gest.conectar();
			usu=gest.getUsuario(id);
			gest.cerrar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RolModelo gestR = new RolModelo();
		try {
			gestR.conectar();
			request.setAttribute("roles", gestR.getRoles());
			gestR.cerrar();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("usuario", usu);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("FormularioModificar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
