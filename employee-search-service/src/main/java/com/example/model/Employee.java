package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
	@Id
	private int eid;
	private String name;
	private String designation;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getdesignation() {
		return designation;
	}
	public void setdesignation(String designation) {
		this.designation = designation;
	}

}
