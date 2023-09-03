package ciencias.ii.búsqueda.en.grafos;

import java.util.ArrayList;

public class TestGrafos {

	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		ArrayList<Nodo> nodos = new ArrayList<Nodo>();
		for (int i = 0; i < 10; i++) {
			Nodo nodo = new Nodo(i, i);
			nodos.add(i, nodo);
		}
		grafo.agregarNodos(nodos);
		Arista arista = new Arista(nodos.get(1), nodos.get(2));
		grafo.agregarArista(arista);
		arista = new Arista(nodos.get(1), nodos.get(3));
		grafo.agregarArista(arista);
		System.out.println(grafo.toString());
	}

}
