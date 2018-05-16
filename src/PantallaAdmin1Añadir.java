import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaAdmin1Añadir {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public ConexionBBDD conexion;
	public Producto p;
	static String Cod_producto;
	static String Cod_categoria;
	static String Nombre;
	static Double Precio;
	static Integer Stock;
	PantallaAdmin1 table;

	

	/**
	 * Create the application.
	 * 
	 */
	public PantallaAdmin1Añadir() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		   Producto p = new Producto(null,null,null,0,0);
	       conexion = new ConexionBBDD();
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.YELLOW);
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblCodproducto = new JLabel("Cod_producto-->");
		lblCodproducto.setBounds(38, 22, 84, 14);
		frame.getContentPane().add(lblCodproducto);
		
		JLabel lblCodcategoria = new JLabel("Cod_categoria-->");
		lblCodcategoria.setBounds(38, 62, 97, 14);
		frame.getContentPane().add(lblCodcategoria);
		
		JLabel lblNombre = new JLabel("Nombre-->");
		lblNombre.setBounds(38, 109, 59, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio-->");
		lblPrecio.setBounds(38, 158, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock-->");
		lblStock.setBounds(38, 203, 46, 14);
		frame.getContentPane().add(lblStock);
		
		textField = new JTextField();
		textField.setBounds(135, 19, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 59, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 106, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 155, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 200, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setForeground(Color.RED);
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cod_producto = textField.getText();
				Cod_categoria = textField_1.getText();
				Nombre = textField_2.getText();
				Precio = Double.valueOf(textField_3.getText());
				Stock = Integer.valueOf(textField_4.getText());
				Producto p = new Producto(Cod_producto,Cod_categoria,Nombre,Precio,Stock);
				
				if(Cod_producto!="" && Cod_categoria!="" && Nombre!="" && Precio!=0 && Stock!=0) {
					conexion.AñadirProducto(p);
					
				}
			}
		});
		btnAadir.setBackground(Color.GREEN);
		btnAadir.setBounds(270, 62, 89, 67);
		frame.getContentPane().add(btnAadir);
		
		JButton btnBorrar = new JButton("Borrar datos introducidos");
		btnBorrar.setForeground(Color.RED);
		btnBorrar.setBackground(Color.GREEN);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnBorrar.setBounds(217, 158, 186, 51);
		frame.getContentPane().add(btnBorrar);
	}
}
