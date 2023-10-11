package modelo;

public class Arista {

	protected Nodo nodoi;
	protected Nodo nodof;
	protected int distancia;
	protected float probabilidadCaida;
	protected int anchoBanda;

	private int id;
	static int contador = 0;

	public Arista(Nodo nodoi, Nodo nodof, int distancia, int anchoBanda, float probabilidadCaida) {
		this.nodoi = nodoi;
		this.nodof = nodof;
		this.distancia = distancia;
		this.anchoBanda = anchoBanda;
		this.probabilidadCaida = probabilidadCaida;
		this.id = Arista.contador++;
	}

	public int getId() {
		return id;
	}

	public Nodo getNodef() {
		return nodof;
	}

	public Nodo getNodei() {
		return nodoi;
	}

	public int getDistancia() {
		return distancia;
	}

	public float getProbabilidadCaida() {
		return probabilidadCaida;
	}

	public void setProbabilidadCaida(float probabilidadCaida) {
		this.probabilidadCaida = probabilidadCaida;
	}

	public int getAnchoBanda() {
		return anchoBanda;
	}

	public void setAnchoBanda(int anchoBanda) {
		this.anchoBanda = anchoBanda;
	}

	@Override
	public java.lang.String toString() {
		return "Arista{" +
				"nodoi=" + nodoi.getId() +
				", nodof=" + nodof.getId() +
				", probabilidadCaida=" + probabilidadCaida +
				", anchoBanda=" + anchoBanda +
				", id=" + id +
				'}';
	}
}
