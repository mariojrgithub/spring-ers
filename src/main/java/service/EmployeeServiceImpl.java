package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmployeeDao;
import dao.RequestDao;
import entity.EmployeeEntity;
import entity.RequestEntity;
import exceptions.SystemException;
import pojo.EmployeePojo;
import pojo.RequestPojo;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	RequestDao requestDao;

	@Override
	public EmployeePojo fetchOneEmployee(String employeeEmail) throws SystemException {
		Optional<EmployeeEntity> optional = employeeDao.findByEmail(employeeEmail);
		EmployeePojo employeePojo = null;
		if(optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
											employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(), employeeEntity.getEmployeeName());
		}
		
		return employeePojo;
	}

	@Override
	public EmployeePojo fetchOneEmployee(int employeeId) throws SystemException {
		Optional<EmployeeEntity> optional = employeeDao.findById(employeeId);
		EmployeePojo employeePojo = null;
		if(optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
											employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(), employeeEntity.getEmployeeName());
		}
		return employeePojo;
	}

	@Override
	public EmployeePojo loginEmployee(EmployeePojo employeePojo) throws SystemException {
		Optional<EmployeeEntity> optional = employeeDao.loginEmployee(employeePojo);
		EmployeePojo employeePojo2 = null;
		if(optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeePojo2 = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
											employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(), employeeEntity.getEmployeeName());
		}
		return employeePojo2;
	}

	@Override
	public List<EmployeePojo> fetchAllEmployees() throws SystemException {
		List<EmployeePojo> allEmployeesPojo = new ArrayList<EmployeePojo>();
		List<EmployeeEntity> allEmployeesEntity = employeeDao.findAll();
		for(EmployeeEntity employeeEntity: allEmployeesEntity) {
			EmployeePojo employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(), employeeEntity.getEmployeeRole(),
														employeeEntity.getEmployeeEmail(), employeeEntity.getEmployeePassword(), employeeEntity.getEmployeeName());
			allEmployeesPojo.add(employeePojo);
		}
		
		return allEmployeesPojo;
	}

	@Override
	public RequestPojo createNewRequest(RequestPojo requestPojo) throws SystemException {
		RequestEntity requestEntity = new RequestEntity(requestPojo.getExpenseId(), requestPojo.getExpenseAmount(), requestPojo.getEmployeeId(), requestPojo.getRequestDate(), 
														requestPojo.getExpenseStatus(), requestPojo.getAdjudicatedDate(), requestPojo.getApproveDeny());
		
		requestDao.saveAndFlush(requestEntity);
		
		requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(), requestEntity.getRequestDate(),
										requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
	
		return requestPojo;
	}

}
