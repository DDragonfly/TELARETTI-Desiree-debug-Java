package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * implements the interface that writes the symptoms to a file
 * 
 * The class takes a file path as imput and it writes the content of a map into the file
 * 
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	/**
	 * finds the filepath of the document we want to write into
	 * @param filepath is the file where the symptoms will be written
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}
	/**
	 * tries to write the output file or returns an error message
	 * each symptom is written on a new line with their occurrences
	 * 
	 * @param symptoms containing symptoms names as keys and the occurrences as values
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
