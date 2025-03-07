package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * takes the input file and processes the symptoms data
 * this class reads, counts, sort, write the symptoms
 * it uses the reader and writer implementations
 * 
 */
public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	/**
	 * set a parameter for reader and writer
	 * @param reader implementation of ISymptomReader to read symptoms
	 * @param writer implementation of ISymptomWriter to write symptoms
	 */
	public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	/**
	 * uses the method from the interface to read the input file
	 * @return a list of string with the symptoms
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	/**
	 * transforms the list of strings in a Map
	 * associate a counter for each occurrence of the found symptom
	 * @param symptoms a list of symptoms
	 * @return a map with the symptoms as keys and their occurrence as values
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
	 * @param symptoms a map of symptoms with their occurrences
	 * @return a treemap with the names of the symptoms sorted alphabetically
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		
		TreeMap<String, Integer> orderedMap = new TreeMap<String, Integer>();
		orderedMap.putAll(symptoms);
		return orderedMap;
	}
	/**
	 * write the ordered map in the output file using the writer
	 * @param symptoms a sorted map of symptoms and occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
	
}
