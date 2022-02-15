package com.ami.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ami.main.helper.CSVHelper;
import com.ami.main.service.EmployeeService;

@Controller
public class MainController {
	
	@Autowired
	CSVHelper csvHelper;
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/")
	private String home() {
		return "home.html";
	}
	
	@PostMapping("/upload")
	private String uploadFile(@RequestParam("csvFile") MultipartFile csvFile,
			Model model) {
		System.out.println(csvHelper.fileValidator(csvFile));
		if (csvHelper.fileValidator(csvFile)) {
			empService.storeCsv(csvFile);
			model.addAttribute("message", "File successfully uploaded");
		}
		else {
			model.addAttribute("message", "Please select a valid csv file");
		}
		model.addAttribute("status", csvHelper.fileValidator(csvFile));
		
		return "success.html";

	}

}
