import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;

public class PantallaRestauranteNuevoUsuario {

	public JFrame frame;
	private JTable table;

	

	/**
	 * Create the application.
	 */
	public PantallaRestauranteNuevoUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaRestauranteNuevoUsuario.class.getResource("/Carpeta/fondo restaurante.jpg")));
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIndiqueNumeroDe = new JLabel("Indique numero de Mesa:");
		lblIndiqueNumeroDe.setForeground(new Color(51, 51, 255));
		lblIndiqueNumeroDe.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblIndiqueNumeroDe.setBounds(10, 11, 139, 14);
		frame.getContentPane().add(lblIndiqueNumeroDe);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.GREEN);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
		comboBox.setBounds(10, 36, 121, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblCategorias = new JLabel("Categorias:");
		lblCategorias.setForeground(new Color(51, 51, 255));
		lblCategorias.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 32));
		lblCategorias.setBounds(10, 67, 193, 39);
		frame.getContentPane().add(lblCategorias);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.GREEN);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"pollo"}));
		comboBox_1.setBounds(10, 138, 70, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(Color.GREEN);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"helado chocolate"}));
		comboBox_2.setBounds(10, 183, 121, 20);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(Color.GREEN);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"pasta rellena"}));
		comboBox_3.setBounds(141, 138, 87, 20);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblDesayunos = new JLabel("Desayunos");
		lblDesayunos.setBounds(10, 113, 70, 14);
		frame.getContentPane().add(lblDesayunos);
		
		JLabel lblComidas = new JLabel("Comidas");
		lblComidas.setBounds(10, 169, 46, 14);
		frame.getContentPane().add(lblComidas);
		
		JLabel lblCenas = new JLabel("Cenas");
		lblCenas.setBounds(157, 117, 46, 14);
		frame.getContentPane().add(lblCenas);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.GREEN);
		btnCancelar.setForeground(Color.RED);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(211, 278, 102, 39);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(PantallaRestauranteNuevoUsuario.class.getResource("/Carpeta/boton a\u00F1adir productos.jpg")));
		btnNewButton.setBounds(10, 214, 175, 103);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(352, 36, 390, 251);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setBackground(new Color(153, 153, 204));
		table.setForeground(new Color(51, 51, 255));
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Cod_pedido", "Num_Mesa", "Categoria", "Productos", "PrecioTotal", "Camarero"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblAadir = new JLabel("A\u00F1adir");
		lblAadir.setBounds(139, 201, 46, 14);
		frame.getContentPane().add(lblAadir);
		frame.setBounds(100, 100, 779, 379);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
