package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	public static void main(String[] args) throws IOException {
		int i = 0;
		/*
		 * A TreeMap to count the symptoms
		 */
		TreeMap<String, Integer> symptomsCounter = new TreeMap<>();
		
		/*
		 * Read file symptoms.txt
		 */
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();
		
		/*
		 * Add the symptom to the map and counts occurrences in symptoms.txt
		 * 
		 * @Output number of occurrences
		 */
		while (i< symptoms.size()) {
			symptomsCounter.put(symptoms.get(i),  symptomsCounter.getOrDefault(symptoms.get(i), 0) + 1);
		}
		
		resultWriter writer = new resultWriter("Result.txt");
		writer.writeResult(symptomsCounter);
		
	}
}
