import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * Assignment 1 
 * @author Fortune Dederen
 * 06 March 2014
 */
public class Searcher {
	//Sequential Search Method
	public static void seqSearch(ArrayList<String> searchFor, ArrayList<String> searchIn) {
		//variables to store various comparison times
		double tTime = 0;
		double compTime = 0;
		double startTime = 0;
		double endTime = 0;
		//counter for total comparisons
		int tComp = 0;
		//decimal formatting
		DecimalFormat df = new DecimalFormat("###.##");
		
		//iterating through both arraylists and making comparisons
		tTime = System.nanoTime();
		for (int index = 0; index < searchFor.size(); index++) {
			startTime = System.nanoTime();
			for (int pos = 0; pos < searchIn.size(); pos++) {
				tComp++;
				if (searchIn.get(pos).equals(searchFor.get(index))) {
					endTime = System.nanoTime();
					compTime = (endTime - startTime)/1000000;
					System.out.printf("%20s%10s%10s%10.2f%n", searchIn.get(index), (pos+1), (pos+1), compTime);
					break;
				}
				else if(searchIn.get(pos).charAt(0) > searchFor.get(index).charAt(0)) {
					endTime = System.nanoTime();
					compTime = (endTime - startTime)/1000000;
					System.out.printf("%20s%10s%10s%10.2f%n", searchIn.get(index), "-1", (pos+1), compTime);
					break;
				}
			}
		}
		endTime = System.nanoTime();
		compTime = (endTime - tTime)/10000000;
		System.out.println("Total Comparisons to find mutual friends: " + tComp);
		System.out.println("Total Time to find mutal friends: " + df.format(compTime));
	}
	//Binary Search Method
	public static void binSearch(ArrayList<String> searchFor, ArrayList<String> searchIn) {
	//initial upper and lower variables for binary search
	int high, mid, low = 0;
	//variables to store various comparison times
	double startTime = 0;
	double endTime = 0;
	double compTime = 0;
	double tTime = 0;
	//counter for total comparisons
	int comp = 0, tComp = 0;
	//decimal formatting
	DecimalFormat df = new DecimalFormat("###.###");
	
	//Iterating through both arraylists and making comparisons
	tTime = System.nanoTime();
	for (int index = 0; index < searchFor.size(); index++) {
		startTime = System.nanoTime();
		comp = 0;
		boolean found = false;
		low = 0;
		high = (searchIn.size());
		while (low <= high) {
			tComp += comp;
			mid =  low + (high-low)/2;
			if (searchIn.get(mid).compareTo(searchFor.get(index)) < 0) {
				low  = mid + 1;
				comp++;
			}
			else if (searchIn.get(mid).compareTo(searchFor.get(index)) > 0) {
				high = mid - 1;
				comp++;
			}
			else {
				endTime = System.nanoTime();
				compTime = (endTime - startTime)/10000000;
				System.out.printf("%20s%10s%10s%10.3f%n", searchFor.get(index), (mid+1), comp, compTime);
				found = true;
				break;
			}
		}
		if (found == false) {
			endTime = System.nanoTime();
			compTime = (endTime - startTime)/10000000;
			System.out.printf("%20s%10s%10s%10.3f%n", searchFor.get(index), "-1", comp, compTime);
		}
	}
	endTime = System.nanoTime();
	compTime = (endTime - tTime)/10000000;
	System.out.println("Total Comparisons to find mutual friends: " + tComp);
	System.out.println("Time taken to find mutal friends: " + df.format(compTime));
	}
	public static void main(String[] args) {
		//Arraylists to store searchFor and searchIn files
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> search = new ArrayList<String>();
		//Read toSearchFor.txt in
		try {
			BufferedReader searchFor = new BufferedReader(new FileReader("toSearchFor.txt"));
			String line = "";
			while ((line = searchFor.readLine()) != null) {
				names.add(line);
			}
			searchFor.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println("unable to read file " + e.getMessage());
		}
		//Read toSearchin.txt file in
		try {
			BufferedReader searchIn = new BufferedReader(new FileReader("toSearchIn.txt"));
			String line = "";
			while ((line = searchIn.readLine()) != null) {
				search.add(line);
			}
			searchIn.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println("unable to read file " + e.getMessage());
		}
		//Call Methods and provide suitable output with them
		System.out.println("Sequential Search: ");
		System.out.printf("%20s%10s%10s%10s%n", "Name", "Position", "Comparisons", "Time(ms)");
		seqSearch(names, search);
		System.out.println("\n" + "Binary Search: ");
		System.out.printf("%20s%10s%10s%10s%n", "Name", "Position", "Comparisons", "Time(ms)");
		binSearch(names, search);
	}

}
