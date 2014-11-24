package com.technosofteam.tuto.service;

import java.util.List;
import com.technosofteam.tuto.model.Employe;

public interface EmployeService {
	public void add(Employe employe);

	public void update(Employe employe);

	public void delete(int employeId);

	public Employe getEmploye(int employeId);

	public List<?> getAllEmployes();
}
