package dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.EmployeeEntity;
import entity.RequestEntity;
import pojo.EmployeePojo;


@Repository
public interface RequestDao extends JpaRepository<RequestEntity, Integer>{
	
	// select * from expense_details where expense_status = "pending"
	Optional<RequestEntity> findPending(String expenseStatus);
	
	// select * from expense_details where expense_status = "resolved"
	Optional<RequestEntity> findResolved(String expenseStatus);
	
	// fetch employee resolved request
	Optional<RequestEntity> findResolvedByEmployee(int employeeId, String expenseStatus);
	
	// fetch employee pending request
	Optional<RequestEntity> findPendingByEmployee(int employeeId, String expenseStatus);
	
	// fetch all employee requests
	Optional<RequestEntity> findRequestByEmployee(int employeeId);

}
