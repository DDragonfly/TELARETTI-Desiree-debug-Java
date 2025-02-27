package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * initialize the objects of the different classes
 * implements the methods of the different classes
 */
public class Main {
	
	public static void main(String[] args) {
	
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		
		/**
		 * implementation of the methods in order
		 */
		List<String> symptoms = counter.getSymptoms();
		Map <String, Integer> myMap = counter.countSymptoms(symptoms);
		Map <String, Integer> orderedMap = counter.sortSymptoms(myMap);
		counter.writeSymptoms(orderedMap);
		System.out.println("Analysis complete, results successfully printed in result.out");
		
	}

}