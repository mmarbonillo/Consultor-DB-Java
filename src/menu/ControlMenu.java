package menu;

import modelo.*;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador de la ventana de consultas a la base de datos
 * @author Bonillo
 *
 */
public class ControlMenu implements ActionListener{
	
	Modelo modelo;
	VistaMenu vistaMenu;
	VistaConsultas vc;
	String cadena = "^[A-Za-z\\s]*$";
	String numeros = "^[0-9]*.?[0-9]*$";
	
	private DefaultTableModel table = new DefaultTableModel();
	
	/**
	 * Controlador que instancia el modelo y la vista
	 * @param m Objeto de la clase Modelo
	 * @param vm Objeto de la clase VistaMenu
	 * @param vc Objeto de la clase VistaConsultas
	 */
	public ControlMenu(Modelo m, VistaMenu vm, VistaConsultas vc) {
		modelo = m;
		vistaMenu = vm;
		this.vc = vc;
	}
	
	/**
	  * Metodo que añade el escuchador de eventos a los elementos correspondientes
	  */
	public void jugar() {
		vistaMenu.btnGenerar.addActionListener(this);
		
	}
	
	/**
	 * Método escuchador de eventos que recoge y gestiona toda la ventana
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean bien = true;
		String boton = ((JButton)e.getSource()).getActionCommand();
			/* ESTO PARA CUANDO SE PRESIONE EL BOTÓN DE GENERAR CONSULTA (FUNCIONA QUE DA GUSTO)*/
			/* ELEMENTOS DEL PANEL DE CLIENTES */
		ArrayList<String> camposSelect = new ArrayList<String>(); /* ELEMENTOS PARA HACER EL SELECT */
		ArrayList<String> tablas = new ArrayList<String>(); /* ELEMENTOS PARA HACER EL FROM Y EL WHERE DE LAS CLAVES */
		ArrayList<String> camposWhere = new ArrayList<String>();
		ArrayList<String> condiciones = new ArrayList<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		boolean cli = false;
		
		if(comprobar(vistaMenu.camposCliente)) {
			Object[] componentes = vistaMenu.camposCliente.getComponents();
			int numComp = vistaMenu.camposCliente.getComponentCount();
			//COMIENZA EL FOR
			for(int i = 0; i < numComp; i++) {
				try { //RECOJO LOS CHECKBOX
					JCheckBox elm = (JCheckBox)componentes[i];
					if(!(elm.getName().equals("selectodos")) && elm.isSelected()) {
						cli = true;
						camposSelect.add(elm.getName());
					}
				}catch(Exception exc) {
					try { //RECOJO LOS TEXTFIELD
						JTextField dato = (JTextField)componentes[i];
						if(!(dato.getText().equals(""))) { //COMPRUEBO QUE NO ESTÉ VACÍO
							if(dato.getName().contains(".id") || dato.getName().contains(".categoria")) {
								cli = true;
								num.add(0); //EL número indica que condicional se usará para este campo
								camposWhere.add(dato.getName()); //RECOJO EL NOMBRE DEL CAMPO
								condiciones.add(dato.getText()); //RECOJO LA CONDICIÓN A FILTRAR
							}else if(dato.getName().contains(".nombre") || dato.getName().contains(".apellido") || dato.getName().contains(".ciudad")) {
								num.add(6);
								camposWhere.add(dato.getName()); //RECOJO EL NOMBRE DEL CAMPO
								condiciones.add("'" + dato.getText() + "'"); //RECOJO LA CONDICIÓN A FILTRAR
							}
						}
					}catch(Exception exc2) {}
				}//TERMINA EL CATCH
			}//TERMINA EL FOR
		}else bien = false;
		
		if(cli) tablas.add("cliente");
		
		if(comprobar(vistaMenu.camposPedido)) {
			/* ELEMENTOS DEL PANEL DE PEDIDOS */
			Object[] componentes = vistaMenu.camposPedido.getComponents();
			int numComp = vistaMenu.camposPedido.getComponentCount();
			for(int i = 0; i < numComp; i++) {
				try { //RECOJO LOS CHECKBOX
					JCheckBox elm = (JCheckBox)componentes[i];
					if(elm.isSelected() && elm.getName().equals("pedido")) {
						camposSelect.add("pedido.id");
						camposSelect.add("pedido.fecha_pedido");
						camposSelect.add("pedido.fecha_entrega");
						camposSelect.add("pedido.estado");
						camposSelect.add("pedido.total");
					}
				}catch (Exception exc) {
					try { //RECOJO EL ID
						JTextField dato = (JTextField)componentes[i];
						if(!(dato.getText().equals(""))) {
							if(dato.getName().contains(".id")) { 
								num.add(0);
								camposWhere.add(dato.getName());
								condiciones.add(dato.getText());
							}else if(dato.getName().contains(".precio")) {
								num.add(modelo.tipoPrecio(vistaMenu.cbPrecio.getSelectedIndex()));
								camposWhere.add(dato.getName());
								condiciones.add(dato.getText());
							}
						}
					}catch(Exception ex) {}
				}
			}
			
			//SI ALGÚN ELEMENTO ESTÁ RELLENO O SI EL CHECKBOX DE VER PEDIDOS ESTÁ SELECCIONADO, AÑADIMOS LA TABLA
			if(!(vistaMenu.txtPedidoId.getText().equals("")) || (vistaMenu.cbEstadoFecha.getSelectedIndex() != 0) || !(vistaMenu.txtPedidoPrecio1.getText().equals("")) || (vistaMenu.cbVerPedidos.isSelected()))
				tablas.add(vistaMenu.cbVerPedidos.getName());
			
			//RECOJO FECHA
			Date fechaBien = (Date)vistaMenu.calendario.getDate();
			if(fechaBien != null) { //SI EL CAMPO FECHA NO ESTÁ VACÍO ES PORQUE SE QUIERE BUSCAR POR ESTE CAMPO
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String fecha = dateFormat.format(fechaBien);
				String campoFecha = modelo.campoFecha((String)vistaMenu.cbEstadoFecha.getSelectedItem(), vistaMenu.cbEstadoFecha.getSelectedIndex());
				int indice = modelo.tipoFecha((int)vistaMenu.cbTipoFecha.getSelectedIndex());
				if(campoFecha != "") {
					num.add(indice);
					camposWhere.add(campoFecha);
					condiciones.add("'" + fecha + "'");
				}else JOptionPane.showMessageDialog(vistaMenu.frmMen, "Seleccione las opciones para realizar la búsqueda por fecha, por favor");
			}
		}else bien = false;
		
		if(comprobar(vistaMenu.camposComercial)) {
			/* ELEMENTOS DEL PANEL DE COMERCIALES */
			Object[] componentes = vistaMenu.camposComercial.getComponents();
			int numComp = vistaMenu.camposComercial.getComponentCount();
			for(int i = 0; i < numComp; i++) {
				try {
					JTextField dato = (JTextField)componentes[i];
					if(!(dato.getText().equals(""))) {
						if(dato.getName().contains(".id")) { //RECOJO ID
							num.add(0);
							camposWhere.add(dato.getName());
							condiciones.add(dato.getText());
						}else { //RECOJO NOMBRE
							num.add(6);
							camposWhere.add(dato.getName());
							condiciones.add(dato.getText());
						}
					}
				}catch(Exception ex) {}
			}
			
			if(!(vistaMenu.txtComercialId.getText().equals("")) || !(vistaMenu.txtComercialNombre.getText().equals("")) || vistaMenu.cbVerComerciales.isSelected()) {
				tablas.add(vistaMenu.camposComercial.getName());
			}
			if(vistaMenu.cbVerComerciales.isSelected()) {
				camposSelect.add("comercial.id");
				camposSelect.add("comercial.nombre");
				camposSelect.add("comercial.apellido1");
			}
		}else bien = false;
			
		if(bien) {
			String select = modelo.crearSelect(camposSelect);
			String from = modelo.crearFrom(tablas);
			String where = modelo.crearCondicionesWhere(tablas, camposWhere, condiciones, num);
			String consulta = select + "\n" + from + "\n" + where + ";";
			System.out.println(consulta);
			consulta(consulta, vc.modelo, modelo, vc.scrollPane, vc.tabla);
			vc.ventana.setVisible(true);
		}else JOptionPane.showMessageDialog(vistaMenu.camposCliente, "Por favor, compruebe que todos los campos están bien escritos");
	}
	
	
	/**
	 * Método que ejecuta la consulta y crea la ventana y la tabla para ver los resultados
	 * @param Query String con la consulta
	 * @param modelo DefaultTablaModel tabla modelo
	 * @param m Modelo para usar la conexión a la base de datos
	 * @param sp JScrollPane Donde poner la tabla
	 * @param tabla JTable con la tabla
	 */
	public void consulta(String Query, DefaultTableModel modelo, Modelo m, JScrollPane sp, JTable tabla){
		modelo = new DefaultTableModel();
		try {
    		Statement st = 	m.getConexion().createStatement();
            ResultSet resultSet = st.executeQuery(Query);
            int c = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= c; i++)
            	modelo.addColumn(resultSet.getMetaData().getColumnName(i));
            			            
            Vector<Object> fila = null;

            while(resultSet.next()) {
            	fila = new Vector<Object>();
                for (int i = 1; i <= c; i++)
                	fila.add(resultSet.getString(i));
                
                modelo.insertRow(modelo.getRowCount(),fila);
        	}
			JOptionPane.showMessageDialog(null, "Consulta realizada con éxito");
			tabla.setModel(modelo);
			sp.setViewportView(tabla);
    	} catch (Exception ex) {  JOptionPane.showMessageDialog(null, "Error en la consulta"); }
	}
	
	/**
	 * Método que comprueba que los campos de texto sean correctos.
	 * @param p JPanel del que recoger los campos de texto para comprobarlos.
	 * @return boolean TRUE si todos los campos están bien escritos. FALSE si algún campo no lo está.
	 */
	public boolean comprobar(JPanel p) {
		Pattern patron = null;
		boolean cumple = true;
		Object[] componentes = p.getComponents();
		int numComponentes = p.getComponentCount();
		Matcher m = null;
		for(int i = 0; i < numComponentes; i++) {
			try {
				JTextField dato = (JTextField)componentes[i];
				if(!(dato.getText().equals(""))){
					if(dato.getName().contains(".categoria") || dato.getName().contains(".precio") || dato.getName().contains(".id") || dato.getName().contains(".total") || dato.getName().contains(".comision")) {
						patron = Pattern.compile(numeros);
						m = patron.matcher(dato.getText());
						if(!(m.matches())) cumple = false;
					}else if(dato.getName().contains(".fecha")) {
						//nada
					}else {
						patron = Pattern.compile(cadena);
						m = patron.matcher(dato.getText());
						if(!(m.matches())) cumple = false;
					}
				}
			}catch(Exception e) {}
		}
		return cumple;
	}
}
