package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.SystemException;
import pojo.RequestPojo;
import service.RequestService;

@RestController
@RequestMapping("api")
public class RequestController {

	@Autowired
	RequestService requestService;

	// http://localhost:4444/api/manager/requests
	@GetMapping("manager/requests")
	List<RequestPojo> fetchAllRequests() throws SystemException {
		return requestService.fetchAllRequests();
	}

	// http://localhost:4444/api/manager/requests/pending
	@GetMapping("manager/requests/pending")
	List<RequestPojo> fetchPendingRequests() throws SystemException {
		return requestService.fetchPendingRequests();
	}

	// http://localhost:4444/api/manager/requests/pending
	@GetMapping("manager/requests/resolved")
	List<RequestPojo> fetchResolvedRequests() throws SystemException {
		return requestService.fetchResolvedRequests();
	}
	
	// http://localhost:4444/api/manager/requests/{id}
	@GetMapping("manager/requests/{id}")
	RequestPojo fetchOneRequest(@PathVariable("id") int requestId) throws SystemException {
		return requestService.fetchOneRequest(requestId);
	}
	
	// http://localhost:4444/api/associate/requests/{id}
	@GetMapping("associate/requests/{id}")
	List<RequestPojo> fetchEmployeeRequests(@PathVariable("id") int employeeId) throws SystemException {
		return requestService.fetchEmployeeRequests(employeeId);
	}
	
	// http://localhost:4444/api/associate/requests/pending/{id}
	@GetMapping("associate/requests/pending/{id}")
	List<RequestPojo> fetchEmployeePendingRequests(@PathVariable("id") int employeeId) throws SystemException {
		return requestService.fetchEmployeePendingRequests(employeeId);
	}
	
	// http://localhost:4444/api/associate/requests/resolved/{id}
	@GetMapping("associate/requests/resolved/{id}")
	List<RequestPojo> fetchEmployeeResolvedRequests(@PathVariable("id") int employeeId) throws SystemException {
		return requestService.fetchEmployeeResolvedRequests(employeeId);
	}
	
	// http://localhost:4444/api/manager/requests
	@PutMapping("manager/requests")
	RequestPojo updateRequest(@RequestBody RequestPojo requestPojo) throws SystemException {
		return requestService.updateRequest(requestPojo);
	}

}
