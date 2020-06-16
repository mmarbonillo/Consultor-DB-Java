package menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import modelo.*;

/**
 * Controlador de las actualizaciones a la base de datos
 * @author Bonillo
 *
 */
public class ControlUpdate implements ActionListener{
	
	Modelo modelo;
	VistaMenu vistaMenu;
	String cadena = "^[A-Za-z\\\\s]*$";
	String numeros = "^[0-9]*.?[0-9]*$";
	
	/**
	 * Controlador que instancia el modelo y la vista
	 * @param m Objeto de la clase Modelo
	 * @param vm Objeto de la clase VistaMenu
	 */
	public ControlUpdate(Modelo m, VistaMenu vm) {
		modelo = m;
		vistaMenu = vm;
	}
	
	/**
	 * Metodo que añade el escuchador de eventos a los elementos correspondientes
	 */
	public void jugar() {
		vistaMenu.btnCambiar.addActionListener(this);
		vistaMenu.btnCambiar_1.addActionListener(this);
		vistaMenu.btnCambiar_2.addActionListener(this);
	}
	
	/**
	 * Método que realiza una comprobación sintáctica de la información que recoge y, si devuelve TRUE, modifica la información de la base de datos
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String tabla = ((JButton)arg0.getSource()).getName();
		switch(tabla) {
		case "cliente":
			if(comprobar(vistaMenu.actClientes))
				actualizar(vistaMenu.actClientes, tabla);
			else
				JOptionPane.showMessageDialog(vistaMenu.actClientes, "Compruebe que todos los campos están escritos correctamente, por favor");
			break;
		case "pedido":
			if(comprobar(vistaMenu.actPedidos))
				actualizar(vistaMenu.actPedidos, tabla);
			else
				JOptionPane.showMessageDialog(vistaMenu.actPedidos, "Compruebe que todos los campos están escritos correctamente, por favor");
			break;
		case "comercial":
			if(comprobar(vistaMenu.actComerciales))
				actualizar(vistaMenu.actComerciales, tabla);
			else
				JOptionPane.showMessageDialog(vistaMenu.actComerciales, "Compruebe que todos los campos están escritos correctamente, por favor");
			break;
		}
		
	}
	
	/**
	 * Método que actualiza la información a la base de datos
	 * @param p JPanel del cual recoger los campos
	 * @param tabla String con el de nombre de la tabla
	 */
	public void actualizar(JPanel p, String tabla) {
		Object[] componentes = p.getComponents();
		int numComponentes = p.getComponentCount();
		ArrayList<String> campos = new ArrayList<String>();
		ArrayList<String> contenido = new ArrayList<String>();
		for(int i = 0; i < numComponentes; i++) {
			try {
				JTextField dato = (JTextField)componentes[i];
				if(!(dato.getText().equals(""))) {
					campos.add(dato.getName());
					contenido.add(dato.getText());
				}
			}catch(Exception e) {}
		}
		System.out.println(campos);
		System.out.println(contenido);
		modelo.crearUpdate(campos, contenido, tabla);
	}
	
	/**
	 * Método que comprueba la sintaxis de toda la información recibida.
	 * @param p JPanel del cual se recogeran todos los datos.
	 * @return boolean TRUE si cumple que la sintaxis es correcta. FALSE si hay algún error sintáctico.
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
				if(dato.getName().contains(".categoria") || dato.getName().contains(".id") || dato.getName().contains(".total") || dato.getName().contains(".comision")) {
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
				
			}catch(Exception e) {}
		}
		return cumple;
	}
	
}
