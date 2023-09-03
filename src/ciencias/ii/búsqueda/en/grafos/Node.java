package ciencias.ii.búsqueda.en.grafos;

/**
 * <p>Description: Node - Non Directed Graph </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Universidad Nacional de Colombia</p>
 * @author Santiago
 * @version 0.1
 */

public class Node{
	
	/** Position x */
	protected int x;
	/** Position y */
	protected int y;
	/** Id */
	protected int id;
	/** Count of nodes */
	static int Cont=0;
	
	/**
	 * Construct
	 * @param x: position in x
	 * @param y: position in y
	 */
	public Node(int x, int y){
		this.x = x;
		this.y = y;
		this.id = ++Node.Cont;
	}
	
	/**
	 * Construct
	 */
	public Node(){
		this(0,0);
	}
	
	/**
	 * 
	 * @return position x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Asign position x
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return position y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Asign position y
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @return Identifier of node
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public String toString(){
		return "Node:" + this.id + "(" + this.x + "," + this.y + ")";
	}
	
        /*
	public NodePanel getNodePanel(){
		return new NodePanel(this);
	}*/
	
}
