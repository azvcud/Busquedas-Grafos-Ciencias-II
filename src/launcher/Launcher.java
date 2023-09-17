package launcher;

import control.busqueda.AlgoritmoA;
import control.Controlador;
import control.busqueda.Busqueda;
import control.busqueda.AlgoritmoA;
import control.busqueda.AlgoritmoDijkstra;
import java.io.IOException;
import modelo.Grafo;
import vista.interfaz.Mapa_colombia;
import vista.interfaz.SelectorMunicipio;

public class Launcher {

	public static void main(String[] args) throws IOException {
            Busqueda a_Asterisco = new AlgoritmoA();
            Busqueda a_Dijkstra = new AlgoritmoDijkstra();
            
            Grafo grafo = new Grafo();
            Mapa_colombia mapa = new Mapa_colombia();
            SelectorMunicipio selector = new SelectorMunicipio();
            
            Controlador c = new Controlador(a_Dijkstra, grafo, mapa, selector);
            c.iniciar();
	}

}
