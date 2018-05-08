import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class PantallaAdmin1 {

	public JFrame frame;
	private JTable table;
	private DefaultTableModel TablaDatos;
	private JScrollPane scrollpane;
	private ConexionBBDD conexion;


	

	/**
	 * Create the application.
	 */
	public PantallaAdmin1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaAdmin1.class.getResource("/Carpeta/fondo restaurante.jpg")));
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 964, 426);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(new Color(51, 51, 255));
		lblAdmin.setFont(new Font("Yu Gothic", Font.BOLD, 17));
		lblAdmin.setBounds(77, 16, 112, 14);
		frame.getContentPane().add(lblAdmin);
		
		JButton btnListarproductos = new JButton("ListarProductos");
		
		btnListarproductos.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\botones proyecto final\\boton listar productos.png"));
		btnListarproductos.setBounds(10, 41, 245, 104);
		frame.getContentPane().add(btnListarproductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 11, 659, 267);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(153, 153, 204));
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setForeground(new Color(51, 51, 255));
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Cod_Producto", "Cod_Categoria", "Nombre", "Precio", "Stock"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(97);
		table.getColumnModel().getColumn(1).setPreferredWidth(106);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setPreferredWidth(156);
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			
		public void mouseClicked(MouseEvent e) {
			
			int seleccion=table.rowAtPoint(e.getPoint());
			
			System.out.println(TablaDatos.getValueAt(seleccion, 1));
			Producto p = new Producto((String)TablaDatos.getValueAt(seleccion, 0),(String)TablaDatos.getValueAt(seleccion, 1), (String)TablaDatos.getValueAt(seleccion, 2), Double.valueOf((String)TablaDatos.getValueAt(seleccion, 3)), Integer.valueOf((String)TablaDatos.getValueAt(seleccion, 4)));
			
			PantallaAdmin1Edit edit1=new PantallaAdmin1Edit(p);
			edit1.frame.setVisible(true);
			
		}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.RED);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(10, 314, 229, 49);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setIcon(new ImageIcon("C:\\Users\\DAW1\\Desktop\\botones proyecto final\\boton a\u00F1adir productos.jpg"));
		btnAadir.setBounds(10, 168, 245, 110);
		frame.getContentPane().add(btnAadir);
		
		JLabel lblSiUstedDesea = new JLabel("Si usted desea editar un producto\r\n pulse sobre \u00E9l");
		lblSiUstedDesea.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSiUstedDesea.setBounds(353, 289, 530, 87);
		frame.getContentPane().add(lblSiUstedDesea);
		TablaDatos = new DefaultTableModel();
		
		btnListarproductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConexionBBDD Prueba = new ConexionBBDD();
				
				TablaDatos = Prueba.ConsultaTablaProductos();
				table.setModel(TablaDatos);
			}
		});
		
	}
	
	
	public void setVisible(boolean visible) {
		
	}
}
