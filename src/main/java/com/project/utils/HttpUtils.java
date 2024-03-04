package com.project.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {
	private String value;
	
	public HttpUtils (String value) {
		this.value = value;
	}
	
	public <T> T toObject(Class<T> model) {
		try {
			return new ObjectMapper().readValue(value, model);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static HttpUtils of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new HttpUtils(sb.toString());
	}
	
}
