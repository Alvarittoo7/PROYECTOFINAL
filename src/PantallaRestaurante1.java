import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class PantallaRestaurante1 {

	public JFrame frame;


	/**
	 * Create the application.
	 */
	public PantallaRestaurante1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaRestaurante1.class.getResource("/Carpeta/fondo restaurante.jpg")));
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.setForeground(Color.BLUE);
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRestauranteNuevoUsuario usuarioNuevo=new PantallaRestauranteNuevoUsuario();
				usuarioNuevo.frame.setVisible(true);
			}
		});
		btnNuevoUsuario.setBounds(152, 72, 146, 23);
		frame.getContentPane().add(btnNuevoUsuario);
		
		JButton btnUsuarioExistente = new JButton("Usuario Existente");
		btnUsuarioExistente.setForeground(Color.BLUE);
		btnUsuarioExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRestauranteUsuarioExistente usuarioExistente=new PantallaRestauranteUsuarioExistente();
				usuarioExistente.frame.setVisible(true);
			}
		});
		btnUsuarioExistente.setBounds(152, 124, 146, 23);
		frame.getContentPane().add(btnUsuarioExistente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.RED);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(179, 195, 89, 23);
		frame.getContentPane().add(btnCancelar);
	}

}
