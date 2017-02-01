//Drew Ritter
//SWE Java Challenge

import java.util.ArrayList;

//This Driver class is where you can test out the two graph functions I have
//implemented. Instantiating a GraphMethods object has a default graph created
//exactly like the example provided in the instructions.  You could also create
//a new graph in this class with the Node(String name, ArrayList<GNode> children)
//class and use the two methods walkGraph(GNode n) and paths(GNode n).
public class GraphMethodsTester{
	public static void main(String[] args){
		GraphMethods g = new GraphMethods();
		//Using a default Node from the GraphMethods constructor
		//Has to be a capital A-J
		Node node = g.getNode("a");

		ArrayList<Node> nodeList = g.walkGraph(node);
		System.out.println("These are all the nodes in the graph or subgraph starting"
		+ " with Node " + node.getName() + " as the root:");
		for(int i = 0; i < nodeList.size(); i++){
			System.out.print(nodeList.get(i).getName());
			if(i < nodeList.size()-1){
				System.out.print(", ");
			}
		}
		System.out.println();

		ArrayList<ArrayList<GNode>> pathsList = g.paths(node);
		System.out.println("These are the possible paths for Node " + node.getName() 
			+ ":");
		for(int i = 0; i < pathsList.size(); i++){
			for(int j = 0; j < pathsList.get(i).size(); j++){
				System.out.print(pathsList.get(i).get(j).getName());
				if(j < pathsList.get(i).size()-1){
					System.out.print("->");
				}
			}
			System.out.println("\n");
		}


		//******New Graph Creation Area******
		Node c = new Node("C", new Node[]{});
		Node b = new Node("B", new Node[]{c});
		Node a = new Node("A", new Node[]{b});

		//******Insert which node you would like to use here*******
		GNode chosenNode = b;

		ArrayList<Node> nodeList2 = g.walkGraph(chosenNode);
		System.out.println("These are all the nodes in the graph or subgraph starting"
		+ " with Node " + chosenNode.getName() + " as the root:");
		for(int i = 0; i < nodeList2.size(); i++){
			System.out.print(nodeList2.get(i).getName());
			if(i < nodeList2.size()-1){
				System.out.print(", ");
			}
		}
		System.out.println();

		ArrayList<ArrayList<GNode>> pathsList2 = g.paths(chosenNode);
		System.out.println("These are the possible paths for Node " + chosenNode.getName() 
			+ ":");
		for(int i = 0; i < pathsList2.size(); i++){
			for(int j = 0; j < pathsList2.get(i).size(); j++){
				System.out.print(pathsList2.get(i).get(j).getName());
				if(j < pathsList2.get(i).size()-1){
					System.out.print("->");
				}
			}
			System.out.println("\n");
		}
	}
}