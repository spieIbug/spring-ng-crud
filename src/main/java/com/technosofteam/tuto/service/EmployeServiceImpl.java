package com.technosofteam.tuto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technosofteam.tuto.dao.EmployeDao;
import com.technosofteam.tuto.model.Employe;

/**
 * 
 * @author yacmed
 * 
 */
@Service
public class EmployeServiceImpl implements EmployeService {
	@Autowired
	private EmployeDao dao;

	@Transactional
	@Override
	public void add(Employe employe) {
		dao.add(employe);
	}

	@Transactional
	@Override
	public void update(Employe employe) {
		dao.update(employe);
	}

	@Transactional
	@Override
	public void delete(int employeId) {
		dao.delete(employeId);
	}

	@Transactional
	@Override
	public Employe getEmploye(int employeId) {
		return dao.getEmploye(employeId);
	}

	@Transactional
	@Override
	public List<?> getAllEmployes() {
		return dao.getAllEmployes();
	}

	public EmployeDao getDao() {
		return dao;
	}

	public void setDao(EmployeDao dao) {
		this.dao = dao;
	}

}
