package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmployeeDao;
import dao.RequestDao;
import entity.RequestEntity;
import exceptions.SystemException;
import pojo.EmployeePojo;
import pojo.RequestPojo;

@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired 
	RequestDao requestDao;
	
	

	public RequestServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RequestPojo> fetchAllRequests() throws SystemException {
		List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
		List<RequestEntity> allRequestsEntity = requestDao.findAll();
		for(RequestEntity requestEntity: allRequestsEntity) {
			RequestPojo requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
														requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
			allRequestsPojo.add(requestPojo);
		}
		
		return allRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchPendingRequests() throws SystemException {
		Optional<RequestEntity> optional = requestDao.findPending("pending");
		List<RequestPojo> allPendingRequestsPojo = new ArrayList<RequestPojo>();
		
		RequestPojo requestPojo = null;
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
					requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
		
			allPendingRequestsPojo.add(requestPojo);
		}
		
		return allPendingRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchResolvedRequests() throws SystemException {
		Optional<RequestEntity> optional = requestDao.findResolved("resolved");
		List<RequestPojo> allResolvedRequestsPojo = new ArrayList<RequestPojo>();
		
		RequestPojo requestPojo = null;
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
					requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
		
			allResolvedRequestsPojo.add(requestPojo);
		}
		
		return allResolvedRequestsPojo;
	}

	@Override
	public List<RequestPojo> fetchEmployeeRequests(int employeeId) throws SystemException {
		Optional<RequestEntity> optional = requestDao.findRequestByEmployee(employeeId);
		List<RequestPojo> allEmployeeRequests = new ArrayList<RequestPojo>();
		
		RequestPojo requestPojo = null;
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
					requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
			
			allEmployeeRequests.add(requestPojo);
		}
		
		return allEmployeeRequests;
	}

	@Override
	public List<RequestPojo> fetchEmployeePendingRequests(int employeeId) throws SystemException {
		Optional<RequestEntity> optional = requestDao.findPendingByEmployee(employeeId, "pending");
		List<RequestPojo> allEmployeePendingRequests = new ArrayList<RequestPojo>();
		
		RequestPojo requestPojo = null;
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
					requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
			
			allEmployeePendingRequests.add(requestPojo);
		}
		
		return allEmployeePendingRequests;
		
		
	}

	@Override
	public List<RequestPojo> fetchEmployeeResolvedRequests(int employeeId) throws SystemException {
		Optional<RequestEntity> optional = requestDao.findResolvedByEmployee(employeeId, "resolved");
		List<RequestPojo> allEmployeeResolvedRequests = new ArrayList<RequestPojo>();
		
		RequestPojo requestPojo = null;
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
					requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
			
			allEmployeeResolvedRequests.add(requestPojo);
		}
		
		return allEmployeeResolvedRequests;
	}

	@Override
	public RequestPojo updateRequest(RequestPojo requestPojo) throws SystemException {
		RequestEntity requestEntity = new RequestEntity(requestPojo.getExpenseId(), requestPojo.getExpenseAmount(), requestPojo.getEmployeeId(),
														requestPojo.getRequestDate(), requestPojo.getExpenseStatus(), requestPojo.getAdjudicatedDate(), requestPojo.getApproveDeny());
	
		requestDao.save(requestEntity);
		
		requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
				requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
	
		return requestPojo;
	}

	@Override
	public RequestPojo fetchOneRequest(int requestId) throws SystemException {
		Optional<RequestEntity> optional = requestDao.findById(requestId);
		RequestPojo requestPojo = null;
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(requestEntity.getExpenseId(), requestEntity.getExpenseAmount(), requestEntity.getEmployeeId(),
					requestEntity.getRequestDate(), requestEntity.getExpenseStatus(), requestEntity.getAdjudicatedDate(), requestEntity.getApproveDeny());
		}
		
		return requestPojo;
	}
	

	
}
