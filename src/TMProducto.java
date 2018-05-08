import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class TMProducto implements TableModel {

	ArrayList<Producto> productos;
	
	public TMProducto(ArrayList<Producto> productos) {
		super();
		this.productos = productos;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.productos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		String sAux = "";
		switch (columnIndex) {
			case 0:
				sAux = "Cod_producto";
				break;
			case 1:
				sAux = "Cod_categoria";
				break;
			case 2:
				sAux = "Nombre";
				break;
			case 3:
				sAux = "Precio";
				break;
			case 4:
				sAux = "Stock";
				break;
		}
		return sAux;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Producto p = productos.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getCod_producto();
		case 1:
			return p.getCod_categoria();
		case 2:
			return p.getNombre();
		case 3:
			return p.getPrecio();
		case 4:
			return p.getStock();
		default:
			return null;
		}

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Producto p = productos.get(rowIndex);
		
		switch (columnIndex) {
			case 0:
				p.setCod_producto(aValue.toString());
				break;
			case 1:
				p.setCod_categoria(aValue.toString());
				break;
			case 2:
				p.setNombre(aValue.toString());
				break;
			case 3:
				p.setPrecio(Double.valueOf(aValue.toString()));
				break;
			case 4:
				p.setStock(Integer.valueOf(aValue.toString()));
				break;
		}
		
		productos.set(rowIndex, p);
		
	}
	
	public Producto getRow(int rowIndex) {
		return productos.get(rowIndex);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
}

	
