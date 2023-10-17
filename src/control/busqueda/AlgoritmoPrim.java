package control.busqueda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

import modelo.Arista;
import modelo.Grafo;
import modelo.Nodo;

public class AlgoritmoPrim implements Busqueda {

    @Override
    public ArrayList<Arista> obtenerRuta(Grafo g, Nodo nodoInicial, Nodo nodoDestino) {
        ArrayList<Arista> rutaMinima = new ArrayList<>();
        HashSet<Nodo> visitados = new HashSet<>();
        visitados.add(nodoInicial);

        PriorityQueue<Arista> aristasCandidatas = new PriorityQueue<>(
                (a1, a2) -> Integer.compare(a1.getDistancia(), a2.getDistancia()));
        aristasCandidatas.addAll(g.getTabla().get(nodoInicial));

        while (!aristasCandidatas.isEmpty()) {
            Arista aristaActual = aristasCandidatas.poll();
            Nodo nodo1 = aristaActual.getNodei();
            Nodo nodo2 = aristaActual.getNodef();

            if (!visitados.contains(nodo1) || !visitados.contains(nodo2)) {
                rutaMinima.add(aristaActual);
                Nodo siguienteNodo = visitados.contains(nodo1) ? nodo2 : nodo1;
                visitados.add(siguienteNodo);
                aristasCandidatas.addAll(g.getTabla().get(siguienteNodo));
            }
        }

        return rutaMinima;
    }
}
