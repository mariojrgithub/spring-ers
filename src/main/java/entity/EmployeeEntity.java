package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "employee_details")
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "employee_role")
	private String employeeRole;
	
	@Column(name = "employee_email")
	private String employeeEmail;
	
	@Column(name = "employee_password")
	private String employeePassword;
	
	@Column(name = "employee_name")
	private String employeeName;

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(int employeeId, String employeeRole, String employeeEmail, String employeePassword,
			String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeRole = employeeRole;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", employeeRole=" + employeeRole + ", employeeEmail="
				+ employeeEmail + ", employeePassword=" + employeePassword + ", employeeName=" + employeeName + "]";
	}

	
}
