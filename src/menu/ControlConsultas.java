package menu;

import modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlConsultas implements ActionListener{

	Modelo modelo;
	VistaMenu vista;
	VistaConsultas vc;
	
	public ControlConsultas(Modelo m, VistaMenu vm, VistaConsultas vc) {
		modelo = m;
		vista = vm;
		this.vc = vc;
	}
	
	public void jugar() {
		vista.btnVer.addActionListener(this);
		vista.button_4.addActionListener(this);
		vista.button_5.addActionListener(this);
		vista.button_6.addActionListener(this);
		vista.button_7.addActionListener(this);
		vista.button_8.addActionListener(this);
		vista.button_9.addActionListener(this);
		vista.button_10.addActionListener(this);
		vista.button_11.addActionListener(this);
		vista.button_12.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String consulta = ((JButton)arg0.getSource()).getName();
		consulta(consulta, vc.modelo, modelo, vc.scrollPane, vc.tabla);
		vc.ventana.setVisible(true);
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

}
