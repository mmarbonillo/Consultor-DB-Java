package login;
import menu.ControlAdd;
import menu.VistaMenu;
import modelo.*;

/**
 * Aplicación principal en la que se crean e instancian todas las cases
 * @author Bonillo
 *
 */
public class LoginApp {
	public static void main(String[] args) {
		Modelo m = new Modelo();
		VistaLogin v = new VistaLogin();
		VistaMenu vm = new VistaMenu();
		ControlLogin c = new ControlLogin(m, v, vm);
		ControlAdd ca = new ControlAdd(m, vm);
		ca.jugar();
		c.jugar();
		
		/*Modelo m = new Modelo();
		m.login("root", "");
		m.getTablas();*/
	}
}
