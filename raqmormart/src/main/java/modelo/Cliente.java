package modelo;

import java.sql.SQLException;
import dao.DaoClientes;

	/**
	 * Clase que representa a CLIENTE.
	 */

public class Cliente {

	private int idCliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String pais;
	private String telefono;
	
	public Cliente() {
		super();
	}

	 /**
     * Creamos los constructores de la clase Cliente.
     */
	
// Constructores
	
	
	public Cliente(int idCliente, String nombre, String apellido, String direccion, String pais,
		String telefono) {
	super();
	this.idCliente = idCliente;
	this.nombre = nombre;
	this.apellido = apellido;
	this.direccion = direccion;
	this.pais = pais;
	this.telefono = telefono;
}

	public Cliente(String nombre, String apellido, String direccion, String pais, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.pais = pais;
		this.telefono = telefono;
	}

	/**
     * Creamos los getters and setters
     */
	
	// Getters & Setters
	
	
	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
     * Usamos método insertar para la inserción del cliente en la base de datos.
     * 
     * @throws SQLException Si ocurre un error al insertar el cliente en la base de datos.
     */
	
	public  void insertar() throws SQLException {
	DaoClientes.getInstance().insertar(this);
	 
	}
	
	/**
	 * Este método devuelve una representación en forma de cadena de texto del objeto Cliente y nos
	 * devuelve sus atributos.
	 */
	
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", pais=" + pais + ", telefono=" + telefono + "]";

	}
}
	

