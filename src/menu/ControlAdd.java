package menu;
import modelo.*;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Controlador del panel de a�adir
 * @author Bonillo
 *
 */
public class ControlAdd implements ActionListener{
	
	/**
	 * Atributos de mi clase
	 */
	Modelo modelo;
	VistaMenu vistaMenu;
	ArrayList<String> campos = new ArrayList<String>();
	String cadena = "^[A-Za-z\\\\s]*$";
	String numeros = "^[0-9]*.?[0-9]*$";
	
	/**
	 * Controlador que instancia el modelo y la vista
	 * @param m Objeto de la clase Modelo
	 * @param vm Objeto de la clase VistaMenu
	 */
	public ControlAdd(Modelo m, VistaMenu vm) {
		modelo = m;
		vistaMenu = vm;
	}
	
	/**
	 * Metodo que a�ade el escuchador de eventos a los elementos correspondientes
	 */
	public void jugar() {
		vistaMenu.btnAadir.addActionListener(this);
		vistaMenu.button.addActionListener(this);
		vistaMenu.button_1.addActionListener(this);
	}
	
	/**
	 * M�todo que realiza una comprobaci�n sint�ctica de la informaci�n que recoge y, si devuelve TRUE, a�ade la informaci�n a la base de datos
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) { //PROBAR PATRONES
		JButton boton = (JButton)arg0.getSource();
		switch(boton.getName()) {
		case "cliente":
			if(comprobar(vistaMenu.andClientes))
				anadir(vistaMenu.andClientes, boton);
			else JOptionPane.showMessageDialog(vistaMenu.andClientes, "Por favor, compruebe que todos los campos est�n correctamente escritos");
			break;
		case "pedido":
			if(comprobar(vistaMenu.addProductos))
				anadir(vistaMenu.addProductos, boton);
			else JOptionPane.showMessageDialog(vistaMenu.andClientes, "Por favor, compruebe que todos los campos est�n correctamente escritos");
			break;
		case "comercial":
			if(comprobar(vistaMenu.addComerciales))
				anadir(vistaMenu.addComerciales, boton);
			else JOptionPane.showMessageDialog(vistaMenu.andClientes, "Por favor, compruebe que todos los campos est�n correctamente escritos");
			break;
		}
	}
	
	/**
	 * M�todo que comprueba la sintaxis de toda la informaci�n recibida.
	 * @param p JPanel del cual se recogeran todos los datos.
	 * @return boolean TRUE si cumple que la sintaxis es correcta. FALSE si hay alg�n error sint�ctico.
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
	
	/**
	 * M�todo que recoge la informaci�n de todos los campos
	 * @param p JPanel del cual recoger los campos
	 * @param boton JButton con getName() de nombre de la tabla
	 * @return boolean TRUE si todos los campos est�s rellenos. FALSE si hay alg�n campo vac�o
	 */
	private boolean sacarCampos(JPanel p, JButton boton) {
		Object[] componentes = p.getComponents();
		int numComponentes = p.getComponentCount();
		boolean completo = true;
		for(int i = 0; i < numComponentes; i++) {
			try {
				JTextField dato = (JTextField)componentes[i];
				if(!(dato.getText().equals(""))) {
					campos.add(dato.getText());
					dato.setText("");
				}else{
					JOptionPane.showMessageDialog(vistaMenu.frmMen, "Rellena todos los campos por favor");
					completo = false;
				}
			}catch(Exception e) {}
		}
		return completo;
	}
	
	/**
	 * M�todo que a�ade la informaci�n a la base de datos siempre y cuando el m�todo 'sacarCampos' devuelva TRUE
	 * @param p JPanel del cual recoger los campos
	 * @param boton JButton con getName() de nombre de la tabla
	 */
	public void anadir(JPanel p, JButton boton) {
		Object[] componentes = p.getComponents();
		int numComponentes = p.getComponentCount();
		if(sacarCampos(p, boton))
			if(modelo.ejecutarInsert(campos, boton.getName())) {
				JOptionPane.showMessageDialog(vistaMenu.frmMen, "A�adido correctamente");
				int x = 0;
				boolean encontrado = false;
				while(x < numComponentes && !encontrado) {
					try {
						//Para que el primer JTextField reciba el foco
						JTextField primero = (JTextField)componentes[x];
						encontrado = true;
						primero.requestFocus();
					}catch(Exception ex) {}
				}
			}
	}

}
