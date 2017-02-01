//Drew Ritter
//SWE Java Challenge

import java.util.ArrayList;

public class GraphMethods{
	
	Node a, b, c, d, e, f, g, h, i, j;

	//Constructor to generate default graph
	public GraphMethods(){
		//Build graph from the ground up to root node "A"
		e = new Node("E", new Node[]{});
		f = new Node("F", new Node[]{});
		g = new Node("G", new Node[]{});
		h = new Node("H", new Node[]{});
		i = new Node("I", new Node[]{});
		j = new Node("J", new Node[]{});

		b = new Node("B", new Node[]{e, f});
		c = new Node("C", new Node[]{g, h, i});
		d = new Node("D", new Node[]{j});
		a = new Node("A", new Node[]{b, c, d});
	}

	//Returns a List of Nodes in the Graph(no duplicate entries)
	public ArrayList walkGraph(GNode node){
		ArrayList nodeList = new ArrayList();
		ArrayList childList = new ArrayList();
		childList.add(node);
		Node current;

		while(!childList.isEmpty()){
			//Similar to popping Node off Stack in DFS
			current = (Node) childList.remove(0);

			//Makes sure there are no duplicate entries
			if(!nodeList.contains(current)){
				nodeList.add(current);
			}

			//Goes down the graph and adds all current node's children to childList
			//This ensures that every node is visited.
			if(current.getChildren().length > 0){
				for(int i = 0; i < current.getChildren().length; i++){
					if(!childList.contains(current.getChildren()[i])){
						childList.add(current.getChildren()[i]);
					}
				}
			}
		}

		return nodeList;
	}


	//Returns a list of paths(also in the form of a list) from a starting node
	public ArrayList paths(GNode node){
		ArrayList<ArrayList<GNode>> pathsList = new ArrayList<ArrayList<GNode>>();
		Node current = (Node) node;

		if(current.getChildren().length > 0){
			for(GNode child : current.getChildren()){
				//Recurse through all possible child nodes and start adding leaf children 
				//to one path list, which gets added to the list of paths
				pathsList.addAll(paths(child));
			}

			//Once recursive calls wind back up the stack, add the nodes
			//to the path as you work your way back up
			for(ArrayList<GNode> path : pathsList){
				//add to front of path because we are working back up stack
				path.add(0, current);
			}
		} 

		//reached a leaf node so add last node as a new path
		else{
			ArrayList<GNode> newPath = new ArrayList<GNode>();
			newPath.add(current);
			pathsList.add(newPath);
		}

		return pathsList;
	}

	//returns default graph's nodes
	public Node getNode(String nodeChoice){
		if(nodeChoice.equals("A"))
			return a;
		else if(nodeChoice.equals("B"))
			return b;
		else if(nodeChoice.equals("C"))
			return c;
		else if(nodeChoice.equals("D"))
			return d;
		else if(nodeChoice.equals("E"))
			return e;
		else if(nodeChoice.equals("F"))
			return f;
		else if(nodeChoice.equals("G"))
			return g;
		else if(nodeChoice.equals("H"))
			return h;
		else if(nodeChoice.equals("I"))
			return i;
		else if(nodeChoice.equals("J"))
			return j;

		else
			System.out.println("You're choices are just capital A-J, but here is A anyways.");
			return a;
	}
}