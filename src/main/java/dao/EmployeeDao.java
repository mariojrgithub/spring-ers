package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.EmployeeEntity;
import pojo.EmployeePojo;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{
	
	// select * from employee_details where employee_email = "mario@gmail.com"
	Optional<EmployeeEntity> findByEmployeeEmail(String employeeEmail);
	
	// select * from employee_details where employee_email = "" AND employee_password = "" AND employee_role = ""
	Optional<EmployeeEntity> findEmployee(EmployeePojo employeePojo);

}
