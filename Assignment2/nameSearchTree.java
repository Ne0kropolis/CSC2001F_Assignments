
/**
 * Assignment 2: name binary search tree 
 * @author Fortune Dederen
 * 16 March 2014
 */

public class nameSearchTree {
	
	Node root;
	
	//method for adding nodes to the tree
	public void addNode(int key, String name){
		Node newNode = new Node(key, name);
		
		//check if the newNode is our root node
		if (root == null) {
			root = newNode;
		}
		else {
			Node focusNode = root;
			
			Node parent;
			
			//loop to determine where to place the newNode
			while (true) {
				parent = focusNode;
				
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} 
				else if (key > focusNode.key) {
					focusNode = focusNode.rightChild;
					
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
				else {
					parent.counter++;
					return;
				}
			} // end of loop
		}
	} // end of addNode
	
	//Method for inOrder traversing of the tree
	public void inOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			
			inOrderTraverse(focusNode.leftChild);
			
			System.out.println(focusNode);
			
			inOrderTraverse(focusNode.rightChild);
		}
	}
}

class Node {
	int key;
	String name;
	int counter;
	
	Node leftChild;
	Node rightChild;
	
	//Constructor for Node class
	Node(int key, String name){
		this.key = key;
		this.name = name;
		this.counter = 1;
	}
	
	public String toString(){
		return ("Key: " + key + " Name: " + name + " Count: " + counter);
	}
}
