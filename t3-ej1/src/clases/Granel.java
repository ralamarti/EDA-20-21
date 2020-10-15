package clases;

public class Granel extends Producto {

	public double peso;
	
	public Granel(int id, String nombre, double precio, double peso) {
		super(id, nombre, precio);
		this.peso = peso;
	}	

}
