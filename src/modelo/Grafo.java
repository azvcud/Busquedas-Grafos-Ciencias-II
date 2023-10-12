package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Grafo {

	protected HashMap<Nodo, ArrayList<Arista>> tabla;
	protected ArrayList<Arista> aristas;
	private List<Arista> aristasInternasGeneradas = new ArrayList<>();
	private List<Arista> aristasExternasGeneradas = new ArrayList<>();
	protected ArrayList<Nodo> nodos;
	private int numeroNodos = 20;
	private int numeroAristasInternas = 30;
	private int numeroAristasExternas = 20;

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

	public void generarNodos() {
		for (int i = 0; i < numeroNodos; i++) {
			Boolean borde;
			float tiempoProcesamiento;
			Random random = new Random();
			borde = (random.nextInt(2) == 1) ? true : false;
			tiempoProcesamiento = borde ? (float) random.nextInt(151) + 50 : (float) (random.nextInt(91) + 10) / 4;
			Nodo nodo = new Nodo(i * 5, i * 5, borde, tiempoProcesamiento);
			this.agregarNodo(nodo);
			System.out.println(nodo.toString());
		}
	}

	public void generarAristas() {
		Random random = new Random();
		ArrayList<Nodo> nodosBorde = new ArrayList<>();
		ArrayList<Nodo> nodosInternos = new ArrayList<>();
		for (int i = 0; i < numeroNodos; i++) {
			if (nodos.get(i).Borde) {
				nodosBorde.add(nodos.get(i));
			} else {
				nodosInternos.add(nodos.get(i));
			}
		}
		System.out.println("oi! " + nodosInternos.size());
		if (numeroAristasInternas > (nodosBorde.size() * (nodosBorde.size() - 1)) / 2) {
			throw new IllegalArgumentException("Número de aristas demasiado grande");
		}
		while (aristasInternasGeneradas.size() < numeroAristasInternas) {
			int indiceNodoInicial = random.nextInt(nodosBorde.size());
			int indiceNodoFinal = random.nextInt(nodosBorde.size());
			int ping = random.nextInt(30);
			boolean estaCaido = random.nextFloat() * 0.5f > 0.7 ? true : false;
			if (indiceNodoInicial != indiceNodoFinal) {
				Nodo nodoInicial = nodosBorde.get(indiceNodoInicial);
				Nodo nodoFinal = nodosBorde.get(indiceNodoFinal);
				Arista nuevaArista = new Arista(nodoInicial, nodoFinal, ping, estaCaido);
				System.out.println(nuevaArista.toString());
				if (!aristasInternasGeneradas.contains(nuevaArista)) {
					aristasInternasGeneradas.add(nuevaArista);
				}
			}
		}

		if (numeroAristasExternas > nodosBorde.size() * nodosInternos.size()) {
			throw new IllegalArgumentException("Número de aristas demasiado grande");
		}

		while (aristasExternasGeneradas.size() < numeroAristasExternas) {
			int indiceNodoBorde = random.nextInt(nodosBorde.size());
			int indiceNodoInterno = random.nextInt(nodosInternos.size());
			int ping = random.nextInt(251) + 50;
			boolean estaCaido = random.nextFloat() > 0.7 ? true : false;
			Nodo nodoBorde = nodosBorde.get(indiceNodoBorde);
			Nodo nodoInterno = nodosInternos.get(indiceNodoInterno);

			Arista nuevaArista = new Arista(nodoBorde, nodoInterno, ping, estaCaido);
			if (!aristasExternasGeneradas.contains(nuevaArista)) {
				aristasExternasGeneradas.add(nuevaArista);
			}
		}
	}

	public void regenerarValores() {
		Random random = new Random();
		for (int i = 0; i < aristasInternasGeneradas.size(); i++) {
			int ping = random.nextInt(30);
			boolean estaCaido = random.nextFloat() * 0.5f > 0.8 ? true : false;
			aristasInternasGeneradas.get(i).setEstaCaido(estaCaido);
			aristasInternasGeneradas.get(i).setPing(ping);
		}
		for (int i = 0; i < aristasExternasGeneradas.size(); i++) {
			int ping = random.nextInt(251) + 50;
			boolean estaCaido = random.nextFloat() > 0.8 ? true : false;
			aristasExternasGeneradas.get(i).setEstaCaido(estaCaido);
			aristasExternasGeneradas.get(i).setPing(ping);
		}
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