package modelo;

public class Arista {

	protected Nodo nodoi;
	protected Nodo nodof;
	protected boolean estaCaido;
	protected int ping;
	private int id;
	static int contador = 0;

	public Arista(Nodo nodoi, Nodo nodof, int ping, boolean estaCaido) {
		this.nodoi = nodoi;
		this.nodof = nodof;
		this.ping = ping;
		this.estaCaido = estaCaido;
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

	public int getPing() {
		return ping;
	}

	public void setPing(int ping) {
		this.ping = ping;
	}

	public void setEstaCaido(boolean estaCaido) {
		this.estaCaido = estaCaido;
	}

	@Override
	public java.lang.String toString() {
		return "Arista{" +
				"nodoi=" + nodoi.getId() +
				", nodof=" + nodof.getId() +
				", estaCaido=" + estaCaido +
				", ping=" + ping +
				", id=" + id +
				'}';
	}
}
