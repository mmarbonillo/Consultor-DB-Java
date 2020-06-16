package menu;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import modelo.*;

/**
 * Controlador del checkbox 'Seleccionar todos'
 * @author Bonillo
 *
 */
public class ControlCheckbox implements MouseListener{
	
	Modelo modelo;
	VistaMenu vistaMenu;
	
	/**
	 * Controlador que instancia el modelo y la vista
	 * @param m Objeto de la clase Modelo
	 * @param vm Objeto de la clase VistaMenu
	 */
	public ControlCheckbox(Modelo m, VistaMenu vm) {
		modelo = m;
		vistaMenu = vm;
	}
	
	/**
	  * Metodo que añade el escuchador de eventos a los elementos correspondientes
	  */
	public void jugar() {
		vistaMenu.cbSelTodos.addMouseListener(this);
	}
	
	/**
	 * Escuchador de eventos de ratón
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		JCheckBox elemento = (JCheckBox)e.getComponent();
		String nombre = e.getComponent().getName();
		//JOptionPane.showMessageDialog(null, nombre);
		if(elemento.isSelected() && nombre.equals("selectodos")) {
			vistaMenu.cbId.setSelected(true);
			vistaMenu.cbNombre.setSelected(true);
			vistaMenu.cbApe1.setSelected(true);
			vistaMenu.cbApe2.setSelected(true);
			vistaMenu.cbCiudad.setSelected(true);
			vistaMenu.cbCategoria.setSelected(true);
		}else {
			vistaMenu.cbId.setSelected(false);
			vistaMenu.cbNombre.setSelected(false);
			vistaMenu.cbApe1.setSelected(false);
			vistaMenu.cbApe2.setSelected(false);
			vistaMenu.cbCiudad.setSelected(false);
			vistaMenu.cbCategoria.setSelected(false);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
