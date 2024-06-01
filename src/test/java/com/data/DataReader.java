package com.data;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public List<HashMap<String, String>> getJsonDatatoMap() throws IOException {

		// Read the Json to String:

		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\data\\SubmitOrder.json"));

		// StandardCharsets.UTF_8);
		// String to HashMap:
		// Jackson Data Bind:

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		// map, map1

		return data;
	}
}
