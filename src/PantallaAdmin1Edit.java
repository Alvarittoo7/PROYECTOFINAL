import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PantallaAdmin1Edit {

	JFrame frame;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private Producto p;
	private PantallaAdmin1 PantallaAdmin1;
	ConexionBBDD conexion;

	

	
	public PantallaAdmin1Edit(Producto p) {
		
		this.p = p;
		//this.PantallaAdmin1 = pantallaAdmin1;
		initialize();
	}



	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodproducto = new JLabel("Cod_Producto->");
		lblCodproducto.setBounds(23, 44, 110, 14);
		panel.add(lblCodproducto);
		
		JLabel lblCodcategoria = new JLabel("Cod_Categoria->");
		lblCodcategoria.setBounds(23, 69, 110, 14);
		panel.add(lblCodcategoria);
		
		JLabel lblNombre = new JLabel("Nombre->");
		lblNombre.setBounds(23, 118, 59, 14);
		panel.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio->");
		lblPrecio.setBounds(47, 164, 106, 14);
		panel.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock->");
		lblStock.setBounds(47, 189, 106, 14);
		panel.add(lblStock);
		
		textField_5 = new JTextField();
		textField_5.setBounds(113, 186, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setText(String.valueOf(p.getStock()));
		
		
		textField_4 = new JTextField();
		textField_4.setBounds(113, 161, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		textField_4.setText(String.valueOf(p.getPrecio()));
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(113, 110, 123, 30);
		panel.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(p.getNombre());
		textField_3.setEditable(false);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(269, 55, 89, 43);
		panel.add(btnActualizar);
		btnActualizar.addActionListener(new Escuchador() {
			
		});

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaAdmin1.frame.dispose();
			}
		});
		btnCancelar.setBounds(269, 157, 89, 46);
		panel.add(btnCancelar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 41, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(p.getCod_producto());
		textField_1.setEditable(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 66, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(p.getCod_categoria());
		textField_2.setEditable(false);
		
		JLabel lblEdicinProducto = new JLabel("Edici\u00F3n Producto");
		lblEdicinProducto.setBounds(155, 11, 181, 14);
		panel.add(lblEdicinProducto);
		
		JButton btnBorrarPrecioY = new JButton("Borrar Precio y Stock");
		btnBorrarPrecioY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setText("");
				textField_5.setText("");

				
			}
		});
		btnBorrarPrecioY.setBounds(255, 112, 133, 27);
		panel.add(btnBorrarPrecioY);
		
		}
	

	private class Escuchador implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Esto sirve para grabar los datos, que actúa como actualizador
			Double newPrecio =Double.valueOf(textField_4.getText());
			ConexionBBDD conexion = new ConexionBBDD();
			if(newPrecio != null && !newPrecio.equals(p.getPrecio())) {
				p.setPrecio(newPrecio);
				conexion.ActualizarProducto(p);
			}
			Integer newStock=Integer.valueOf(textField_5.getText());
			if(newStock !=null && !newStock.equals(p.getStock())) {
				p.setStock(newStock);
				conexion.ActualizarProducto(p);
			}
			PantallaAdmin1.setVisible(true);
		}
	}
	
	
	private void setVisible(boolean visible) {

			}
}
