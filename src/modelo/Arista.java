package modelo;

public class Arista {

	protected Nodo nodoi;
	protected Nodo nodof;
	protected int distancia;
	private int id;
        static int contador = 0;

	public Arista(Nodo nodoi, Nodo nodof, int distancia) {
		this.nodoi = nodoi;
		this.nodof = nodof;
		this.distancia = distancia;
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
        
        @Override
        public String toString() {
            return "Nodo Inicial: " + nodoi.getNombre() + "| Nodo final: " + nodof.getNombre() + "| Distancia: " + distancia;
        }
}
