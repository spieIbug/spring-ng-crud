package com.technosofteam.tuto.controller;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technosofteam.tuto.model.Employe;
import com.technosofteam.tuto.service.EmployeService;

public class EmployeControllerTest {
	Employe testEmploye;

	@Mock
	EmployeService employeSvc;
	EmployeController controller = new EmployeController();
	List employes;

	/**
	 * We insert an employe for test before each test
	 */
	@BeforeMethod
	public void setupTest() {
		// we mock our service
		employeSvc = Mockito.mock(EmployeService.class);
		// we set a test object
		testEmploye = new Employe(9, "MEDDAH", "Maamar Yacine", 5);
		// we set a test objects list
		employes = new ArrayList<Object>();
		employes.add(testEmploye);
		// we force method answer result
		Mockito.when(employeSvc.getEmploye(testEmploye.getEmployeId()))
				.thenReturn(testEmploye);
		Mockito.when(employeSvc.getAllEmployes()).thenReturn(employes);
		// we link our controller to our mocked service layer
		controller.setEmployeService(employeSvc);
	}

	@Test
	public void testInsertEmployeControllerCall() {
		List<Employe> insertedEmployes = controller.insertEmploye(testEmploye);
		Assert.assertNotNull(insertedEmployes);
		Assert.assertEquals(insertedEmployes.size(), 1);
		Assert.assertEquals(insertedEmployes, employes);
	}

	@Test
	public void testListEmployesControllerCall() {
		List<Employe> employesList = controller.listEmployes();
		Assert.assertNotNull(employesList);
		Assert.assertEquals(employesList.size(), 1);
		Assert.assertEquals(employesList, employes);
	}

	@AfterMethod
	public void resetTest() {
		// No need to do this for this case
	}
}
