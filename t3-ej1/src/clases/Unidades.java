package clases;

public class Unidades extends Producto {
	
	public int unidades;

	public Unidades(int id, String nombre, String category, float precio, int unidades) {
		super(id, nombre, category, precio);
		this.unidades = unidades;
	}

}
