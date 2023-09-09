package ciencias.ii.búsqueda.en.grafos.control;

import java.util.ArrayList;
import java.util.Iterator;

import ciencias.ii.búsqueda.en.grafos.modelo.Arista;
import ciencias.ii.búsqueda.en.grafos.modelo.Grafo;
import ciencias.ii.búsqueda.en.grafos.modelo.Nodo;

public class BusquedaA implements Busqueda {

    public ArrayList<Arista> aristasInvolucradas(Grafo g, Nodo nodo) {
        ArrayList<Arista> aristasInvolucradas = new ArrayList<Arista>();
        for (Arista arista : g.getAristas()) {
            if (arista.getNodei().equals(nodo)) {
                aristasInvolucradas.add(arista);
            }
            if (arista.getNodef().equals(nodo)) {
                aristasInvolucradas.add(arista);
            }
        }
        return aristasInvolucradas;
    }

    @Override
    public void obtenerRuta(Grafo g, Nodo nodoInicial, Nodo nodoDestino) {
        Nodo nodoActual = nodoInicial;
        Nodo siguienteNodo = null;
        Nodo nodoAnterior = null;
        int valorAcumulado = 0;

        while (!nodoActual.equals(nodoDestino)) {
            Arista mejorArista = null;
            ArrayList<Arista> aristasInvolucradas = aristasInvolucradas(g, nodoActual);
            Iterator<Arista> iterator = aristasInvolucradas.iterator();
            while (iterator.hasNext()) {
                Arista arista = iterator.next();
                if (arista.getNodef().equals(nodoAnterior) || arista.getNodei().equals(nodoAnterior)) {
                    iterator.remove();
                }
            }
            iterator = aristasInvolucradas.iterator();

            while (iterator.hasNext()) {
                Arista arista = iterator.next();
                Nodo aux, aux2;
                mejorArista = (mejorArista == null) ? arista : mejorArista;
                if (arista.getNodef() == nodoActual) {
                    aux = arista.getNodei();
                    System.out.println("---Nodo Aux: " + aux.toString());
                } else {
                    aux = arista.getNodef();
                    System.out.println("---Nodo Aux: " + aux.toString());
                }
                if (mejorArista.getNodef() == nodoActual) {
                    aux2 = mejorArista.getNodei();
                    System.out.println("---Nodo Aux2: " + aux2.toString());
                } else {
                    aux2 = mejorArista.getNodef();
                    System.out.println("---Nodo Aux2: " + aux2.toString());
                }
                System.out.println(
                        " //Calculo arista: " + arista.getDistancia() + " + " + aux.getDistanciaManhattan() + " + "
                                + valorAcumulado + " = "
                                + (arista.getDistancia() + aux.getDistanciaManhattan() + valorAcumulado));
                System.out.println(
                        " //Calculo aristaA: " + mejorArista.getDistancia() + " + " + aux2.getDistanciaManhattan()
                                + " + " + valorAcumulado + " = "
                                + (mejorArista.getDistancia() + aux2.getDistanciaManhattan() + valorAcumulado));
                if ((arista.getDistancia() + aux.getDistanciaManhattan()
                        + valorAcumulado) <= (mejorArista.getDistancia()
                                + aux2.getDistanciaManhattan() + valorAcumulado)) {
                    mejorArista = arista;
                    System.out.println("Posible mejor: " + mejorArista.toString());
                } else {
                    System.out.println("Se mantiene la mejor arista anterior");
                }
            }

            System.out.println("mejor arista: " + mejorArista.toString());
            valorAcumulado += mejorArista.getDistancia();
            System.out.println("Valor acumulado: " + valorAcumulado);
            if (mejorArista.getNodef().equals(nodoActual)) {
                siguienteNodo = mejorArista.getNodei();
            } else {
                siguienteNodo = mejorArista.getNodef();
            }
            System.out.println("---------------------------");
            nodoAnterior = nodoActual;
            nodoActual = siguienteNodo;
            System.out.println("nodo anterior: " + nodoAnterior.toString());
            System.out.println("nodo actual: " + nodoActual.toString());
        }
    }

}
