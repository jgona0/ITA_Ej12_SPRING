package com.empleats.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleats.demo.dao.IEmployeesDAO;
import com.empleats.demo.dto.Employees;


// Capa service, donde implementamos los métodos del CRUD que podemos hacer contra bbdd

@Service
public class EmployeesServiceImpl implements IEmployeesService {

	//Utilizamos los metodos JPA de la interface IEmployeesDAO.
	@Autowired
	IEmployeesDAO iEmployeesDAO;
	
	
	@Override
	public Employees createEmployee(Employees employee) {
		return iEmployeesDAO.save(employee);
	}

	@Override
	public List<Employees> getEmployees() {
		return iEmployeesDAO.findAll();
	}

	@Override
	public Employees employeeById(Long id) {		
		return iEmployeesDAO.findById(id).get();	
	}

	@Override
	public List<Employees> employeeByJob(String job) {
		return iEmployeesDAO.findByJob(job);
	}

	@Override
	public Employees updateEmployee(Employees employee) {
		return iEmployeesDAO.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		iEmployeesDAO.deleteById(id);
	}

}
