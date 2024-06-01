package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import dao.DaoClientes;

import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import modelo.Cliente;

/**
 * Servlet implementation class GestionClientes
 */

@MultipartConfig
public class GestionClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String pathFiles = "/Users/raquelmoramartin/eclipse-workspace/raqmormart/src/main/webapp/fotos";
	private File uploads = new File(pathFiles);

	private ServletRequest request;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*
		public static String getMD5(String input) {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] messageDigest = md.digest(input.getBytes());
				BigInteger number = new BigInteger(1, messageDigest);
				String hashtext = number.toString(16);

				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}
				return hashtext;
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
	    	*/
		
		//Datos para crear cuenta cliente

		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
	    String direccion = request.getParameter("direccion");
	    String pais = request.getParameter("pais");
	    String telefono = request.getParameter("telefono");
	    
	    
	    Cliente c = new Cliente(nombre, apellido, direccion, pais, telefono);
	    System.out.println(c.toString());
	    
	    
	    try {
			c.insertar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	   
	    
	    
	}
}