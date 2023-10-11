package modelo;

public class Nodo {
	protected int x;
	protected int y;
	private int id = 0;
	protected boolean Borde;
	protected float tiempoProcesamiento;
	private static int contador = 0;

	public Nodo(int x, int y, boolean Borde, float tiempoProcesamiento) {
		this.x = x;
		this.y = y;
		this.id = Nodo.contador++;
		this.Borde = Borde;
		this.tiempoProcesamiento = tiempoProcesamiento;
	}

	public boolean isBorde() {
		return Borde;
	}

	public void setBorde(boolean borde) {
		Borde = borde;
	}

	public float getTiempoProcesamiento() {
		return tiempoProcesamiento;
	}

	public void setTiempoProcesamiento(int tiempoProcesamiento) {
		this.tiempoProcesamiento = tiempoProcesamiento;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	@Override
	public java.lang.String toString() {
		return "Nodo{" +
				"x=" + x +
				", y=" + y +
				", id=" + id +
				", Borde=" + Borde +
				", tiempoProcesamiento=" + tiempoProcesamiento +
				'}';
	}
}
