package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * takes the input file and implements the methods from the 
 * two classes to read and write
 * 
 */
public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	/**
	 * set a parameter for reader and writer
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	/**
	 * uses the method from the interface to read the input file
	 * @return
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	/**
	 * transforms the list of strings in a Map to eliminate repetition
	 * and associate a counter for each occurrence of the found symptom
	 * @param symptoms
	 * @return a map with the symptoms and their occurrence
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> mapSymptoms = new HashMap<>();
		for (String i : symptoms) {
			mapSymptoms.put(i, mapSymptoms.getOrDefault(i, 0) + 1);
		}
		
		return mapSymptoms;
	}
	/**
	 * put the elements of the map in alphabetical order
	 * @param symptoms
	 * @return
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		
		TreeMap<String, Integer> orderedMap = new TreeMap<String, Integer>();
		orderedMap.putAll(symptoms);
		return orderedMap;
	}
	/**
	 * write the ordered map in the output file
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
	
}
