package main.java.bv.jodconvert.test;

import java.io.*;
import java.util.*;

public class Tools {
	private String text;
	private String[] split_text;
	private File file;
	
	public Tools(File filename) throws IOException {
		this.file = filename;
	    FileInputStream stream = new FileInputStream(file);
	    byte[] bytesArray = new byte[(int)file.length()];
	    stream.read(bytesArray);
	    text = new String(bytesArray);
	    split_text = text.split("\\s+"); //split by any whitespace character (space, enter, tab)
	}
	
	public String get_text() {
		return text;
	}
	
	public int get_wordCount() {
		int word_count = 0;
		//simply counts the number of elements in the split text array
	    for (int i = 0; i < split_text.length; i++) {
	    	word_count = word_count + 1;
	    }
	    return word_count;
	}
	
	public int get_characterCount() {
		//length of byte array
		int character_count = (int)file.length();
		return character_count;
	}
	
	public int get_lineCount() {
		int search_from = 0;
		int counter = 0;
		//counts the number of lines by using indexOf and excluding the latest find
		while(text.indexOf("\n", search_from) != -1) {
			this.text.indexOf("\n", search_from);
			search_from = text.indexOf("\n", search_from) + 2;
			counter = counter + 1;
		}
		return counter;
	}

	public ArrayList<Integer> get_occurence_list(String find) {
		int occurence = 0;
		int search_from = 0;
		ArrayList<Integer> index_list = new ArrayList<Integer>();
		if(!find.equals("")) {
			while(text.indexOf(find, search_from) != -1) {
				index_list.add(text.indexOf(find, search_from));
				search_from = text.indexOf(find, search_from) + find.length();
			}
		}
		return index_list;
	}
	
	public void set_text(String new_text) {
		text = new_text;
	}
	
	public void replace(String original, String replace) {
		String first_half = text.substring(0, text.indexOf(original));
		//second half offset by length of string to not include it
		String second_half = text.substring(text.indexOf(original) + original.length(), text.length());
		text = first_half + replace + second_half;
	}
	
	public void replace_all(String original, String replace) {
		//as long as the match is found, continue replacing
		while(text.indexOf(original) != -1) {
			String first_half = text.substring(0, text.indexOf(original));
			//second half offset by length of string to not include it
			String second_half = text.substring(text.indexOf(original) + original.length(), text.length());
			text = first_half + replace + second_half;
		}
	}
	

	public void write() throws IOException {
		FileWriter myWriter = new FileWriter(file);
	    myWriter.write(text);
	    myWriter.close();
	}
}
