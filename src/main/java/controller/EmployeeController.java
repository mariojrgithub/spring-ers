package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.SystemException;
import pojo.EmployeePojo;
import pojo.RequestPojo;
import service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	// http://localhost:8080/api/manager/all-employees
	@GetMapping("manager/all-employees")
	List<EmployeePojo> fetchAllEmployees() throws SystemException {
		return employeeService.fetchAllEmployees();
	}
	
	// http:localhost:8080/api/associate/requests/add
	@PostMapping("associate/requests/add")
	RequestPojo createNewRequest(@RequestBody RequestPojo requestPojo) throws SystemException {
		return employeeService.createNewRequest(requestPojo);
	}
}
