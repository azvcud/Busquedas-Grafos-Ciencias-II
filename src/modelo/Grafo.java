package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {

	protected HashMap<Nodo, ArrayList<Arista>> tabla;
	protected ArrayList<Arista> aristas;
	protected ArrayList<Nodo> nodos;

	public Grafo() {
            this.tabla = new HashMap<>();
            this.aristas = new ArrayList<>();
            this.nodos = new ArrayList<>();
	}

	public void agregarNodo(Nodo nodo) {
		ArrayList<Arista> arr = new ArrayList<>();
		this.tabla.put(nodo, arr);
		this.nodos.add(nodo);
	}

	public boolean agregarArista(Arista arista) {
		if (nodos.contains(arista.nodoi) && nodos.contains(arista.nodof)) {
			ArrayList<Arista> arri = this.tabla.get(arista.nodoi);
			ArrayList<Arista> arrf = this.tabla.get(arista.nodof);
			arri.add(arista);
			arrf.add(arista);
			this.aristas.add(arista);
			return true;
		} else
			return false;
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	public HashMap<Nodo, ArrayList<Arista>> getTabla() {
		return tabla;
	}
}