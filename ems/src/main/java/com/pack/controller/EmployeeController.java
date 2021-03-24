package com.pack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.repository.EmployeeRepository;
import com.pack.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}
	@GetMapping("/addEmployee")
	public String addEmployeePage(Model model) {
		com.pack.model.Employee  employee = new com.pack.model.Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";	
	}
	@PostMapping("/save")
	@PreAuthorize("hasRole('ROLE_ADMIN') && authentication.name=='anil'")
	public String saveEmployee(@ModelAttribute com.pack.model.Employee employee, Model model) {
		com.pack.entity.Employee emp = new com.pack.entity.Employee();
		BeanUtils.copyProperties(employee, emp);
		boolean flag = repository.existsById(emp.getEmpno());
		if(flag==true) {
			model.addAttribute("message", "sorry employee already exists!!!");		
		}
		else {
			repository.save(emp);
			model.addAttribute("message","Employee added successfully");
		}
		return "index";
	}

	
	  @GetMapping("/listEmployees") 
	  public String listEmployees(Model model) {
	  Long time1 = System.currentTimeMillis();
	  List<com.pack.entity.Employee> empList =service.findAllEmps();
	  Long time2 = System.currentTimeMillis();
	  System.out.println("Time taken to list employees:"+(time2-time1));
	  model.addAttribute("employees", empList);
	   return "employeeList";
	 }
	 
	/*
	 * @GetMapping("listEmployees") 
	 * public String listEmployees(Model model) {
	 *  Long time1 = System.currentTimeMillis(); 
	 *  List<com.pack.entity.Employee> empList =service.findAllEmps(); 
	 *  Long time2 = System.currentTimeMillis();
	 * System.out.println("Time taken to list employees:"+(time2-time1));
	 * model.addAttribute("employees",empList); return "employeeList";
	 * 
	 * }
	 */
	@GetMapping("/deleteEmployee")
	@PreAuthorize("hasRole('ROLE_ADMIN') && authentication.name=='anil'")
	public String deleteEmployee(@RequestParam("empno") Integer empno, Model model) {
		 repository.deleteById(empno);
		 List<com.pack.entity.Employee> empList = repository.findAll();
		 model.addAttribute("employees",empList);
		 return "employeeList";
	}
	@GetMapping("/editEmployee")
	public String getEditEmployeePage(@RequestParam("empno") Integer empno, Model model) {
		Optional<com.pack.entity.Employee> opt = repository.findById(empno);
		com.pack.entity.Employee employee =opt.get();
		com.pack.model.Employee modelEmployee = new com.pack.model.Employee();
		BeanUtils.copyProperties(employee, modelEmployee);
		model.addAttribute("employee",modelEmployee);
		return "editEmployee";		
	}
	@PostMapping("/update")
	public String updatEmployee(@ModelAttribute("employee")com.pack.model.Employee modelEmployee, Model model) {
		com.pack.entity.Employee entityEmployee = new com.pack.entity.Employee();
		BeanUtils.copyProperties(modelEmployee, entityEmployee);
		repository.save(entityEmployee);
		return "redirect:listEmployees";
		
	}
	 @GetMapping("/search")
	public String searchEmployeeByDept(@RequestParam("deptno") Integer deptno, Model model) {
		if(deptno==null) {
			return "redirect:listEmployees";		
		}
		List<com.pack.entity.Employee> empList =repository.findByDeptno(deptno);
		model.addAttribute("employees",empList);
		return "employeeList";
	}
	 @PostMapping("/accessDenied")
	 public String accessDeniedPage() {
		 return "accessDenied";
	 }
	 @PostMapping("/405")
	 public String accessDenied() {
		 return "405";
	 }

	 @GetMapping("/login")
	 public String getLoginPage(@RequestParam (value="msg",required=false) String message, Model model) {
		 if(message!=null) {
			 model.addAttribute("message",message);
		 }
		 return "myLogin";
	 }
	 @GetMapping("/loggedout")
	 public String loggedOutUser() {
		 return "logoutPage";
	 }
		
}