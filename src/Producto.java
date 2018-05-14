
public class Producto {

	 String Cod_producto;
	 String Cod_categoria;
     String nombre;
	 Double precio;
	 Integer Stock;

	public Producto(String cod_producto, String cod_categoria, String nombre, double precio, int stock) {
		super();
		Cod_producto = cod_producto;
		Cod_categoria = cod_categoria;
		this.nombre = nombre;
		this.precio = precio;
		Stock = stock;
	}

	public String getCod_producto() {
		return Cod_producto;
	}

	public void setCod_producto(String cod_producto) {
		Cod_producto = cod_producto;
	}

	public String getCod_categoria() {
		return Cod_categoria;
	}

	public void setCod_categoria(String cod_categoria) {
		Cod_categoria = cod_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	
}
