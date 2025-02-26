package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	public static void main(String[] args) throws IOException {
		int i = 0;
		/**
		 * A TreeMap to count the symptoms
		 */
		TreeMap<String, Integer> symptomsCounter = new TreeMap<>();
		
		/**
		 * Read file symptoms.txt
		 */
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = reader.GetSymptoms();
		
		/**
		 * Add the symptom to the map and counts occurrences in symptoms.txt
		 * 
		 * @Output number of occurrences
		 */
        for (String symptom : symptoms) {
            symptomsCounter.put(symptom, symptomsCounter.getOrDefault(symptom, 0) + 1);
        }
		/*while (i< symptoms.size()) {
			symptomsCounter.put(symptoms.get(i),  symptomsCounter.getOrDefault(symptoms.get(i), 0) + 1);
			i++;
		}*/
        System.out.println("Symptoms:");
        for (Map.Entry<String, Integer> entry : symptomsCounter.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
		/**
		 * Write the ordered symptoms with occurrences in result.out
		 */
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptoms(symptomsCounter);
	}
}
