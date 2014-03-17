import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Assignment 2 
 * @author Fortune Dederen
 * 16 March 2014
 */

public class Searcher {

	public static void main(String[] args) {
		//integers to track and store keys
		int nameKey = 0;
		int surnameKey = 0;
		//Strings to hold names
		String[] fullName;
		String name;
		String surname;
		//Create instances of BST classes
		surnameSearchTree surnameSearcher = new surnameSearchTree();
		nameSearchTree nameSearcher = new nameSearchTree();
		//Read toSearchIn.txt in
		try {
				BufferedReader searchFor = new BufferedReader(new FileReader("toSearchIn.txt"));
				String line = "";
				while ((line = searchFor.readLine()) != null) {
					nameKey = 0;
					surnameKey = 0;
					fullName = line.split(" ");
					name = fullName[0];
					surname = fullName[1];
					//calculate keys from names
					for (int j = 0; j < surname.length(); j++) {
						surnameKey += (int) surname.charAt(0);
					}
					surnameSearcher.addNode(surnameKey, surname);
					for (int i = 0; i < name.length(); i++) {
						nameKey += (int) name.charAt(0);
					}
					nameSearcher.addNode(nameKey, name);
				}
				searchFor.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found " + e.getMessage());
			} catch (IOException e) {
				System.out.println("unable to read file " + e.getMessage());
			}
		
		//output BST nodes inOrder and postOrder respectively
		System.out.println("Name BST traversed In Order: ");
		surnameSearcher.postOrderTraverse(surnameSearcher.root);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println("Surname BST traversed Post Order: ");
		nameSearcher.inOrderTraverse(nameSearcher.root);

	}

}
