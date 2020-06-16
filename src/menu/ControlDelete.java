package menu;

import modelo.*;
import java.awt.event.*;
import java.util.regex.*;

import javax.swing.*;

/**
 * Controlador del panel de eliminar registros
 * @author Bonillo
 *
 */
public class ControlDelete implements ActionListener{
	
	Modelo modelo;
	VistaMenu vistaMenu;
	
	/**
	 * Controlador de la clase
	 * @param m Modelo
	 * @param vm VistaMenu
	 */
	public ControlDelete(Modelo m, VistaMenu vm) {
		modelo = m;
		vistaMenu = vm;
	}
	
	public void jugar() {
		vistaMenu.btnEliminar.addActionListener(this);
		vistaMenu.button_2.addActionListener(this);
		vistaMenu.button_3.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String tabla = ((JButton)arg0.getSource()).getName();
		switch(tabla) {
		case "cliente":
			if(comprobar(vistaMenu.panelEliminar))
				modelo.ejecutarDelete(tabla,vistaMenu.txtElimCliente.getText());
			else JOptionPane.showMessageDialog(vistaMenu.panelEliminar, "Por favor, compruebe que todos los campos están escritos correctamente");
			break;
		case "pedido":
			if(comprobar(vistaMenu.panelEliminar))
				modelo.ejecutarDelete(tabla, vistaMenu.txtElimPedido.getText());
			else JOptionPane.showMessageDialog(vistaMenu.panelEliminar, "Por favor, compruebe que todos los campos están escritos correctamente");
			break;
		case "comercial":
			if(comprobar(vistaMenu.panelEliminar))
				modelo.ejecutarDelete(tabla, vistaMenu.txtElimComercial.getText());
			else JOptionPane.showMessageDialog(vistaMenu.panelEliminar, "Por favor, compruebe que todos los campos están escritos correctamente");
		}
		
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
				if(!(dato.getText().equals(""))){
					patron = Pattern.compile("^[0-9]*.?[0-9]*$");
					m = patron.matcher(dato.getText());
					if(!(m.matches())) cumple = false;
				}
			}catch(Exception e) {}
		}
		return cumple;
	}

}
