package ciencias.ii.búsqueda.en.grafos;

public class Arista {

	protected Nodo nodoi;
	protected Nodo nodof;
	protected int id;
	static int Cont = 0;

	public Arista(Nodo nodoi, Nodo nodof) {
		this.nodoi = nodoi;
		this.nodof = nodof;
		this.id = ++Arista.Cont;
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

	public double distancia() {
		double dx = nodoi.x - nodof.x;
		double dy = nodoi.y - nodof.y;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}

	public double distanciaManhathan() {
		int dx = Math.abs(nodoi.x - nodof.x);
		int dy = Math.abs(nodoi.y - nodof.y);
		return dx + dy;
	}

	@Override
	public String toString() {
		return "Arista:" + this.id + "[" + this.nodoi.toString() + "-" + this.nodof.toString() + "]";
	}
}
