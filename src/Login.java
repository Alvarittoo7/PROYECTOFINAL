import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;

public class Login extends JFrame{

	public JFrame frmResgistro;
	private JPasswordField passwordField;
	private JTextField textField;

	
	
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmResgistro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResgistro = new JFrame();
		frmResgistro.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DAW1\\Desktop\\fondo restaurante.jpg"));
		frmResgistro.setTitle("Resgistro");
		frmResgistro.getContentPane().setBackground(Color.YELLOW);
		frmResgistro.setBounds(100, 100, 388, 300);
		//frmResgistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResgistro.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(77, 64, 58, 14);
		frmResgistro.getContentPane().add(lblNombre);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(135, 111, 108, 28);
		frmResgistro.getContentPane().add(passwordField);
		
		
		textField = new JTextField();
		textField.setBounds(145, 61, 86, 20);
		frmResgistro.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(158, 96, 72, 14);
		frmResgistro.getContentPane().add(lblContrasea);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar sesion---->");
		lblIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblIniciarSesion.setBackground(Color.RED);
		lblIniciarSesion.setBounds(127, 12, 214, 41);
		frmResgistro.getContentPane().add(lblIniciarSesion);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(Color.RED);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user=textField.getText();
				String passw=String.valueOf(passwordField.getPassword());
		
				if(user.equals("")) {
					JOptionPane.showMessageDialog(frmResgistro, "Error introducción datos");
				}
				else {
					if(passw.equals("1234")) {
						
							Pantalla1 pantalla = new Pantalla1(frmResgistro);
							pantalla.frame.setVisible(true);
							
						
					}
					else {JOptionPane.showMessageDialog(frmResgistro, "Error contraseña");
						
					}
				
				}
			
			}
		});
		btnEnviar.setBounds(74, 162, 89, 23);
		frmResgistro.getContentPane().add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.RED);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText("");
			passwordField.setText("");
			}
		});
		btnCancelar.setBounds(234, 162, 89, 23);
		frmResgistro.getContentPane().add(btnCancelar);
	
	}
}
