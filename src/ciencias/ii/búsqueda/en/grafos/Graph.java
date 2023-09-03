package ciencias.ii.búsqueda.en.grafos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * <p>Description: Data Structure - Non Directed Graph </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Universidad Nacional de Colombia</p>
 * @author Santiago
 * @version 0.1
 */

public class Graph{
	
	/** Adjacency list */
	protected Hashtable<Node,ArrayList<Edge>> table;
	protected ArrayList<Edge> edges;
	protected ArrayList<Node> nodes;
	
	/**
	 * Construct
	 * @param table: Adjecency list
	 */
	public Graph(){
		this.table = new Hashtable<Node,ArrayList<Edge>>();
		this.edges = new ArrayList<Edge>();
		this.nodes = new ArrayList<Node>();
	}
	
	/**
	 * Addition node
	 * @param node: node to addition
	 */
	public void addNode(Node node){
		ArrayList<Edge> arr = new ArrayList<Edge>();
		this.table.put(node, arr);
		this.nodes.add(node);
	}
	
	/**
	 * Addition nodes
	 * @param nodes: nodes to addition
	 */
	public void addNode(ArrayList nodes){
		Iterator node = nodes.iterator();
		while(node.hasNext())
			this.addNode((Node)node.next());
	}
	
	/**
	 * Addition edge
	 * @param edge: edge to addition
	 */
	public boolean addEdge(Edge edge){
		if(nodes.contains(edge.nodei) && nodes.contains(edge.nodef)){
			ArrayList<Edge> arri = this.table.get(edge.nodei);
			ArrayList<Edge> arrf = this.table.get(edge.nodef);
			arri.add(edge);
			arrf.add(edge);
			this.edges.add(edge);
			return true;
		}else return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getMaxXNode(){
		Iterator<Node> node = nodes.iterator();
		int max = node.next().x;
		while(node.hasNext()){
			int x = node.next().x;
			if(max < x) max = x;
		}
		return max;
	}

	/**
	 * 
	 * @return
	 */
	public int getMaxYNode(){
		Iterator<Node> node = nodes.iterator();
		int max = node.next().y;
		while(node.hasNext()){
			int y = node.next().y;
			if(max < y) max = y;
		}
		return max;
	}

	/**
	 * 
	 * @return
	 */
	public int getMinXNode(){
		Iterator<Node> node = nodes.iterator();
		int min = node.next().x;
		while(node.hasNext()){
			int x = node.next().x;
			if(min > x) min = x;
		}
		return min;
	}
	
	/**
	 * 
	 * @return
	 */
	public double getMinYNode(){
		Iterator<Node> node = nodes.iterator();
		int min = node.next().y;
		while(node.hasNext()){
			int y = node.next().y;
			if(min > y) min = y;
		}
		return min;
	}
	
	@Override
	public String toString(){
		StringBuffer s = new StringBuffer();
		Enumeration<Node> nodes = this.table.keys();
		while(nodes.hasMoreElements()){
			Node node = nodes.nextElement();
			s.append(node.toString() + "->");
			ArrayList<Edge> adjacency = this.table.get(node);
			Iterator<Edge> it = adjacency.iterator();
			while(it.hasNext()){
				s.append(it.next().toString());
				if(it.hasNext()) s.append("-");
			}
			s.append("\n");
		}
		return new String(s);
	}

	/**
	 * 
	 * @return list of esdges
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}

	/**
	 * 
	 * @return list of nodes
	 */
	public ArrayList<Node> getNodes() {
		return nodes;
	}

	/**
	 * 
	 * @return Adjacency list of non directed  graph
	 */
	public Hashtable<Node, ArrayList<Edge>> getTable() {
		return table;
	}

}
