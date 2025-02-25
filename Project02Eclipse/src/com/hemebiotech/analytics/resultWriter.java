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

	public boolean writeResult(TreeMap <String, Integer> inputMap) throws IOException {
		File result = new File(outputFilePath);
		if (result.createNewFile()) {
			FileWriter obj = new FileWriter(outputFilePath);
			inputMap.forEach((key, value) -> {
				try {
					obj.write(key + " - " + value);
					System.out.println(key + " - " + value);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			obj.close();
		}
		return true;
	}
}

