package com.empleats.demo.service;


import java.util.List;

import com.empleats.demo.dto.Employees;


// En esta interface definimos los métodos que se deberán implementar en el service. Serán las acciones que podemos hacer contra bbdd

public interface IEmployeesService {

	//Metodos del CRUD
	
	public Employees createEmployee(Employees employee); // Crea un empleado
	
	public List<Employees> getEmployees(); //Lista todos los empleados 
	
	public Employees employeeById(Long id); //Leer datos de un empleado (por ID)
	
	public List<Employees> employeeByJob (String job); // Leer datos de empleados (por job)
	
	public Employees updateEmployee(Employees employee); //Actualizar datos de un empleado
	
	public void deleteEmployee(Long id);// Elimina un empleado (por ID)
	
	
}