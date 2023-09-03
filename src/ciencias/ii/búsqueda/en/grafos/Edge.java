package ciencias.ii.búsqueda.en.grafos;


/**
 * <p>Description: Edge - Non Directed Graph </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Universidad Nacional de Colombia</p>
 * @author Santiago
 * @version 0.1
 */

public class Edge {

	/** Initial node */
	protected Node nodei;
	/** Finish node */
	protected Node nodef;
	/** Id */
	protected int id;
	/** Count of edges */
	static int Cont=0;
	
	/**
	 * Construct
	 * @param nodei
	 * @param nodef
	 */
	public Edge(Node nodei, Node nodef){
		this.nodei = nodei;
		this.nodef = nodef;
		this.id = ++Edge.Cont;
	}
	
	/**
	 * 
	 * @return Identifier of edge
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return Initial node
	 */
	public Node getNodef() {
		return nodef;
	}

	/**
	 * 
	 * @return Final node
	 */
	public Node getNodei() {
		return nodei;
	}

	/**
	 * 
	 * @return length edge
	 */
	public double length(){
		double dx = nodei.x - nodef.x;
		double dy = nodei.y - nodef.y;
		return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
	}
	
	/**
	 * 
	 * @return manhathanlength edge
	 */
	public double manhathanlength(){
		int dx = Math.abs(nodei.x - nodef.x);
		int dy = Math.abs(nodei.y - nodef.y);
		return dx+dy;
	}
	
	@Override
	public String toString(){
		return "Edge:" + this.id + "[" + this.nodei.toString() + "-" + this.nodef.toString() + "]";
	}
	
	/*public EdgePanel getEdgePanel(){
		return new EdgePanel(this);
	}*/
	
}
