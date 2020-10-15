package clases;

public class Unidad extends Producto {

	public int cantidad;
	
	public Unidad(int id, String nombre, double precio, int cantidad) {
		super(id, nombre, precio);
		this.cantidad = cantidad;
	}
	
	

}
