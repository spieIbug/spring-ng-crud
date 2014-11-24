package com.technosofteam.tuto.dao;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technosofteam.tuto.model.Employe;
/**
 * Repository test class
 * We use mockito and TestNg Assertions
 * @author Maamar Yacine MEDDAH
 *
 */
public class EmployeDaoTest {
	
	Employe testEmploye; 
	
	@Mock
	EmployeDao employeDao;
	/**
	 * We insert an employe for test before each test
	 */
	@BeforeMethod
	public void setupTest(){
		// we mock our repository
		employeDao = Mockito.mock(EmployeDao.class);
		// we set a test object
		testEmploye = new Employe(9, "MEDDAH", "Maamar Yacine", 5);
		// we set a test objects list
		List employes = new ArrayList<Object>();
		employes.add(testEmploye);		
		// we force method answer result
		Mockito.when(employeDao.getEmploye(testEmploye.getEmployeId())).thenReturn(testEmploye);
		Mockito.when(employeDao.getAllEmployes()).thenReturn(employes);
	}
	
	@Test
	public void testGetEmployeByIdShouldReturnAnObject(){
		Employe employe = employeDao.getEmploye(9);
		Assert.assertNotNull(employe);
		Assert.assertEquals(employe, testEmploye, "Expecting an object but we get another");		
	}
	
	@Test
	public void testGetEmployeByIdShouldReturnNull(){
		Employe employe = employeDao.getEmploye(15);
		Assert.assertNull(employe);
		Assert.assertNotEquals(employe, testEmploye, "Expecting an object but we get another");		
	}
	
	@Test
	public void testGetAllEmployeShouldReturnAList(){
		List expectedListEmploye = employeDao.getAllEmployes();
		Assert.assertNotNull(expectedListEmploye);
		Assert.assertEquals(expectedListEmploye.size(), 1);
		Assert.assertEquals(expectedListEmploye.get(0), testEmploye, "Expecting an object but we get another");		
	}
	/**
	 * We delete the inserted employe after each test
	 */
	@AfterMethod
	public void resetTest(){
		// No need to do this for this case
	}
}
