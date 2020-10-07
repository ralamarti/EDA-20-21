package tools;

public class Punto {
	
	int coordenadaX;
	int coordenadaY;
	int sumaCoordenadas;
	
	public Punto(int coordenadaX, int coordenadaY) {
		this.coordenadaX = coordenadaX;
		this.coordenadaY = coordenadaY;
		this.sumaCoordenadas = sumaCoordenadas();
	}

	public int getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(int coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public int getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(int coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	public int damePuntoX(int a, int b) {
		return 0;
	}
	
	public int sumaCoordenadas() {
		return coordenadaX+coordenadaY;
	}

}

