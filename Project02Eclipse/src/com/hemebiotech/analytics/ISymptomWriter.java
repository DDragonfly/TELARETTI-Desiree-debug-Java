package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The interface writes the symptom data to an output.
 * the implementation defines how symptoms are written to the destination
 */
public interface ISymptomWriter {
	
	/**
	 * writes the symptoms and their counts in a map containing symptoms names and their occurrences
	 * @param symptoms
	 */
	public void writeSymptoms(Map<String,Integer> symptoms);
}