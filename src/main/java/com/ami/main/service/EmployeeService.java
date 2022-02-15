package com.ami.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ami.main.helper.CSVHelper;
import com.ami.main.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo empRepo;
	@Autowired
	CSVHelper csvHelper;
	
	public void storeCsv(MultipartFile file) {
		empRepo.saveAll(csvHelper.processFile(file));
	}

}
