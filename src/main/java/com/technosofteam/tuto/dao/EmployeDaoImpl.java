package com.technosofteam.tuto.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.technosofteam.tuto.model.Employe;
/**
 * Repository implementation
 * @author yacmed
 *
 */
@Repository
public class EmployeDaoImpl implements EmployeDao {
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Employe employe) {
		session.getCurrentSession().save(employe);

	}

	@Override
	public void update(Employe employe) {
		session.getCurrentSession().update(employe);
	}

	@Override
	public void delete(int employeId) {
		session.getCurrentSession().delete(getEmploye(employeId));
	}

	@Override
	public Employe getEmploye(int employeId) {
		return (Employe) session.getCurrentSession().get(Employe.class, employeId);
	}

	@Override
	public List<?> getAllEmployes() {
		return session.getCurrentSession().createQuery("from Employe").list();
	}

}
