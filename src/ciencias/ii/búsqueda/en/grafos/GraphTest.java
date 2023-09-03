package ciencias.ii.búsqueda.en.grafos;

import java.util.ArrayList;

public class GraphTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		ArrayList<Node> nodes = new ArrayList<Node>();  
		for(int i=0; i<10; i++){
			Node node = new Node(i,i);
			nodes.add(i,node);
		}
		graph.addNode(nodes);
		Edge edge = new Edge(nodes.get(1),nodes.get(2));
		graph.addEdge(edge);
		edge = new Edge(nodes.get(1),nodes.get(3));
		graph.addEdge(edge);
		System.out.println(graph.toString());
	}

}
