package com.technosofteam.tuto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author yacmed
 *
 */
@Entity
public class Employe {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autoincrement
	private int employeId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int experience;
	public Employe(int employeId, String firstName, String lastName,
			int experience) {
		super();
		this.employeId = employeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.experience = experience;
	}
	public Employe() {
		super();
	}
	public int getEmployeId() {
		return employeId;
	}
	public void setEmployeId(int employeId) {
		this.employeId = employeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Employe [employeId=" + employeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", experience=" + experience + "]";
	}
	
}
