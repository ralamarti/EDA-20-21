package clases;

public class Granel extends Producto {

	public float cantidad;
	
	public Granel(int id, String nombre, String category, float precio, float cantidad) {
		super(id, nombre, category, precio);
		this.cantidad = cantidad;
	}
	
	
	
}
