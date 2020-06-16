package menu;
import modelo.*;

import java.util.ArrayList;

import login.*;

/**
 * Aplicación principal en la que se crean e instancian todas las cases
 * @author Bonillo
 *
 */
public class MenuApp {
	public static void main(String[] args) {
		
		/* FUNCIONA */
		Modelo m = new Modelo();
		VistaMenu vm = new VistaMenu();
		VistaLogin vl = new VistaLogin();
		VistaConsultas vc = new VistaConsultas(m.getConexion());
		ControlLogin cl = new ControlLogin(m, vl, vm);
		cl.jugar();
		ControlCheckbox cc = new ControlCheckbox(m, vm);
		cc.jugar();
		ControlMenu cm = new ControlMenu(m, vm, vc);
		cm.jugar();
		ControlConsultas ccns = new ControlConsultas(m, vm, vc);
		ccns.jugar();
		ControlAdd cadd = new ControlAdd(m, vm);
		cadd.jugar();
		ControlUpdate cu = new ControlUpdate(m, vm);
		cu.jugar();
		ControlDelete cd = new ControlDelete(m, vm);
		cd.jugar();
		
		/*Modelo m = new Modelo();
		ArrayList<String> tablas = new ArrayList<String>();
		tablas.add("cliente");
		tablas.add("pedido");
		tablas.add("comercial");
		System.out.println(m.crearWhere(tablas));*/
		
		
	}
}
