package ciencias.ii.búsqueda.en.grafos.control;

import ciencias.ii.búsqueda.en.grafos.modelo.Grafo;
import ciencias.ii.búsqueda.en.grafos.modelo.Nodo;

public interface Busqueda {
    public void obtenerRuta(Grafo g, Nodo nodoInicial, Nodo nodoDestino);
}
