package control.busqueda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import modelo.Arista;
import modelo.Grafo;
import modelo.Nodo;

public class AlgoritmoKruskal implements Busqueda {

    @Override
    public ArrayList<Arista> obtenerRuta(Grafo g, Nodo nodoInicial, Nodo nodoDestino) {
        ArrayList<Arista> rutaMinima = new ArrayList<>();
        ArrayList<Arista> todasAristas = new ArrayList<>(g.getAristas());
        HashMap<Nodo, Nodo> papa = new HashMap<>();

        Collections.sort(todasAristas, Comparator.comparingInt(a -> a.getDistancia()));
        for (Nodo nodo : g.getNodos()) {
            papa.put(nodo, nodo);
        }

        for (Arista arista : todasAristas) {
            Nodo nodo1 = arista.getNodei();
            Nodo nodo2 = arista.getNodef();
            Nodo papaNodo1 = buscarPapa(papa, nodo1);
            Nodo papaNodo2 = buscarPapa(papa, nodo2);

            if (papaNodo1 != papaNodo2) {
                rutaMinima.add(arista);
                papa.put(papaNodo1, papaNodo2);
            }
        }
        return rutaMinima;
    }

    private Nodo buscarPapa(HashMap<Nodo, Nodo> papa, Nodo nodo) {
        if (papa.get(nodo) == nodo) {
            return nodo;
        }
        papa.put(nodo, buscarPapa(papa, papa.get(nodo)));
        return papa.get(nodo);
    }

    // Arista de menor peso?
    // Siguiente arista? y siguiente y siguiente...
    // Hay pesos iguales? Si lo hay entonces se toma la que no forma ciclo
    // Repetir hasta que todos los vertices esten tocados por alguna arista

}
