package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;

/**
 * Clase DAO para gestionar las operaciones relacionadas con la tabla de clientes en la base de datos.
 */

public class DaoClientes {
	private static Connection con = null;
	private static DaoClientes instance = null;

	/**
     * Constructor de DaoClientes que establece la conexión a la base de datos.
     * 
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
	
	public DaoClientes() throws SQLException {
		this.con = DBConection.getConnection();
	}

	/**
     * Obtiene la instancia única de DaoClientes (Singleton).
     * 
     * @return La instancia de DaoClientes.
     * @throws SQLException Si ocurre un error al crear la instancia.
     */
	
	public static DaoClientes getInstance() throws SQLException {
		if (instance == null) {
			instance = new DaoClientes();
		}
		return instance;
	}

	
	/**
     * Lista todos los clientes que no son administradores.
     * 
     * @return Una lista de objetos Cliente que representa a todos los clientes que no son administradores.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */

	
	public ArrayList<Cliente> listar() throws SQLException {

		PreparedStatement ps = con.prepareStatement(
				"SELECT * FROM clientes c inner join usuarios u on u.id = c.idUsuario where u.esadmin = 0");
		ResultSet rs = ps.executeQuery();

		ArrayList<Cliente> result = null;

		while (rs.next()) {

			if (result == null) {

				result = new ArrayList<Cliente>();
			}
			result.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
		}
		return result;
	}
	
	 /**
     * Insertar para insertar un nuevo cliente en la base de datos.
     * 
     * @param c El objeto Cliente a insertar.
     * @throws SQLException Si ocurre un error al insertar el cliente en la base de datos.
     */
	
	
	public void insertar (Cliente c) throws SQLException {

        PreparedStatement ps = null;
        try {
        ps = con.prepareStatement("INSERT INTO Cliente (nombre, apellido, direccion, pais, telefono) VALUES (?,?,?,?,?)");
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getApellido());
        ps.setString(3, c.getDireccion());
        ps.setString(4, c.getPais());
        ps.setString(5, c.getTelefono());

        int filas = ps.executeUpdate();
        }finally {
        if (ps !=null) ps.close();
        }
    }
	
	 /**
     * Registrar un nuevo cliente en la base de datos.
     * 
     * @param nombre El nombre del cliente.
     * @param apellido El apellido del cliente.
     * @param direccion La dirección del cliente.
     * @param pais El país del cliente.
     * @param telefono El teléfono del cliente.
     * @return true si el cliente se registró correctamente, false en caso de que no sea así.
     */
	
	
	public boolean RegistrarCliente(String nombre, String apellido, String direccion, String pais, String telefono) {
		boolean client = false;

		try {
 
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO clientes (idUsuario,nombreUsuario, apellido, direccion, pais, telefono) VALUES (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, direccion);
			ps.setString(4, pais);
			ps.setString(5, telefono);
		
			int filas = ps.executeUpdate();
/*
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					client.setIdCliente(generatedKeys.getInt(1));
				} else {
					throw new SQLException("Error al crear el cliente.");
				}
			}
			*/
			
			ps.close();

			return client;

		} catch (SQLException e) {

			return client;
		}
	}

	
	/**
     * Actualizar la información de un cliente que ya existe en la base de datos.
     * 
     * @param client El objeto Cliente con la información actualizada.
     * @return El objeto Cliente actualizado, o null si no se pudo actualizar.
     */
	
	public Cliente editarCliente(Cliente client) {

		try {

			String query = "UPDATE clientes set nombre = ?, apellido = ?, direccion = ?"
					+ ", pais = ?, telefono = ? WHERE idCliente = ?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, client.getIdCliente());
			ps.setString(2, client.getNombre());
			ps.setString(3, client.getApellido());
			ps.setString(4, client.getDireccion());
			ps.setString(5, client.getPais());
			ps.setString(6, client.getTelefono());

			int filas = ps.executeUpdate();

			if (filas <= 0) {
				client = null;
			}

			ps.close();

			return client;

		} catch (SQLException e) {

			return client;
		}
	}

	
	/**
     * Eliminar un cliente de la base de datos.
     * 
     * @param c El objeto Cliente a eliminar.
     * @throws SQLException Si ocurre un error al eliminar el cliente de la base de datos.
     */
	
	public static void eliminarCliente(Cliente c) throws SQLException {
		String sql = "DELETE FROM clientes WHERE idCliente = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, c.getIdCliente());
		int filas = ps.executeUpdate();

		ps.close();
	}

	
	/**
    * Leer la información de un cliente de la base de datos por su ID.
    * 
    * @param idCliente El ID del cliente
    * @return El objeto Cliente con la información del cliente; Null si no se encontró el cliente.
    * @throws SQLException Si ocurre un error al acceder a la base de datos.
    */
    
	public static Cliente leerCliente(int idCliente) throws SQLException {

		PreparedStatement ps = con.prepareStatement("SELECT * FROM cliente where idCliente = ?");
		ps.setInt(1, idCliente);
		ResultSet rs = ps.executeQuery();

		Cliente result = null;

		while (rs.next()) {

			if (result == null) {

				result = new Cliente();
			}
			result = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), null);
		}
		return result;

	}
}