package com.ami.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ami.main.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
