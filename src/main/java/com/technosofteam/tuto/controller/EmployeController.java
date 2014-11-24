package com.technosofteam.tuto.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.technosofteam.tuto.model.Employe;
import com.technosofteam.tuto.service.EmployeService;

/**
 * Employe controller
 * 
 * @author Maamar Yacine MEDDAH <Technosofteam>
 * 
 */
@Controller
public class EmployeController {
	@Autowired
	private EmployeService employeService;

	/**
	 * This method redirect us to the main page defined in index.html in html
	 * folder this page contains the main menu of the app, wish allows us to
	 * switch between JSP and angular CRUD Technics
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String indexStart() {
		return "redirect:/html/index.html";
	}

	/**
	 * Form initialisation associated to employe.jsp when URL is loaded for the first time
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/employe")
	public String setupForm(Map<String, Object> map) {
		Employe employe = new Employe();
		map.put("employe", employe);
		map.put("employeList", employeService.getAllEmployes());
		return "employe";
	}

	/**
	 * This controller method insert the passed employe in the database
	 * @param employe
	 * @return Employes json list 
	 */
	@RequestMapping(value = "/insert.employe", method = RequestMethod.POST)
	public @ResponseBody
	List<Employe> insertEmploye(@ModelAttribute Employe employe) {
		employeService.add(employe);
		// We get employes list
		List<Employe> allEmployes = (List<Employe>) employeService.getAllEmployes();
		return allEmployes;
	}
	/**
	 * This controller method update the passed employe in the database
	 * @param employe
	 * @return
	 */
	@RequestMapping(value = "/update.employe", method = RequestMethod.POST)
	public @ResponseBody
	List<Employe> updateEmploye(@ModelAttribute Employe employe) {
		employeService.update(employe);
		// We get employes list
		List<Employe> allEmployes = (List<Employe>) employeService.getAllEmployes();
		return allEmployes;
	}
	/**
	 * This controller method delete the passed employe by id in the database
	 * @param employeId
	 * @return Employes json list 
	 */
	@RequestMapping(value="/delete.employe", method = RequestMethod.GET)
	public @ResponseBody List<Employe> deleteEmploye(@RequestParam int employeId){
		employeService.delete(employeId);
		// We get employes list
		List<Employe> allEmployes = (List<Employe>) employeService.getAllEmployes();
		return allEmployes;
	}
	/**
	 * URL call that allows us to list employes in a table associated with angular directive
	 * @return Employes json list
	 */
	@RequestMapping(value = "/list.employes", method = RequestMethod.GET)
	public @ResponseBody
	List<Employe> listEmployes() {
		// We get employes list
		List<Employe> allEmployes = (List<Employe>) employeService
				.getAllEmployes();
		return allEmployes;
	}
	
	/**
	 * This controller method RETURN the passed employe by id in the database
	 * @param employeId
	 * @return Employes json list 
	 */
	@RequestMapping(value="/get.employe", method = RequestMethod.GET)
	public @ResponseBody Employe getEmploye(@RequestParam int employeId){
		return employeService.getEmploye(employeId);
	}

	/**
	 * 
	 * @param employe
	 * @param result
	 * @param action
	 * @param map
	 * @return employe jsp page
	 */
	@RequestMapping(value = "/employe.execute", method = RequestMethod.POST)
	public String doActions(@ModelAttribute Employe employe,
			BindingResult result, @RequestParam String action,
			Map<String, Object> map) {
		Employe employeResult = new Employe();
		switch (action.toLowerCase()) {
		case "add":
			employeService.add(employe);
			employeResult = employe;
			break;
		case "update":
			employeService.update(employe);
			employeResult = employe;
			break;
		case "delete":
			employeService.delete(employe.getEmployeId());
			employeResult = new Employe();
			break;
		case "find":
			Employe searchedEmploye = employeService.getEmploye(employe
					.getEmployeId());
			employeResult = searchedEmploye != null ? searchedEmploye
					: new Employe();
			break;
		}
		map.put("employe", employeResult);
		map.put("employeList", employeService.getAllEmployes());
		return "employe";
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	
}
