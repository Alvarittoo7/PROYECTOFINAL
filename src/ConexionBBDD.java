import java.sql.Connection;
import java.io.*;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ConexionBBDD {

	private String url;
	private String usr;
	private String pwd;
	private String esquema;
	public Connection conexion;
	

	public ConexionBBDD()  {
		
		FicheroINI();
		
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
		String query = "SELECT * FROM "+ esquema +".PRODUCTOS";
		 
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
		Double Precio = p.getPrecio();
		Integer Stock = p.getStock();
		int resultado = 0;
		
		String query = "UPDATE "+ esquema +".productos SET precio= " + Precio + " ,  stock= " + Stock + " WHERE cod_producto= " + Cod_producto;
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
		
		String query = "INSERT INTO "+ esquema +".productos VALUES('"+p.Cod_producto+"' , '"+p.Cod_categoria+"' , '"+p.nombre+"' , "+p.precio+" , "+p.Stock+")";
	
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
		
		String query = "DELETE FROM "+ esquema +".productos  WHERE  cod_producto= "+ Cod_producto;
	
		try {
			Statement stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);
			stmt.close();
		}catch (SQLException s) {
			s.printStackTrace();
		}
	return resultado;
	}

	public void FicheroINI() {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/configuracion.ini");
			if(miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url = propiedades.getProperty("basedatos");
				usr=propiedades.getProperty("usuario");
				pwd=propiedades.getProperty("clave");
				esquema=propiedades.getProperty("esquema");
			}
			else {
				System.err.println("fichero no encontrado");
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if(entrada != null) {
				try {
					entrada.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

