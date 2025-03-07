package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The interface writes the symptom data to an output.
 * the implementation defines how symptoms are written to the destination
 */
public interface ISymptomWriter {
	
	/**
	 * writes the symptoms and their counts in a map containing symptoms names
	 * and their occurrences. The map keys represent a symptom and the value is 
	 * the number of occurrences
	 * @param symptoms that's a map containing symptoms (string) and their occurrences (int)
	 */
	public void writeSymptoms(Map<String,Integer> symptoms);
}