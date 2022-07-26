package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
//import lombok.Data;
//import lombok.ToString;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

//@Data
//@ToString
@Entity
public class Employee_Foram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@NotBlank(message ="Name cannot be empty")
	@NotEmpty(message="Name cannot be empty")
	private String name;
	private Long salary;
	private String department;
	@NotNull(message="Total Experience cannot be empty")
	@Range(min=0, message = "Total Experience should be 0 or more")
	private Integer totalExperience;
	@NotEmpty(message="Designation cannot be empty")
	//@NotBlank(message ="Designation cannot be empty")
	private String designation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Integer getTotalExperience() {
		return totalExperience;
	}
	public void setTotalExperience(Integer totalExperience) {
		this.totalExperience = totalExperience;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee_Foram [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department
				+ ", totalExperience=" + totalExperience + ", designation=" + designation + "]";
	}
	
	
}
