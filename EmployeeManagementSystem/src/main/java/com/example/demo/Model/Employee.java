package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String employeename;
	
	@Column(name="addres")
	private String address;
	
	@Column(name="mobile")
	private int mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeename=" + employeename + ", address=" + address + ", mobile=" + mobile
				+ "]";
	}

	public Employee(int id, String employeename, String address, int mobile) {
		super();
		this.id = id;
		this.employeename = employeename;
		this.address = address;
		this.mobile = mobile;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
