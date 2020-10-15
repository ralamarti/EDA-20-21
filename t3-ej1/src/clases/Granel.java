package clases;

public class Granel extends Producto {

	public double cantidad;
	
	public Granel(int id, String nombre, String category, double precio, double cantidad) {
		super(id, nombre, category, precio);
		this.cantidad = cantidad;
	}
		
}
