package main.java.bv.jodconvert.test;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Merge {
	private File file1;
	private String text1;
	private File file2;
	private String text2;

	
	public Merge(File file1, File file2) throws IOException {
		//creates Documents object with two files
		this.file1 = file1;
		this.file2 = file2;
		
	    FileInputStream stream1 = new FileInputStream(file1);
	    FileInputStream stream2 = new FileInputStream(file2);
	    
	    byte[] bytesArray1 = new byte[(int)file1.length()];
	    stream1.read(bytesArray1);
	    text1 = new String(bytesArray1);
	    
	    byte[] bytesArray2 = new byte[(int)file2.length()];
	    stream2.read(bytesArray2);
	    text2 = new String(bytesArray2);
	}
	
	public void merge(FileDialog dialog) throws IOException {
		FileWriter myWriter = new FileWriter(dialog.getDirectory() + "merged_file.txt");
	    myWriter.write(text1);
	    myWriter.write(text2);
	    myWriter.close();
	}
	

}
