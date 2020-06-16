package menu;
import modelo.*;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

public class VistaMenu {

	public JFrame frmMen;
	public JTextField txtClienteId;
	public JTextField txtClienteNombre;
	public JTextField txtClienteApe1;
	public JTextField txtClienteApe2;
	public JTextField txtPedidoId;
	public JPanel camposCliente;
	public JCheckBox cbSelTodos;
	public JCheckBox cbId;
	public JCheckBox cbNombre;
	public JCheckBox cbApe1;
	public JCheckBox cbApe2;
	public JCheckBox cbCiudad;
	public JCheckBox cbCategoria;
	public JTextField txtPedidoPrecio1;
	public JTextField txtComercialId;
	public JTextField txtComercialNombre;
	public JPanel camposPedido;
	public JTextField txtClienteCiudad;
	public JTextField txtClienteCat;
	public JButton btnGenerar;
	public JComboBox cbPrecio;
	public JComboBox cbEstadoFecha;
	public JComboBox cbTipoFecha;
	public JDateChooser calendario;
	public JCheckBox cbVerPedidos;
	public JPanel camposComercial;
	public JCheckBox cbVerComerciales;
	public JPanel andClientes;
	public JButton btnAadir;
	public JPanel addProductos;
	public JButton button;
	public JPanel addComerciales;
	public JButton button_1;
	public JButton btnCambiar;
	public JPanel actClientes;
	public JPanel actPedidos;
	public JButton btnCambiar_1;
	public JPanel actComerciales;
	public JButton btnCambiar_2;
	public JTextField txtElimCliente;
	public JTextField txtElimPedido;
	public JTextField txtElimComercial;
	public JButton btnEliminar;
	public JButton button_2;
	public JButton button_3;
	public JPanel panelEliminar;
	public JButton btnVer;
	public JButton button_4;
	public JButton button_5;
	public JButton button_6;
	public JButton button_7;
	public JButton button_8;
	public JButton button_9;
	public JButton button_10;
	public JButton button_11;
	public JButton button_12;
	
	/**
	 * Constructor que ejecuta todos los componentes de mi ventana
	 */
	public VistaMenu() {
		initialize();
	}

	/**
	 * Metodo que crea y ejecuta todos los componentes de la ventana
	 */
	private void initialize() {
		frmMen = new JFrame();
		frmMen.setTitle("Men\u00FA");
		frmMen.setBounds(100, 100, 618, 857);
		frmMen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMen.getContentPane().setLayout(null);
		
		JTabbedPane principal = new JTabbedPane(JTabbedPane.TOP);
		principal.setBounds(0, 0, 601, 810);
		frmMen.getContentPane().add(principal);
		
		JPanel consultas = new JPanel();
		principal.addTab("Consultar", null, consultas, null);
		consultas.setLayout(null);
		
		JTabbedPane secundario = new JTabbedPane(JTabbedPane.TOP);
		secundario.setBounds(0, 0, 600, 780);
		consultas.add(secundario);
		
		JPanel clientes = new JPanel();
		secundario.addTab("Clientes", null, clientes, null);
		clientes.setLayout(null);
		
		/* PANEL CLIENTE */
		camposCliente = new JPanel();
		camposCliente.setBounds(0, 0, 595, 266);
		clientes.add(camposCliente);
		camposCliente.setName("cliente");
		camposCliente.setLayout(null);
		
		/* CHECKBOX DE EL APARTADO DE CLIENTES */
		cbSelTodos = new JCheckBox("Seleccionar todos");
		cbSelTodos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbSelTodos.setName("selectodos");
		cbSelTodos.setBounds(24, 26, 151, 25);
		camposCliente.add(cbSelTodos);
		
		cbId = new JCheckBox("ID");
		cbId.setName("cliente.id");
		cbId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbId.setBounds(45, 56, 58, 25);
		cbId.setSelected(true);
		camposCliente.add(cbId);
		
		cbNombre = new JCheckBox("Nombre");
		cbNombre.setName("cliente.nombre");
		cbNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbNombre.setBounds(45, 86, 87, 25);
		cbNombre.setSelected(true);
		camposCliente.add(cbNombre);
		
		cbApe1 = new JCheckBox("Primer Apellido");
		cbApe1.setName("cliente.apellido1");
		cbApe1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbApe1.setBounds(45, 115, 130, 25);
		cbApe1.setSelected(true);
		camposCliente.add(cbApe1);
		
		cbApe2 = new JCheckBox("Segundo Apellido");
		cbApe2.setName("cliente.apellido2");
		cbApe2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbApe2.setBounds(45, 145, 144, 25);
		cbApe2.setSelected(true);
		camposCliente.add(cbApe2);
		
		cbCiudad = new JCheckBox("Ciudad");
		cbCiudad.setName("cliente.ciudad");
		cbCiudad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbCiudad.setBounds(45, 175, 87, 25);
		camposCliente.add(cbCiudad);
		
		cbCategoria = new JCheckBox("Categoria");
		cbCategoria.setName("cliente.categoria");
		cbCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbCategoria.setBounds(45, 205, 99, 25);
		camposCliente.add(cbCategoria);
		/* FINAL DE LOS CHECKBOX DEL APARTADO CLIENTES */
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(272, 32, 115, 25);
		camposCliente.add(label);
		
		txtClienteId = new JTextField();
		txtClienteId.setColumns(10);
		txtClienteId.setBounds(399, 30, 151, 25);
		txtClienteId.setName("cliente.id");
		camposCliente.add(txtClienteId);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(272, 70, 115, 25);
		camposCliente.add(label_1);
		
		txtClienteNombre = new JTextField();
		txtClienteNombre.setColumns(10);
		txtClienteNombre.setBounds(399, 66, 151, 25);
		txtClienteNombre.setName("cliente.nombre");
		camposCliente.add(txtClienteNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrimerApellido.setBounds(272, 108, 115, 25);
		camposCliente.add(lblPrimerApellido);
		
		txtClienteApe1 = new JTextField();
		txtClienteApe1.setColumns(10);
		txtClienteApe1.setBounds(399, 108, 151, 25);
		txtClienteApe1.setName("cliente.apellido1");
		camposCliente.add(txtClienteApe1);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSegundoApellido.setBounds(272, 146, 115, 25);
		camposCliente.add(lblSegundoApellido);
		
		txtClienteApe2 = new JTextField();
		txtClienteApe2.setColumns(10);
		txtClienteApe2.setBounds(399, 146, 151, 25);
		txtClienteApe2.setName("cliente.apellido2");
		camposCliente.add(txtClienteApe2);
		
		JLabel label_8 = new JLabel("Ciudad");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_8.setBounds(272, 184, 115, 25);
		camposCliente.add(label_8);
		
		txtClienteCiudad = new JTextField();
		txtClienteCiudad.setColumns(10);
		txtClienteCiudad.setBounds(399, 184, 151, 25);
		txtClienteCiudad.setName("cliente.ciudad");
		camposCliente.add(txtClienteCiudad);
		
		JLabel label_9 = new JLabel("Categor\u00EDa");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_9.setBounds(272, 222, 115, 25);
		camposCliente.add(label_9);
		
		txtClienteCat = new JTextField();
		txtClienteCat.setColumns(10);
		txtClienteCat.setBounds(399, 222, 151, 25);
		txtClienteCat.setName("cliente.categoria");
		camposCliente.add(txtClienteCat);
		
		/* PANEL DE PEDIDOS */
		camposPedido = new JPanel();
		camposPedido.setBounds(0, 264, 595, 253);
		camposPedido.setName("pedido");
		clientes.add(camposPedido);
		camposPedido.setLayout(null);
		
		JLabel label_4 = new JLabel("CON PEDIDO");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(26, 13, 123, 30);
		camposPedido.add(label_4);
		
		JLabel label_5 = new JLabel("ID");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(42, 58, 36, 25);
		camposPedido.add(label_5);
		
		txtPedidoId = new JTextField();
		txtPedidoId.setColumns(10);
		txtPedidoId.setBounds(110, 59, 74, 25);
		txtPedidoId.setName("pedido.id");
		camposPedido.add(txtPedidoId);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha.setBounds(42, 96, 52, 25);
		camposPedido.add(lblFecha);
		
		String[] estadofecha = {"Seleccionar...", "Pedido", "Esperada", "Entrega"};
		
		cbEstadoFecha = new JComboBox(estadofecha);
		cbEstadoFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbEstadoFecha.setBounds(110, 97, 123, 24);
		cbEstadoFecha.setName("estadoFecha");
		camposPedido.add(cbEstadoFecha);
		
		String[] tipofecha = {"Seleccionar...", "Exacta", "Antes de...", "Después de..."};
		
		cbTipoFecha = new JComboBox(tipofecha);
		cbTipoFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTipoFecha.setBounds(245, 98, 134, 23);
		camposPedido.add(cbTipoFecha);
		
		calendario = new JDateChooser();
		calendario.setBounds(395, 96, 151, 25);
		camposPedido.add(calendario);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(42, 134, 52, 25);
		camposPedido.add(lblEstado);
		
		JCheckBox chckbxEntregado = new JCheckBox("Entregado");
		chckbxEntregado.setName("entregado");
		chckbxEntregado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxEntregado.setBounds(110, 135, 101, 25);
		camposPedido.add(chckbxEntregado);
		
		JCheckBox chckbxPendiente = new JCheckBox("Pendiente");
		chckbxPendiente.setName("pendiente");
		chckbxPendiente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxPendiente.setBounds(225, 135, 101, 25);
		camposPedido.add(chckbxPendiente);
		
		JCheckBox chckbxCancelado = new JCheckBox("Cancelado");
		chckbxCancelado.setName("cancelado");
		chckbxCancelado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxCancelado.setBounds(338, 135, 101, 25);
		camposPedido.add(chckbxCancelado);
		
		cbVerPedidos = new JCheckBox("Ver datos de los pedidos");
		cbVerPedidos.setBounds(26, 218, 169, 25);
		cbVerPedidos.setName("pedido");
		camposPedido.add(cbVerPedidos);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(42, 172, 52, 25);
		camposPedido.add(lblPrecio);
		
		String[] tipoPrecio = {"Seleccionar...", "Más de", "Menos de", "Igual a"};
		
		cbPrecio = new JComboBox(tipoPrecio);
		cbPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPrecio.setBounds(110, 174, 123, 25);
		cbPrecio.setName("precio");
		camposPedido.add(cbPrecio);
		
		txtPedidoPrecio1 = new JTextField();
		txtPedidoPrecio1.setColumns(10);
		txtPedidoPrecio1.setBounds(245, 174, 74, 25);
		txtPedidoPrecio1.setName("pedido.total");
		txtPedidoPrecio1.setActionCommand("precio1");
		camposPedido.add(txtPedidoPrecio1);
		
		camposComercial = new JPanel();
		camposComercial.setBounds(0, 517, 595, 179);
		clientes.add(camposComercial);
		camposComercial.setName("comercial");
		camposComercial.setLayout(null);
		
		/* PANEL DE COMERCIALES */
		JLabel lblConComercial = new JLabel("CON COMERCIAL");
		lblConComercial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConComercial.setBounds(26, 13, 144, 30);
		camposComercial.add(lblConComercial);
		
		JLabel label_6 = new JLabel("ID");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_6.setBounds(42, 58, 36, 25);
		camposComercial.add(label_6);
		
		txtComercialId = new JTextField();
		txtComercialId.setColumns(10);
		txtComercialId.setBounds(120, 56, 72, 25);
		txtComercialId.setName("comercial.id");
		camposComercial.add(txtComercialId);
		
		JLabel label_7 = new JLabel("Nombre");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(42, 96, 72, 25);
		camposComercial.add(label_7);
		
		txtComercialNombre = new JTextField();
		txtComercialNombre.setColumns(10);
		txtComercialNombre.setBounds(120, 94, 151, 25);
		txtComercialNombre.setName("comercial.nombre");
		camposComercial.add(txtComercialNombre);
		
		cbVerComerciales = new JCheckBox("Ver datos de los comerciales");
		cbVerComerciales.setBounds(26, 139, 193, 25);
		cbVerComerciales.setName("comercial");
		camposComercial.add(cbVerComerciales);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(208, 709, 97, 25);
		btnGenerar.setActionCommand("generar");
		clientes.add(btnGenerar);
		
		JPanel pedidos = new JPanel();
		secundario.addTab("Pedidos", null, pedidos, null);
		pedidos.setLayout(null);
		
		JLabel lblTodosLosPedidos = new JLabel("Todos los pedidos");
		lblTodosLosPedidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTodosLosPedidos.setBounds(12, 13, 125, 23);
		pedidos.add(lblTodosLosPedidos);
		
		btnVer = new JButton("VER");
		btnVer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVer.setBounds(22, 49, 97, 25);
		btnVer.setName("SELECT * FROM pedido;");
		pedidos.add(btnVer);
		
		JLabel lblPedidosCancelados = new JLabel("Pedidos cancelados");
		lblPedidosCancelados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPedidosCancelados.setBounds(182, 13, 137, 23);
		pedidos.add(lblPedidosCancelados);
		
		button_4 = new JButton("VER");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_4.setBounds(192, 49, 97, 25);
		button_4.setName("SELECT * FROM pedido WHERE estado = 'cancelado';");
		pedidos.add(button_4);
		
		JLabel lblPedidosQueNo = new JLabel("Pedidos que no llegaron a tiempo");
		lblPedidosQueNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPedidosQueNo.setBounds(368, 13, 215, 23);
		pedidos.add(lblPedidosQueNo);
		
		button_5 = new JButton("VER");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_5.setBounds(419, 49, 97, 25);
		button_5.setName("SELECT * FROM pedido WHERE fecha_esperada < fecha_entrega;");
		pedidos.add(button_5);
		
		JLabel lblPedidosQueLlegaron = new JLabel("Pedidos que llegaron a tiempo");
		lblPedidosQueLlegaron.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPedidosQueLlegaron.setBounds(12, 114, 200, 23);
		pedidos.add(lblPedidosQueLlegaron);
		
		button_6 = new JButton("VER");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_6.setBounds(57, 150, 97, 25);
		button_6.setName("SELECT * FROM pedido WHERE fecha_esperada >= fecha_entrega;");
		pedidos.add(button_6);
		
		JLabel lblPedidosPorEnviar = new JLabel("Pedidos por enviar");
		lblPedidosPorEnviar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPedidosPorEnviar.setBounds(233, 118, 125, 23);
		pedidos.add(lblPedidosPorEnviar);
		
		button_7 = new JButton("VER");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_7.setBounds(243, 151, 97, 25);
		button_7.setName("SELECT * FROM pedido WHERE estado = 'pendiente';");
		pedidos.add(button_7);
		
		JLabel lblPedidosDeMs = new JLabel("Pedidos de m\u00E1s de 500\u20AC");
		lblPedidosDeMs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPedidosDeMs.setBounds(391, 118, 183, 23);
		pedidos.add(lblPedidosDeMs);
		
		button_8 = new JButton("VER");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_8.setBounds(419, 150, 97, 25);
		button_8.setName("SELECT * FROM pedido WHERE total >= 500;");
		pedidos.add(button_8);
		
		JPanel panel_1 = new JPanel();
		secundario.addTab("Comerciales", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblTodosLosComerciales = new JLabel("Todos los comerciales");
		lblTodosLosComerciales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTodosLosComerciales.setBounds(25, 27, 143, 23);
		panel_1.add(lblTodosLosComerciales);
		
		button_9 = new JButton("VER");
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_9.setBounds(46, 63, 97, 25);
		button_9.setName("SELECT * FROM comercial;");
		panel_1.add(button_9);
		
		JLabel lblComercialesCon = new JLabel("Comerciales con 0.12\r\n o m\u00E1s de comisi\u00F3n");
		lblComercialesCon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComercialesCon.setBounds(189, 27, 281, 23);
		panel_1.add(lblComercialesCon);
		
		button_10 = new JButton("VER");
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_10.setBounds(274, 63, 97, 25);
		button_10.setName("SELECT * FROM comercial WHERE comision >= 0.12;");
		panel_1.add(button_10);
		
		JLabel lblComercialesConMenos = new JLabel("Comerciales con menos de 0.12 de comisi\u00F3n");
		lblComercialesConMenos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComercialesConMenos.setBounds(25, 112, 290, 23);
		panel_1.add(lblComercialesConMenos);
		
		button_11 = new JButton("VER");
		button_11.setName("SELECT * FROM comercial WHERE comision < 0.12;");
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_11.setBounds(110, 148, 97, 25);
		panel_1.add(button_11);
		
		JLabel lblComercialesYNmero = new JLabel("Comerciales y n\u00FAmero de pedidos en los que han participado");
		lblComercialesYNmero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComercialesYNmero.setBounds(25, 196, 415, 23);
		panel_1.add(lblComercialesYNmero);
		
		button_12 = new JButton("VER");
		button_12.setName("SELECT comercial.*, COUNT(pedido.id) AS Pedidos\r\n" + 
				"FROM comercial JOIN pedido\r\n" + 
				"WHERE comercial.id = pedido.id_comercial\r\n" + 
				"GROUP BY comercial.id;");
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_12.setBounds(189, 232, 97, 25);
		panel_1.add(button_12);
		
		JPanel anadir = new JPanel();
		principal.addTab("Añadir", null, anadir, null);
		anadir.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 596, 780);
		anadir.add(tabbedPane);
		
		andClientes = new JPanel();
		tabbedPane.addTab("Clientes", null, andClientes, null);
		andClientes.setLayout(null);
		
		JLabel label_3 = new JLabel("Nombre");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_3.setBounds(28, 39, 115, 25);
		andClientes.add(label_3);
		
		JTextField andClienteNombre = new JTextField();
		andClienteNombre.setName("cliente.nombre");
		andClienteNombre.setColumns(10);
		andClienteNombre.setBounds(155, 40, 151, 25);
		andClienteNombre.setActionCommand("1");
		andClientes.add(andClienteNombre);
		
		JTextField andClienteApe1 = new JTextField();
		andClienteApe1.setName("cliente.apellido1");
		andClienteApe1.setColumns(10);
		andClienteApe1.setBounds(155, 77, 151, 25);
		andClienteApe1.setActionCommand("1");
		andClientes.add(andClienteApe1);
		
		JLabel label_10 = new JLabel("Primer Apellido");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_10.setBounds(28, 77, 115, 25);
		andClientes.add(label_10);
		
		JLabel label_11 = new JLabel("Segundo Apellido");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_11.setBounds(28, 115, 115, 25);
		andClientes.add(label_11);
		
		JTextField andClienteApe2 = new JTextField();
		andClienteApe2.setName("cliente.apellido2");
		andClienteApe2.setColumns(10);
		andClienteApe2.setBounds(155, 115, 151, 25);
		andClienteApe2.setActionCommand("1");
		andClientes.add(andClienteApe2);
		
		JLabel label_12 = new JLabel("Ciudad");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_12.setBounds(28, 153, 115, 25);
		andClientes.add(label_12);
		
		JTextField andClienteCiudad = new JTextField();
		andClienteCiudad.setName("cliente.ciudad");
		andClienteCiudad.setColumns(10);
		andClienteCiudad.setBounds(155, 153, 151, 25);
		andClienteCiudad.setActionCommand("1");
		andClientes.add(andClienteCiudad);
		
		JLabel label_13 = new JLabel("Categor\u00EDa");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_13.setBounds(28, 191, 115, 25);
		andClientes.add(label_13);
		
		JTextField andClienteCategoria = new JTextField();
		andClienteCategoria.setName("cliente.categoria");
		andClienteCategoria.setColumns(10);
		andClienteCategoria.setBounds(155, 191, 151, 25);
		andClienteCategoria.setActionCommand("2");
		andClientes.add(andClienteCategoria);
		
		btnAadir = new JButton("A\u00F1adir");
		btnAadir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAadir.setBounds(209, 244, 97, 25);
		btnAadir.setName("cliente");
		andClientes.add(btnAadir);
		
		addProductos = new JPanel();
		tabbedPane.addTab("Pedidos", null, addProductos, null);
		addProductos.setName("pedido");
		addProductos.setLayout(null);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotal.setBounds(32, 30, 115, 25);
		addProductos.add(lblTotal);
		
		JTextField textField = new JTextField();
		textField.setName("pedido.total");
		textField.setColumns(10);
		textField.setBounds(250, 30, 151, 25);
		addProductos.add(textField);
		
		JLabel lblFecha_1 = new JLabel("Fecha del pedido");
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFecha_1.setBounds(32, 68, 115, 25);
		addProductos.add(lblFecha_1);
		
		JTextField textField_1 = new JTextField();
		textField_1.setName("pedido.fecha_pedido");
		textField_1.setColumns(10);
		textField_1.setBounds(250, 67, 151, 25);
		addProductos.add(textField_1);
		
		JLabel lblFechaDeEntrega = new JLabel("Fecha de entrega estimada");
		lblFechaDeEntrega.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeEntrega.setBounds(32, 110, 206, 25);
		addProductos.add(lblFechaDeEntrega);
		
		JTextField textField_8 = new JTextField();
		textField_8.setName("pedido.fecha_esperada");
		textField_8.setColumns(10);
		textField_8.setBounds(250, 109, 151, 25);
		addProductos.add(textField_8);
		
		JTextField textField_10 = new JTextField();
		textField_10.setName("pedido.fecha_entrega");
		textField_10.setColumns(10);
		textField_10.setBounds(135, 324, 151, 25);
		textField_10.setText("NULL");
		textField_10.setVisible(false);
		addProductos.add(textField_10);
		
		JTextField textField_9 = new JTextField();
		textField_9.setName("pedido.estado");
		textField_9.setColumns(10);
		textField_9.setBounds(135, 286, 151, 25);
		textField_9.setText("Pendiente");
		textField_9.setVisible(false);
		addProductos.add(textField_9);
		
		JLabel lblIdcliente = new JLabel("Id_cliente");
		lblIdcliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdcliente.setBounds(32, 148, 115, 25);
		addProductos.add(lblIdcliente);
		
		JTextField textField_2 = new JTextField();
		textField_2.setName("pedido.id_cliente");
		textField_2.setColumns(10);
		textField_2.setBounds(250, 147, 151, 25);
		addProductos.add(textField_2);
		
		JLabel lblIdcomercial = new JLabel("Id_comercial");
		lblIdcomercial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIdcomercial.setBounds(32, 186, 115, 25);
		addProductos.add(lblIdcomercial);
		
		JTextField textField_3 = new JTextField();
		textField_3.setName("pedido.id_comercial");
		textField_3.setColumns(10);
		textField_3.setBounds(250, 185, 151, 25);
		addProductos.add(textField_3);
		
		button = new JButton("A\u00F1adir");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(304, 233, 97, 25);
		button.setName("pedido");
		addProductos.add(button);
		
		addComerciales = new JPanel();
		tabbedPane.addTab("Comerciales", null, addComerciales, null);
		addComerciales.setName("comercial");
		addComerciales.setLayout(null);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_2.setBounds(31, 27, 115, 25);
		addComerciales.add(label_2);
		
		JLabel label_14 = new JLabel("Primer Apellido");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_14.setBounds(31, 65, 115, 25);
		addComerciales.add(label_14);
		
		JLabel label_15 = new JLabel("Segundo Apellido");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_15.setBounds(31, 103, 115, 25);
		addComerciales.add(label_15);
		
		JLabel lblComision = new JLabel("Comision");
		lblComision.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComision.setBounds(31, 141, 115, 25);
		addComerciales.add(lblComision);
		
		JTextField textField_4 = new JTextField();
		textField_4.setName("comercial.nombre");
		textField_4.setColumns(10);
		textField_4.setBounds(158, 28, 151, 25);
		addComerciales.add(textField_4);
		
		JTextField textField_5 = new JTextField();
		textField_5.setName("comercial.apellido1");
		textField_5.setColumns(10);
		textField_5.setBounds(158, 65, 151, 25);
		addComerciales.add(textField_5);
		
		JTextField textField_6 = new JTextField();
		textField_6.setName("comercial.apellido2");
		textField_6.setColumns(10);
		textField_6.setBounds(158, 103, 151, 25);
		addComerciales.add(textField_6);
		
		JTextField textField_7 = new JTextField();
		textField_7.setName("comercial.comision");
		textField_7.setColumns(10);
		textField_7.setBounds(158, 141, 151, 25);
		addComerciales.add(textField_7);
		
		button_1 = new JButton("A\u00F1adir");
		button_1.setName("comercial");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_1.setBounds(212, 193, 97, 25);
		button_1.setName("comercial");
		addComerciales.add(button_1);
		
		JPanel panel = new JPanel();
		principal.addTab("Actualizar", null, panel, null);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 596, 780);
		panel.add(tabbedPane_1);
		
		actClientes = new JPanel();
		tabbedPane_1.addTab("Clientes", null, actClientes, null);
		actClientes.setName("cliente");
		actClientes.setLayout(null);
		
		JTextField textField_16 = new JTextField();
		textField_16.setName("cliente.id");
		textField_16.setColumns(10);
		textField_16.setActionCommand("1");
		textField_16.setBounds(63, 52, 151, 25);
		actClientes.add(textField_16);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(30, 51, 34, 25);
		actClientes.add(lblId);
		
		JLabel label_16 = new JLabel("Nombre");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_16.setBounds(63, 90, 115, 25);
		actClientes.add(label_16);
		
		JTextField textField_11 = new JTextField();
		textField_11.setName("cliente.nombre");
		textField_11.setColumns(10);
		textField_11.setActionCommand("1");
		textField_11.setBounds(190, 91, 151, 25);
		actClientes.add(textField_11);
		
		JLabel label_17 = new JLabel("Primer Apellido");
		label_17.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_17.setBounds(63, 128, 115, 25);
		actClientes.add(label_17);
		
		JTextField textField_12 = new JTextField();
		textField_12.setName("cliente.apellido1");
		textField_12.setColumns(10);
		textField_12.setActionCommand("1");
		textField_12.setBounds(190, 128, 151, 25);
		actClientes.add(textField_12);
		
		JLabel label_18 = new JLabel("Segundo Apellido");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_18.setBounds(63, 166, 115, 25);
		actClientes.add(label_18);
		
		JTextField textField_13 = new JTextField();
		textField_13.setName("cliente.apellido2");
		textField_13.setColumns(10);
		textField_13.setActionCommand("1");
		textField_13.setBounds(190, 166, 151, 25);
		actClientes.add(textField_13);
		
		JLabel label_19 = new JLabel("Ciudad");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_19.setBounds(63, 204, 115, 25);
		actClientes.add(label_19);
		
		JTextField textField_14 = new JTextField();
		textField_14.setName("cliente.ciudad");
		textField_14.setColumns(10);
		textField_14.setActionCommand("1");
		textField_14.setBounds(190, 204, 151, 25);
		actClientes.add(textField_14);
		
		JLabel label_20 = new JLabel("Categor\u00EDa");
		label_20.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_20.setBounds(63, 242, 115, 25);
		actClientes.add(label_20);
		
		JTextField textField_15 = new JTextField();
		textField_15.setName("cliente.categoria");
		textField_15.setColumns(10);
		textField_15.setActionCommand("2");
		textField_15.setBounds(190, 242, 151, 25);
		actClientes.add(textField_15);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.setName("cliente");
		btnCambiar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiar.setBounds(244, 295, 97, 25);
		actClientes.add(btnCambiar);
		
		JTextPane txtpnEscribaElId = new JTextPane();
		txtpnEscribaElId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtpnEscribaElId.setText("Escriba el ID del cliente que desea modificar y escriba en aquellos campos en los que va a realizar alg\u00FAn cambio.");
		txtpnEscribaElId.setBounds(363, 90, 216, 177);
		actClientes.add(txtpnEscribaElId);
		
		actPedidos = new JPanel();
		tabbedPane_1.addTab("Pedidos", null, actPedidos, null);
		actPedidos.setLayout(null);
		
		JLabel label_21 = new JLabel("Id");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_21.setBounds(27, 29, 34, 25);
		actPedidos.add(label_21);
		
		JTextField textField_17 = new JTextField();
		textField_17.setName("pedido.id");
		textField_17.setColumns(10);
		textField_17.setActionCommand("1");
		textField_17.setBounds(60, 30, 151, 25);
		actPedidos.add(textField_17);
		
		JLabel label_22 = new JLabel("Total");
		label_22.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_22.setBounds(60, 67, 115, 25);
		actPedidos.add(label_22);
		
		JTextField textField_18 = new JTextField();
		textField_18.setName("pedido.total");
		textField_18.setColumns(10);
		textField_18.setBounds(251, 67, 151, 25);
		actPedidos.add(textField_18);
		
		JLabel label_23 = new JLabel("Fecha del pedido");
		label_23.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_23.setBounds(60, 105, 115, 25);
		actPedidos.add(label_23);
		
		JTextField textField_19 = new JTextField();
		textField_19.setName("pedido.fecha_pedido");
		textField_19.setColumns(10);
		textField_19.setBounds(251, 104, 151, 25);
		actPedidos.add(textField_19);
		
		JLabel label_24 = new JLabel("Fecha de entrega estimada");
		label_24.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_24.setBounds(60, 147, 206, 25);
		actPedidos.add(label_24);
		
		JTextField textField_20 = new JTextField();
		textField_20.setName("pedido.fecha_esperada");
		textField_20.setColumns(10);
		textField_20.setBounds(251, 146, 151, 25);
		actPedidos.add(textField_20);
		
		JLabel lblFechaDeEntrega_1 = new JLabel("Fecha de entrega");
		lblFechaDeEntrega_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeEntrega_1.setBounds(60, 186, 115, 25);
		actPedidos.add(lblFechaDeEntrega_1);
		
		JLabel lblEstadoDelPedido = new JLabel("Estado del pedido");
		lblEstadoDelPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstadoDelPedido.setBounds(60, 228, 206, 25);
		actPedidos.add(lblEstadoDelPedido);
		
		JTextField textField_23 = new JTextField();
		textField_23.setName("pedido.fecha_entrega");
		textField_23.setColumns(10);
		textField_23.setBounds(251, 185, 151, 25);
		actPedidos.add(textField_23);
		
		JTextField textField_24 = new JTextField();
		textField_24.setName("pedido.estado");
		textField_24.setColumns(10);
		textField_24.setBounds(251, 227, 151, 25);
		actPedidos.add(textField_24);
		
		JLabel label_25 = new JLabel("Id_cliente");
		label_25.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_25.setBounds(60, 267, 115, 25);
		actPedidos.add(label_25);
		
		JTextField textField_21 = new JTextField();
		textField_21.setName("pedido.id_cliente");
		textField_21.setColumns(10);
		textField_21.setBounds(251, 266, 151, 25);
		actPedidos.add(textField_21);
		
		JLabel label_26 = new JLabel("Id_comercial");
		label_26.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_26.setBounds(60, 305, 115, 25);
		actPedidos.add(label_26);
		
		JTextField textField_22 = new JTextField();
		textField_22.setName("pedido.id_comercial");
		textField_22.setColumns(10);
		textField_22.setBounds(251, 304, 151, 25);
		actPedidos.add(textField_22);
		
		btnCambiar_1 = new JButton("Cambiar");
		btnCambiar_1.setName("pedido");
		btnCambiar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiar_1.setBounds(305, 360, 97, 25);
		actPedidos.add(btnCambiar_1);
		
		actComerciales = new JPanel();
		tabbedPane_1.addTab("Comerciales", null, actComerciales, null);
		actComerciales.setLayout(null);
		
		JLabel label_27 = new JLabel("Id");
		label_27.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_27.setBounds(24, 28, 34, 25);
		actComerciales.add(label_27);
		
		JTextField textField_25 = new JTextField();
		textField_25.setName("comercial.id");
		textField_25.setColumns(10);
		textField_25.setActionCommand("1");
		textField_25.setBounds(57, 29, 151, 25);
		actComerciales.add(textField_25);
		
		JLabel label_28 = new JLabel("Nombre");
		label_28.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_28.setBounds(57, 66, 115, 25);
		actComerciales.add(label_28);
		
		JTextField textField_26 = new JTextField();
		textField_26.setName("comercial.nombre");
		textField_26.setColumns(10);
		textField_26.setBounds(184, 67, 151, 25);
		actComerciales.add(textField_26);
		
		JLabel label_29 = new JLabel("Primer Apellido");
		label_29.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_29.setBounds(57, 104, 115, 25);
		actComerciales.add(label_29);
		
		JTextField textField_27 = new JTextField();
		textField_27.setName("comercial.apellido1");
		textField_27.setColumns(10);
		textField_27.setBounds(184, 104, 151, 25);
		actComerciales.add(textField_27);
		
		JLabel label_30 = new JLabel("Segundo Apellido");
		label_30.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_30.setBounds(57, 142, 115, 25);
		actComerciales.add(label_30);
		
		JTextField textField_28 = new JTextField();
		textField_28.setName("comercial.apellido2");
		textField_28.setColumns(10);
		textField_28.setBounds(184, 142, 151, 25);
		actComerciales.add(textField_28);
		
		JLabel label_31 = new JLabel("Comision");
		label_31.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_31.setBounds(57, 180, 115, 25);
		actComerciales.add(label_31);
		
		JTextField textField_29 = new JTextField();
		textField_29.setName("comercial.comision");
		textField_29.setColumns(10);
		textField_29.setBounds(184, 180, 151, 25);
		actComerciales.add(textField_29);
		
		btnCambiar_2 = new JButton("Cambiar");
		btnCambiar_2.setName("comercial");
		btnCambiar_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCambiar_2.setBounds(238, 232, 97, 25);
		actComerciales.add(btnCambiar_2);
		
		panelEliminar = new JPanel();
		principal.addTab("Eliminar", null, panelEliminar, null);
		panelEliminar.setLayout(null);
		
		txtElimCliente = new JTextField();
		txtElimCliente.setName("cliente.id");
		txtElimCliente.setColumns(10);
		txtElimCliente.setActionCommand("1");
		txtElimCliente.setBounds(65, 75, 151, 25);
		panelEliminar.add(txtElimCliente);
		
		JLabel label_32 = new JLabel("Id");
		label_32.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_32.setBounds(32, 74, 34, 25);
		panelEliminar.add(label_32);
		
		JLabel label_33 = new JLabel("Id");
		label_33.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_33.setBounds(32, 149, 34, 25);
		panelEliminar.add(label_33);
		
		txtElimPedido = new JTextField();
		txtElimPedido.setName("pedido.id");
		txtElimPedido.setColumns(10);
		txtElimPedido.setActionCommand("1");
		txtElimPedido.setBounds(65, 150, 151, 25);
		panelEliminar.add(txtElimPedido);
		
		JLabel label_34 = new JLabel("Id");
		label_34.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_34.setBounds(32, 225, 34, 25);
		panelEliminar.add(label_34);
		
		txtElimComercial = new JTextField();
		txtElimComercial.setName("comercial.id");
		txtElimComercial.setColumns(10);
		txtElimComercial.setActionCommand("1");
		txtElimComercial.setBounds(65, 226, 151, 25);
		panelEliminar.add(txtElimComercial);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(248, 75, 97, 25);
		btnEliminar.setName("cliente");
		panelEliminar.add(btnEliminar);
		
		button_2 = new JButton("Eliminar");
		button_2.setBounds(248, 150, 97, 25);
		button_2.setName("pedido");
		panelEliminar.add(button_2);
		
		button_3 = new JButton("Eliminar");
		button_3.setBounds(248, 226, 97, 25);
		button_3.setName("comercial");
		panelEliminar.add(button_3);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClientes.setBounds(32, 37, 61, 25);
		panelEliminar.add(lblClientes);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPedidos.setBounds(32, 111, 61, 25);
		panelEliminar.add(lblPedidos);
		
		JLabel lblComerciales = new JLabel("Comerciales");
		lblComerciales.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComerciales.setBounds(32, 187, 85, 25);
		panelEliminar.add(lblComerciales);
		
		
	}
}
