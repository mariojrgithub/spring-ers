package pojo;

public class EmployeePojo {
	
	private int employeeId;
	private String employeeRole;
	private String employeeEmail;
	private String employeePassword;
	private String employeeName;
	public EmployeePojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeePojo(int employeeId, String employeeRole, String employeeEmail, String employeePassword,
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
		return "EmployeePojo [employeeId=" + employeeId + ", employeeRole=" + employeeRole + ", employeeEmail="
				+ employeeEmail + ", employeePassword=" + employeePassword + ", employeeName=" + employeeName + "]";
	}
	
	

}
