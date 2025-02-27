package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * implements the interface
 * 
 * write the content of a map into a file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	/**
	 * finds the filepath of the document we want to write into
	 * @param filepath
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * tries to write the output file or returns an error message
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		try (FileWriter writer = new FileWriter(filepath)) {
			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			}
		}catch (IOException e) {
		System.err.println("Error during file writing: " + e.getMessage());
		}
	}
}
