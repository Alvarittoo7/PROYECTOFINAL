import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Pantalla1 extends JFrame{

	public JFrame frame;
    private JFrame Login;

	


	/**
	 * Create the application.
	 */
	public Pantalla1(JFrame frmResgistro) {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Pantalla1.class.getResource("/Carpeta/fondo restaurante.jpg")));
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setForeground(Color.BLUE);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PantallaAdmin1 PantallaAdmin2=new PantallaAdmin1();
				PantallaAdmin2.frame.setVisible(true);
			}
		});
		btnAdmin.setBounds(166, 31, 89, 51);
		frame.getContentPane().add(btnAdmin);
		
		JButton btnRestaurante = new JButton("RESTAURANTE");
		btnRestaurante.setForeground(Color.BLUE);
		btnRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					PantallaRestaurante1 PantallaRestaurante2=new PantallaRestaurante1();
					PantallaRestaurante2.frame.setVisible(true);
			}
		});
		btnRestaurante.setBounds(149, 110, 122, 43);
		frame.getContentPane().add(btnRestaurante);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.GREEN);
		btnCancelar.setForeground(Color.RED);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(149, 181, 122, 23);
		frame.getContentPane().add(btnCancelar);
	}
}
