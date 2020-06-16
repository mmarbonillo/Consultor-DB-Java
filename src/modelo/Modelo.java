package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 * Clase principal de la aplicación de gestión de base de datos
 * @author: María del Mar Fernández Bonillo
 */
public class Modelo {
	
	private Connection conexion;
	/**
	 * Array con todas las posibles operaciones para generar consultas
	 */
	private String[] condicionales = {" = ", " < ", " > ", " <= ", " >= ", " <> ", " LIKE ", " NOT LIKE ", " BETWEEN "};
	
	
	/**
	 * Método que recibe un nombre de usuario y una contraseña para conectarse a la base de datos
	 * @param usuario Nombre del usuario con el que se va a crear la conexión a la base de datos
	 * @param contraseña Contraseña del usuario
	 * @return boolean Devuelve TRUE Si se realiza la conexión a la base de datos
	 */
	public boolean login(String usuario, String contraseña) {
		boolean conectado = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas", usuario, contraseña); //Establecer conexión con la BD
			JOptionPane.showMessageDialog(null, "Se ha establecido la conexión con el usuario " + usuario);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			conectado = false;
			JOptionPane.showMessageDialog(null, "Conexión fallida");
			e.printStackTrace();
		}
		return conectado;
	}
	
	/**
	 * Método que te devuelve las tablas de la base de datos
	 * @return String con las tablas de la base de datos
	 * @deprecated
	 */
	public String[] getTablas() {
		ArrayList<String> t = new ArrayList<String>();
		try {
			Statement st = conexion.createStatement();
			ResultSet rs;
			rs = st.executeQuery("show tables;");
			while(rs.next()) {
				t.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] tablas = new String[t.size()];
		for(int i = 0; i < t.size(); i++)
			tablas[i] = t.get(i);
		
		return tablas;
	}
	
	/**
	 * Método que genera la sentencia SELECT para hacer la consulta
	 * @param campos ArrayList con todos los campos a incluir en la sentencia
	 * @return String con la sentencia SELECT
	 */
	public String crearSelect(ArrayList<String> campos) {
		String select = "";
		for(int i = 0; i < campos.size(); i++) {
			if(i == campos.size() -1)
				select += campos.get(i);
			else
				select += campos.get(i) + ", ";
		}
		return "SELECT " + select;
	}
	
	/**
	 * Método que crea un String con la sentencia FROM de la consulta generada
	 * @param tablas ArrayList con las tablas necesarias en la consulta
	 * @return String con la sentencia FROM
	 */
	public String crearFrom(ArrayList<String> tablas) {
		String from = "";
		for(int i = 0; i < tablas.size(); i++) {
			if(i+1 == tablas.size())
				from += tablas.get(i);
			else
				from += tablas.get(i) + ", ";
		}
		
		return "FROM " + from;
	}
	
	/**
	 * Método que crea la primera parte de la sentencia WHERE. Este método une las tablas usando las claves primarias y secundarias
	 * de las tablas siempre y cuando la clave primaria de llame 'id' y la secundaria 'id_nombretabla'
	 * @param tablas ArrayList con las tablas necesarias en la consulta
	 * @return String con la parte de la sentencia WHERE que une las tablas
	 */
	private String crearWhere(ArrayList<String> tablas) {
		String p = "WHERE ";
		String where = "";
		for(int i = 0; i < tablas.size(); i+=2) {
			if(i+2 == tablas.size()) {
				where += tablas.get(i) + ".id = " + tablas.get(i+1) + ".id_" + tablas.get(i);
			}else if(i+1 == tablas.size()) {
				if(tablas.size() == 1) {
					where = "";
					p = "";
				}else
					where += tablas.get(i) + ".id = " + tablas.get(i-1) + ".id_" + tablas.get(i);
			}else {
				where += tablas.get(i) + ".id = " + tablas.get(i+1) + ".id_" + tablas.get(i) + " AND ";
			}
		}
		return p + where;
	}
	
	/**
	 * Método que crea la parte del WHERE con las condiciones de búsqueda sobre campos que no son clave
	 * @param tablas ArrayList con las tablas necesarias en la consulta
	 * @param campos ArrayList con los campos sobre los que vamos a realizar las restricciones en nuestra consulta
	 * @param condiciones ArrayList con las condiciones de búsqueda para cada campo
	 * @param n Indica la posición en el array 'condicionales'
	 * @return String con toda la sentencia WHERE completa
	 * @see #condicionales
	 */
	public String crearCondicionesWhere(ArrayList<String> tablas, ArrayList<String> campos, ArrayList<String> condiciones, ArrayList<Integer> n) {
		String whereClaves = crearWhere(tablas);
		String p = "WHERE ";
		String where = "";
		if(!(whereClaves.equals(""))) { //Cuando ya hay alguna condición por el uso de más de una tabla
			p = "";
			where += " AND ";
		}
		if(condiciones.size() == 0) {
			where = "";
			p = "";
		}
		for(int i = 0; i < campos.size(); i++) {
			int num = n.get(i);
			if(i+1 == campos.size())
				where += campos.get(i) + condicionales[num] + condiciones.get(i);
			else
				where += campos.get(i) + condicionales[num] + condiciones.get(i) + " AND ";
		}
		
		return whereClaves + p + where;
	}
	
	/**
	 * Método que escribe el nombre del campo de la tabla dependiendo del número que reciba ya que tenemos 3 campos de fecha<br>
	 * 1. fecha_pedido<br>
	 * 2. fecha_esperada (de entrega)<br>
	 * 3. fecha_entrega
	 * @param fecha String con la palabra necesaria para formar el nombre del campo
	 * @param n Número que indica que campo es el correcto
	 * @return String con el campo correcto
	 */
	public String campoFecha(String fecha, int n) {
		String estado = "";
		switch(n) {
		case 1:
			estado = "pedido.fecha_" + fecha.toLowerCase();
			break;
		case 2:
			estado = "pedido.fecha_"+ fecha.toLowerCase();
			break;
		case 3:
			estado = "pedido.fecha_" + fecha.toLowerCase();
		}
		
		return estado;
	}
	
	/**
	 * Este método recibe un número dependiendo de como quieras buscar por fecha para asígnarle otro que será el índice en el array 'condicionales'<br>
	 * 1. Fecha exacta<br>
	 * 2. Antes de...<br>
	 * 3. Después de...
	 * @param n Número que indica la opción escogida y sirve de guía para asignarle un condicional
	 * @return Índice del array 'condicionales'
	 * @see Modelo#condicionales
	 */
	public int tipoFecha(int n) {
		int tipo = 0;
		switch(n) {
		case 1:
			tipo = 0;
			break;
		case 2:
			tipo = 1;
			break;
		case 3:
			tipo = 2;
		}
		return tipo;
	}
	
	/**
	 * Este método recibe un número dependiendo de como quieras buscar por precio campo para asígnarle otro que será el índice en el array 'condicionales'<br>
	 * 1. Más de...<br>
	 * 2. Menos de...<br>
	 * 3. Exacta...
	 * @param n Número que indica la opción escogida y sirve de guía para asignarle un condicional
	 * @return Índice del array 'condicionales'
	 */
	public int tipoPrecio(int n) {
		int tipo = 0;
		switch(n) {
		case 1:
			tipo = 4;
			break;
		case 2:
			tipo = 3;
			break;
		case 3:
			tipo = 0;
		}
		
		return tipo;
	}
	
	/**
	 * Método que genera un String con la sentencia INSERT necesaria
	 * @param datos ArrayList con los datos a introducir en la tabla. Es requisito indispensable que estén todos los campos que haya en la tabla
	 * y que estos estén en orden.
	 * @param tabla Tabla sobre la que se va a realizar el INSERT
	 * @return String con la sentencia INSERT completa
	 */
	private String hacerInsert(ArrayList<String> datos, String tabla) {
		String insert = "INSERT INTO " + tabla + " VALUES (NULL, ";
		for(int i = 0; i < datos.size(); i++) {
			if(i+1 == datos.size()) {
				if(datos.get(i).equals("NULL"))
					insert += datos.get(i) + "); ";
				else
					insert += "'" + datos.get(i) + "'" + "); ";										
			}else {
				if(datos.get(i).equals("NULL"))
					insert += datos.get(i) + ", ";
				else
					insert += "'" + datos.get(i) + "'" +  ", ";
			}
		}
		return insert;
	}
	
	/**
	 * Método que ejecuta la sentencia INSERT devuelta por el método 'hacerInsert'.
	 * @param datos ArrayList con los datos a introducir en la tabla. Es requisito indispensable que estén todos los campos que haya en la tabla
	 * y que estos estén en orden.
	 * @param tabla Tabla sobre la que se va a realizar el INSERT.
	 * @return boolean TRUE si la sentencia se ha ejecutado con éxito. FALSE si la sentencia no se ha llegado a ejecutar.
	 * @see Modelo#hacerInsert(ArrayList, String)
	 */
	public boolean ejecutarInsert(ArrayList<String> datos, String tabla) {
		boolean hecho = false;
		String insert = hacerInsert(datos, tabla);
		try {
			Statement s = conexion.createStatement();
			System.out.println(insert);
			s.execute(insert);
			hecho = true;
		} catch (SQLException e) {}
		return hecho;
	}
	
	/**
	 * Método que genera el String con la sentencia UPDATE necesaria y la ejecuta haciendo uso del método 'ejecutarUpdate'
	 * @param campos ArrayList de String en el que llegan los campos necesarios para la sentencia UPDATE. En la primera posición siempre irá el campo necesario
	 * para el WHERE, el resto serán los campos a actualizar.
	 * @param contenido ArrayList de String con el contenido de cada campo. En la primera posición siempre irá el contenido del campo necesario
	 * para el WHERE, el resto serán los campos a actualizar.
	 * @param tabla String con la tabla sobre la que se ejecutará la sentencia UPDATE.
	 */
	public void crearUpdate(ArrayList<String> campos, ArrayList<String> contenido, String tabla) {
		String update = "";
		boolean todobien = true;
		for(int i = 1; i < campos.size(); i++) {
			update = "UPDATE " + tabla + " SET ";
			update += campos.get(i) + " = '" + contenido.get(i) + "'";
			update += " WHERE " + campos.get(0) + " = " + contenido.get(0) + ";";
			if(!ejecutarUpdate(update)) todobien = false;
		}
		if(todobien) JOptionPane.showMessageDialog(null, "Actualizado correctamente");
	}
	
	/**
	 * Método que ejecuta la sentencia UPDATE generada por el método 'crearUpdate'.
	 * @param update String con la sentencia UPDATE completa.
	 * @return boolean TRUE si la sentencia se ha ejecutado con éxito. FALSE si la sentencia no se ha llegado a ejecutar.
	 */
	private boolean ejecutarUpdate(String update) {
		boolean hecho = false;
		try {
			Statement s = conexion.createStatement();
			//System.out.println(update);
			s.execute(update);
			hecho = true;
		} catch (SQLException e) {}
		return hecho;
	}
	
	/**
	 * Devuelve el objeto de la conexión
	 * @return Connection objeto conexion
	 */
	public Connection getConexion() {
		return conexion;
	}
	
	public boolean ejecutarDelete(String tabla, String id) {
		String delete = "DELETE FROM " + tabla + " WHERE id = " + id;
		boolean hecho = false;
		try {
			Statement s = conexion.createStatement();
			System.out.println(delete);
			s.execute(delete);
			hecho = true;
			JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
		} catch (SQLException e) {}
		return hecho;
	}
	
	
	
}
