package com.ami.main.helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.ami.main.model.Employee;



@Component
public class CSVHelper {
	
	public boolean fileValidator(MultipartFile file) {
		boolean status = true;
		if (file.isEmpty()) {
			status = false;
		}
		return status;
		
	}
	public List<Employee> processFile(MultipartFile file){
		List<Employee> employees = new ArrayList<Employee>();
//		String message ="";
		String line;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
			line = reader.readLine(); // first line of CSV file;
			while ((line = reader.readLine()) != null) {
				line = line.trim().replace("-", "");
				String[] cols = line.split(",");
				employees.add(new Employee(Integer.parseInt(cols[0]),
						cols[1], 
						cols[2],
						cols[3],
						cols[4],
						cols[5],
						(cols[6]),
						Float.parseFloat(cols[7]),
						Integer.parseInt(cols[8].replace(" ", "000")),
						Integer.parseInt(cols[9].replace(" ", "000")), 
						Integer.parseInt(cols[10].replace(" ", "000"))));
//				System.out.println(line);
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		return employees;
	}

}
