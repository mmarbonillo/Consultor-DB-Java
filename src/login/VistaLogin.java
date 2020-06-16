package login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Ventana de login
 * @author Bonillo
 *
 */
public class VistaLogin {

	public JFrame frmLogin;
	public JTextField usr;
	public JTextField pass;
	public JButton conectar;

	/**
	 * Controlador de la clase que inicializa y pone visible la ventana de login
	 */
	public VistaLogin() {
		initialize();
		frmLogin.setVisible(true);
	}

	
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 335, 326);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(72, 41, 64, 27);
		lblUsuario.setFocusable(false);
		frmLogin.getContentPane().add(lblUsuario);
		
		usr = new JTextField();
		usr.setBounds(72, 66, 152, 33);
		frmLogin.getContentPane().add(usr);
		usr.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasea.setBounds(72, 112, 93, 27);
		lblContrasea.setFocusable(false);
		frmLogin.getContentPane().add(lblContrasea);
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(72, 137, 152, 33);
		frmLogin.getContentPane().add(pass);
		
		conectar = new JButton("Conectar");
		conectar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		conectar.setBounds(99, 208, 105, 27);
		frmLogin.getContentPane().add(conectar);
	}
}
