//Drew Ritter
//SWE Java Challenge

import java.util.*;
import java.io.*;


public class WordCount{
	public static void main(String[] args) throws FileNotFoundException{

		//Prompt user for text file to use
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input the name of the text file you would like to "
			+ "run through the word counter: ");
		String fileName = scan.nextLine();
		//Use regex to only look for letters as a word
		Scanner textInput = new Scanner(new File(fileName)).useDelimiter("[^a-zA-Z]+");

		//Use TreeMap to keep in alphabetical order
		Map<String, Integer> wordCounts = new TreeMap<String, Integer>();

		while(textInput.hasNext()){
			//toLowerCase takes into acount that some letters in a word could be 
			//capitalized, most likely at the beginning of a sentence
			String next = textInput.next().toLowerCase();
			if(wordCounts.containsKey(next)){
				wordCounts.put(next, wordCounts.get(next) + 1);
			}
			else{
				wordCounts.put(next, 1);
			}
		}
		for(String word : wordCounts.keySet()){
				int count = wordCounts.get(word);
				System.out.println("'" + word + "' occurs "+ count +  ((count > 1) ? " times" : " time"));
		}
	}
}