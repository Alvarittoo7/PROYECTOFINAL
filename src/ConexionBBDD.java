import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	private String bd;
	private String url= "jdbc:oracle:thin:@localhost:1521:XE";
	private String usr = "ALBERTO";
	private String pwd = "alberto1234";
	public Connection conexion;
	

	public ConexionBBDD()  {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd);
			
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}
	
	public DefaultTableModel ConsultaTablaProductos() {
		String [] columnas={"Cod_Producto","Cod_Categoria","Nombre","Precio","Stock"};
		String [] registro=new String[5];
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT * FROM ALBERTO.PRODUCTOS";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("Cod_Producto");
		         registro[1]=rset.getString("Cod_Categoria");
		         registro[2]=rset.getString("Nombre");
		         registro[3]=String.valueOf(rset.getDouble("Precio"));
		         registro[4]=String.valueOf(rset.getInt("Stock"));
		         ModeloTabla.addRow(registro);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return ModeloTabla;
	}
	
	public int ActualizarProducto(Producto p) {
		String Cod_producto = p.getCod_producto();
		String Cod_categoria = p.getCod_categoria();
		String Nombre = p.getNombre();
		Double Precio = p.getPrecio();
		Integer Stock = p.getStock();
		int resultado = 0;
		
		String query = "UPDATE ALBERTO.productos SET precio= " + Precio + " ,  stock= " + Stock + " WHERE cod_producto= " + Cod_producto;
		System.out.println(query);
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	return resultado;
	}
	
	
	public int AñadirProducto(Producto p) {
		
		int resultado = 0;
		
		String query = "INSERT INTO ALBERTO.productos VALUES('"+p.Cod_producto+"' , '"+p.Cod_categoria+"' , '"+p.nombre+"' , "+p.precio+" , "+p.Stock+")";
	
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	return resultado;
	
	}
public int EliminarProducto(Producto p) {
	    String Cod_producto = p.getCod_producto();
		
		int resultado = 0;
		
		String query = "DELETE FROM ALBERTO.productos  WHERE  cod_producto= "+ Cod_producto;
	
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	return resultado;
	}
}
