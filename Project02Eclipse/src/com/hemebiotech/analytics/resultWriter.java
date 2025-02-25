package com.hemebiotech.analytics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class resultWriter {
	String outputFilePath;
	
	public resultWriter(String filepath) {
		outputFilePath = filepath;
	}

	public void writeResult(TreeMap <String, Integer> inputMap) throws IOException {	
		FileWriter obj = new FileWriter(outputFilePath);
		inputMap.forEach((key, value) -> {
			try {
				obj.write(key + " - " + value + "\n");
					System.out.println(key + " - " + value + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			obj.close();
	}
}

