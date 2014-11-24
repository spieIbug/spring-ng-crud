package com.technosofteam.tuto.dao;
import java.util.List;

import com.technosofteam.tuto.model.Employe;


public interface EmployeDao {
	public void add(Employe employe);
	public void update(Employe employe);
	public void delete(int employeId);
	public Employe getEmploye(int employeId);
	public List<?> getAllEmployes();

}
