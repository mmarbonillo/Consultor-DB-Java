package login;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import modelo.*;
import menu.*;

/**
 * Controlador de la ventana de login
 */
public class ControlLogin implements ActionListener{
	
	/**
	 * Atributos del controlador
	 */
	Modelo modelo;
	VistaLogin vistaLogin;
	VistaMenu vistaMenu;
	
	/**
	 * Constructor que instancia el modelo y las vistas
	 * @param m Modelo de la aplicacion
	 * @param vl Vista de la ventana de login
	 * @param vm Vista de la ventana principal
	 */
	public ControlLogin(Modelo m, VistaLogin vl, VistaMenu vm) {
		modelo = m;
		vistaLogin = vl;
		vistaMenu = vm;
	}
	 /**
	  * Metodo que añade el escuchador de eventos a los elementos correspondientes
	  */
	public void jugar() {
		vistaLogin.conectar.addActionListener(this);
	}
	
	/**
	 * Este método usa el método 'login' del modelo para crear la conexión y cierra la ventana de login y abre la principal
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(modelo.login(vistaLogin.usr.getText(), vistaLogin.pass.getText())) {
			vistaLogin.frmLogin.setVisible(false);
			vistaMenu.frmMen.setVisible(true);
		}
		
	}
	
}
