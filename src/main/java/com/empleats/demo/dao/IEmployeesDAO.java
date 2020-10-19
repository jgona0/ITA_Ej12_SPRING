package com.empleats.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empleats.demo.dto.Employees;


// Interfaz que extiende de JPA, para que la clase del service que le hara el autowired pueda utilizar los métodos JPA
// de acceso a bbdd

public interface IEmployeesDAO extends JpaRepository<Employees, Long>{

	public List<Employees> findByJob(String job); // Select employees por el campo job
	
}