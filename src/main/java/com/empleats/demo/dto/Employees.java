package com.empleats.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



//En esta clase mapeamos las entidades de BBDD para que luego puedan ser utilizadas en java.

@Entity
@Table(name="employees")//en caso que la tabla sea diferente
public class Employees  {
 
	//Atributos de entidad employees
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private Long id;
	@Column(name = "name")//esta anotación no hace falta si se llama igual
	private String name;
	@Column(name = "job")//esta anotación no hace falta si se llama igual
	private String job;
	@Column(name = "salary")//esta anotación no hace falta si se llama igual
	private double salary;
	
	
	//CONSTRUCTORES VACIO Y COMPLETO
	
	public Employees() {
	
	}

	public Employees(Long id, String name, String job) {
		this.id = id;
		this.name = name;
		
		try{
			Job_enum job_enum = Job_enum.valueOf(job.toUpperCase());
			this.job = job_enum.getJob();
			this.salary = job_enum.getSalary();
		}catch(Exception e){
			System.out.println("No se ha podido crear el empleado, el trabajo debe ser EMPLOYEE, MANAGER, BOSS o DIRECTOR");
		}
		
	}

	
	// Clase para el campo Job y Salary que va ligado al mismo. Utiizamos un campo Enum.
	
	private enum Job_enum {
		
		EMPLOYEE("EMPLOYEE", 35000.0), MANAGER("MANAGER", 50000.0), BOSS("BOSS", 60000.0), DIRECTOR("DIRECTOR", 70000.0);
		
		//Variables del enum
		private String job;
		private double salary;

		// constructor
		private Job_enum(String job, double salary) {
			this.job = job;
			this.salary = salary;
		}

		// getters y setters del las variables del enum
		public String getJob() {
			return job;
		}

		public double getSalary() {
			return salary;
		}

	}
	
	
	
	//GETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}
	
	
	// SETTERS
	public void setJob(String job) {
		Job_enum job_enum = Job_enum.valueOf(job.toUpperCase());
		this.job = job_enum.getJob();
		this.salary = job_enum.getSalary();
	}

	public double getSalary() {
		return salary;
	}


	//Metodo impresion de datos por consola ToString
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + name + ", job=" + job + ", salary=" + salary+ "]";
	}
	
	
	
	
	
}
