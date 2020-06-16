package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;

public class VistaConsultas {

	public JFrame ventana;
	public JTable tabla;
	public DefaultTableModel modelo;
	public JLabel nombreTabla;
	public JScrollPane scrollPane;
	private Connection conexion;

	
	public VistaConsultas(Connection conex) {
		this.conexion = conex;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventana = new JFrame();
		ventana.setTitle("Consultas");
		ventana.setBounds(500, 400, 600, 328);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
		
		nombreTabla = new JLabel("");
		nombreTabla.setBounds(10, 21, 89, 14);
		ventana.getContentPane().add(nombreTabla);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 561, 209);
		ventana.getContentPane().add(scrollPane);
		
		tabla = new JTable(); 
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventana.setVisible(false);
				
			}
		});
		btnSalir.setBounds(464, 243, 97, 25);
		ventana.getContentPane().add(btnSalir);
	}
}
