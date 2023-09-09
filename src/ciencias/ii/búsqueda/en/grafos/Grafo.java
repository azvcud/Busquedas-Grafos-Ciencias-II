package ciencias.ii.búsqueda.en.grafos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class Grafo {

	protected Hashtable<Nodo, ArrayList<Arista>> tabla;
	protected ArrayList<Arista> aristas;
	protected ArrayList<Nodo> nodos;

	public Grafo() {
		this.tabla = new Hashtable<Nodo, ArrayList<Arista>>();
		this.aristas = new ArrayList<Arista>();
		this.nodos = new ArrayList<Nodo>();
	}

	public void agregarNodo(Nodo nodo) {
		ArrayList<Arista> arr = new ArrayList<Arista>();
		this.tabla.put(nodo, arr);
		this.nodos.add(nodo);
	}

	public void agregarNodos(ArrayList nodos) {
		Iterator nodo = nodos.iterator();
		while (nodo.hasNext())
			this.agregarNodo((Nodo) nodo.next());
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

	// ------------------------------- A* -----------------------------------------
	public ArrayList<Nodo> nodosCercanos(Nodo nodo) {
		ArrayList<Nodo> nodosAdyacentes = new ArrayList<Nodo>();
		for (Arista arista : aristas) {
			if (arista.nodoi.equals(nodo)) {
				nodosAdyacentes.add(arista.nodoi);
				System.out.println("el nodo: " + arista.nodof.nombre + " es adyacente");
			}
			if (arista.nodof.equals(nodo)) {
				nodosAdyacentes.add(arista.nodof);
				System.out.println("el nodo: " + arista.nodoi.nombre + " es adyacente");
			}
		}
		return nodosAdyacentes;
	}

	public ArrayList<Arista> aristasInvolucradas(Nodo nodo) {
		ArrayList<Arista> aristasInvolucradas = new ArrayList<Arista>();
		for (Arista arista : aristas) {
			if (arista.nodoi.equals(nodo)) {
				aristasInvolucradas.add(arista);
			}
			if (arista.nodof.equals(nodo)) {
				aristasInvolucradas.add(arista);
			}
		}
		return aristasInvolucradas;
	}

	public void calcularRuta(Nodo nodoInicial, Nodo nodoDestino) {
		Nodo nodoActual = nodoInicial;
		Nodo siguienteNodo = null;
		Nodo nodoAnterior = null;
		int valorAcumulado = 0;

		while (!nodoActual.equals(nodoDestino)) {
			Arista mejorArista = null;
			ArrayList<Arista> aristasInvolucradas = aristasInvolucradas(nodoActual);
			Iterator<Arista> iterator = aristasInvolucradas.iterator();
			while (iterator.hasNext()) {
				Arista arista = iterator.next();
				if (arista.nodof.equals(nodoAnterior) || arista.nodoi.equals(nodoAnterior)) {
					iterator.remove();
				}
			}
			iterator = aristasInvolucradas.iterator();

			while (iterator.hasNext()) {
				Arista arista = iterator.next();
				Nodo aux, aux2;
				mejorArista = (mejorArista == null) ? arista : mejorArista;
				if (arista.nodof == nodoActual) {
					aux = arista.nodoi;
					System.out.println("---Nodo Aux: " + aux.toString());
				} else {
					aux = arista.nodof;
					System.out.println("---Nodo Aux: " + aux.toString());
				}
				if (mejorArista.nodof == nodoActual) {
					aux2 = mejorArista.nodoi;
					System.out.println("---Nodo Aux2: " + aux2.toString());
				} else {
					aux2 = mejorArista.nodof;
					System.out.println("---Nodo Aux2: " + aux2.toString());
				}
				System.out.println(" //Calculo arista: " + arista.distancia + " + " + aux.distanciaManhattan + " + "
						+ valorAcumulado + " = " + (arista.distancia + aux.distanciaManhattan + valorAcumulado));
				System.out.println(" //Calculo aristaA: " + mejorArista.distancia + " + " + aux2.distanciaManhattan
						+ " + " + valorAcumulado + " = "
						+ (mejorArista.distancia + aux2.distanciaManhattan + valorAcumulado));
				if ((arista.distancia + aux.distanciaManhattan + valorAcumulado) <= (mejorArista.distancia
						+ aux2.distanciaManhattan + valorAcumulado)) {
					mejorArista = arista;
					System.out.println("Posible mejor: " + mejorArista.toString());
				} else {
					System.out.println("Se mantiene la mejor arista anterior");
				}
			}

			System.out.println("mejor arista: " + mejorArista.toString());
			valorAcumulado += mejorArista.distancia;
			System.out.println("Valor acumulado: " + valorAcumulado);
			if (mejorArista.nodof.equals(nodoActual)) {
				siguienteNodo = mejorArista.nodoi;
			} else {
				siguienteNodo = mejorArista.nodof;
			}
			System.out.println("---------------------------");
			nodoAnterior = nodoActual;
			nodoActual = siguienteNodo;
			System.out.println("nodo anterior: " + nodoAnterior.toString());
			System.out.println("nodo actual: " + nodoActual.toString());
		}
	}
	// ------------------------------------------------------------------------

	public int getMaximoNodoX() {
		Iterator<Nodo> nodo = nodos.iterator();
		int max = nodo.next().x;
		while (nodo.hasNext()) {
			int x = nodo.next().x;
			if (max < x)
				max = x;
		}
		return max;
	}

	public int getMaximoNodoY() {
		Iterator<Nodo> nodo = nodos.iterator();
		int max = nodo.next().y;
		while (nodo.hasNext()) {
			int y = nodo.next().y;
			if (max < y)
				max = y;
		}
		return max;
	}

	public int getMininimoNodoX() {
		Iterator<Nodo> nodo = nodos.iterator();
		int min = nodo.next().x;
		while (nodo.hasNext()) {
			int x = nodo.next().x;
			if (min > x)
				min = x;
		}
		return min;
	}

	public double getMinimoNodoY() {
		Iterator<Nodo> nodo = nodos.iterator();
		int min = nodo.next().y;
		while (nodo.hasNext()) {
			int y = nodo.next().y;
			if (min > y)
				min = y;
		}
		return min;
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		Enumeration<Nodo> nodos = this.tabla.keys();
		while (nodos.hasMoreElements()) {
			Nodo nodo = nodos.nextElement();
			s.append(nodo.toString() + "->");
			ArrayList<Arista> adyacencia = this.tabla.get(nodo);
			Iterator<Arista> it = adyacencia.iterator();
			while (it.hasNext()) {
				s.append(it.next().toString());
				if (it.hasNext())
					s.append("-");
			}
			s.append("\n");
		}
		return new String(s);
	}

	public ArrayList<Arista> getAristas() {
		return aristas;
	}

	public ArrayList<Nodo> getNodos() {
		return nodos;
	}

	public Hashtable<Nodo, ArrayList<Arista>> getTabla() {
		return tabla;
	}

}
