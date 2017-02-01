//Drew Ritter
//SWE Java Challenge

//Implementation of GNode
public class Node implements GNode{
	
	private String name;
	private Node[] children;

	//Constructor for Node
	public Node(String name, Node[] children){
		this.name = name;
		this.children = children;
	}

	//Implementing getName() from GNode interface
	public String getName(){
		return name;
	}
	
	//Implementing getChildren() from GNode interface
	public GNode[] getChildren(){
		return children;
	}
}