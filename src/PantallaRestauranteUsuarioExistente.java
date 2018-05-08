import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaRestauranteUsuarioExistente {

	public JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public PantallaRestauranteUsuarioExistente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaRestauranteUsuarioExistente.class.getResource("/Carpeta/fondo restaurante.jpg")));
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 948, 433);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsuarioExistente = new JLabel("Usuario Existente");
		lblUsuarioExistente.setForeground(new Color(51, 51, 255));
		lblUsuarioExistente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuarioExistente.setBounds(327, 31, 146, 14);
		frame.getContentPane().add(lblUsuarioExistente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(539, 112, 360, 191);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(153, 153, 204));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Cod_pedido", "Num_mesa", "Categoria", "Productos", "PrecioTotal"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnAadir = new JButton("");
		btnAadir.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\botones proyecto final\\boton a\u00F1adir productos.jpg"));
		btnAadir.setBounds(320, 110, 153, 117);
		frame.getContentPane().add(btnAadir);
		
		JLabel lblAadir = new JLabel("A\u00F1adir");
		lblAadir.setForeground(new Color(255, 0, 0));
		lblAadir.setBounds(377, 96, 46, 14);
		frame.getContentPane().add(lblAadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 0, 0));
		btnCancelar.setBounds(320, 266, 158, 92);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblDesayunos = new JLabel("Desayunos");
		lblDesayunos.setBounds(98, 96, 79, 14);
		frame.getContentPane().add(lblDesayunos);
		
		JLabel lblComidas = new JLabel("Comidas");
		lblComidas.setBounds(98, 201, 46, 14);
		frame.getContentPane().add(lblComidas);
		
		JLabel lblCenas = new JLabel("Cenas");
		lblCenas.setBounds(98, 305, 46, 14);
		frame.getContentPane().add(lblCenas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.GREEN);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"pollo"}));
		comboBox.setBounds(98, 121, 96, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.GREEN);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"helado chocolate"}));
		comboBox_1.setBounds(98, 226, 96, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.GREEN);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"pasta rellena"}));
		comboBox_2.setBounds(98, 330, 96, 20);
		frame.getContentPane().add(comboBox_2);
	}

}
