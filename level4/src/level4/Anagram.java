package level4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Anagram {

ArrayList<String> organizer = new ArrayList<String>();


	
public static void main(String[] args) {
	Anagram running = new Anagram();
	String word = JOptionPane.showInputDialog(null, "What is your favorite word?");
	String alphaWord = running.alphabetize(word);
	ArrayList<String> matching = new ArrayList<String>();
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/level4/dictionary.txt"));
		
		String line = br.readLine();
		while(line != null){
			//System.out.println(running.alphabetize(line));
			String newLine = running.alphabetize(line);
			//System.out.println(newLine);
		if(newLine.equals(alphaWord)) {
			matching.add(line);
		}else {
			
		}
	

			line = br.readLine();
		}		
		
				br.close();
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println(matching);
//System.out.println(matching);
	
	
}

public String alphabetize(String a) {
String b = a.toLowerCase();
for (int i = 0; i < b.length(); i++) {
String letter = "" + b.charAt(i);
	organizer.add(letter);
}
for (int j = 0; j < organizer.size(); j++) {
for (int i = 0; i < organizer.size() - 1; i++) {
String first = organizer.get(i);
String second = organizer.get(i+1);
if(organizer.get(i).compareTo(organizer.get(i+1)) >= 0) {
organizer.remove(i);
organizer.add(i, second);
organizer.remove(i+1);
organizer.add(i+1, first);
}
}
}
//System.out.println(organizer);
String alpha = "";
for (int i = 0; i < organizer.size(); i++) {
alpha += organizer.get(i);
}
String alphaB = alpha;
organizer.clear();
return alphaB;

}

}
