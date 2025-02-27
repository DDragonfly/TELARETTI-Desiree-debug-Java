package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> MapSymptoms = new HashMap<>();
		for (String i : symptoms) {
			MapSymptoms.put(i, MapSymptoms.getOrDefault(i, 0) + 1);
		}
		
		return MapSymptoms;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		
		TreeMap<String, Integer> orderedMap = new TreeMap<String, Integer>();
		orderedMap.putAll(symptoms);
		return orderedMap;
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
	
}
