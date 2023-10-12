/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control.busqueda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import modelo.Arista;
import modelo.Grafo;
import modelo.Nodo;

/**
 *
 * @author amirz
 */
public class AlgoritmoBellmanFord implements Busqueda{

    @Override
    public ArrayList<Arista> obtenerRuta(Grafo g, Nodo nodoInicial, Nodo nodoDestino) {
        LinkedHashMap<Nodo, Integer> pasoBellmanFord = new LinkedHashMap<>();
        HashMap<Nodo, Arista> aristasCandidatas = new HashMap<>();
        ArrayList<Arista> arbolSolucion = new ArrayList<>();
        ArrayList<Arista> aristasNodo;
    
        Arista aristaCandidata;
        Nodo nodoCandidato;
        Nodo nodoActual = nodoInicial;
        int valorMinimo;
        int minimo = 0;
        
        
        return arbolSolucion;
    }
    
}
