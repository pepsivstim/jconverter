package main.java.bv.jodconvert.test;
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.jodconverter.core.document.DefaultDocumentFormatRegistry;
import org.jodconverter.core.document.DocumentFormatRegistry;
import org.jodconverter.core.office.OfficeException;
import org.jodconverter.core.office.OfficeManager;
import org.jodconverter.core.office.OfficeUtils;
import org.jodconverter.local.JodConverter;
import org.jodconverter.local.office.LocalOfficeManager;

public class Converter{
	public Converter(String oldFile, String newFile) throws OfficeException {
		 final LocalOfficeManager.Builder builder = LocalOfficeManager.builder();
			OfficeManager officeManager = LocalOfficeManager.builder().install().officeHome("C:/Program Files/LibreOffice").build();
	        File inputFile = new File(oldFile);
	        File outputFile = new File(newFile);
	        try {
	            //start an office process and connect to the started instance 
	            officeManager.start();
	            // Convert
	            JodConverter.convert(inputFile).to(outputFile).execute();
	        } finally {
	            //stop the office process
	            OfficeUtils.stopQuietly(officeManager);
	        }
		System.out.println("Conversion Complete.");
	}

	public static FileDialog choose(String message) {
		FileDialog dialog = new FileDialog((Frame)null, message);
	  	dialog.setMode(FileDialog.LOAD);
	    dialog.setVisible(true);
	    return dialog;
	}
	
	public static String converted_file(FileDialog dialog, String choice) {
		String[] filename = dialog.getFile().split("\\.");
		return dialog.getDirectory() + "converted_files/" + filename[0]  + choice;
	}
	
	
	public static void convert(FileDialog dialog, String choice) throws OfficeException, IOException {
		//gets just the filename, not the extension
		//splits at period, \\ needed to specify . isn't a special character
		String[] filename = dialog.getFile().split("\\.");
		Converter test = new Converter(dialog.getDirectory() + dialog.getFile(), converted_file(dialog, choice));
	}
}
