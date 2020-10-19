package com.empleats.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.empleats.demo.dto.Employees;
import com.empleats.demo.service.EmployeesServiceImpl;


// Capa controller donde la ruta origen será .../api 

@RestController
@RequestMapping("/api")
public class EmployeesController {

	
	@Autowired
	EmployeesServiceImpl employeesServiceImpl;
	
	// CREATE employee
	@PostMapping("/employees")
	public Employees createEmployee(@RequestBody Employees employee) {
		return employeesServiceImpl.createEmployee(employee);
	}
	
	// SELECT todos los employees
	@GetMapping("/employees")
	public List<Employees> getEmployees() {
		return employeesServiceImpl.getEmployees();
	}
	
	// SELECT un employee por id
	@GetMapping("/employees/{id}")
	public Employees employeeById(@PathVariable(name="id") Long id) {
		return employeesServiceImpl.employeeById(id);
	}
	
	// SELECT los employees de un tipo de job
	@GetMapping("/employees/job/{job}")
	public List<Employees> employeeByJob(@PathVariable(name="job") String job) {
		return employeesServiceImpl.employeeByJob(job.toUpperCase());
	}
	
	//UPDATE un employee por id (pasando como parámetro un employee)
	@PutMapping("/employees/{id}")
	public Employees updateEmployee(@PathVariable(name="id")Long id,@RequestBody Employees updt_employee) {
				
		// guardamos en una variable, el employee que queremos actualizar
		Employees select_employee= employeesServiceImpl.employeeById(id);
		System.out.println("Se actualizad el employee: " +select_employee);
		
		//Le setemaos el nuevo nombre y el nuevo job (el salario se seteará acorde al job)
		select_employee.setName(updt_employee.getName());
		select_employee.setJob(updt_employee.getJob());
		
		// asignamos el employee seteado al nuevo
		updt_employee = employeesServiceImpl.updateEmployee(select_employee);
		System.out.println("Por el employee: " +updt_employee);

				
		return updt_employee;
	}
	
	// DELETE un employee por id
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable(name="id")Long id) {
		
		System.out.println("Se borra el employee con id: " +id);
		
		employeesServiceImpl.deleteEmployee(id);
		
		System.out.println("EMPLOYEE BORRADO");

	}	
	
}
