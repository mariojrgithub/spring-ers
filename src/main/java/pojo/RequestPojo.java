package pojo;

public class RequestPojo {
	
	private int expenseId;
	private long expenseAmount;
	private int employeeId;
	private String requestDate;
	private String expenseStatus;
	private String adjudicatedDate;
	private String approveDeny;
	
	public RequestPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestPojo(int expenseId, long expenseAmount, int employeeId, String requestDate, String expenseStatus,
			String adjudicatedDate, String approveDeny) {
		super();
		this.expenseId = expenseId;
		this.expenseAmount = expenseAmount;
		this.employeeId = employeeId;
		this.requestDate = requestDate;
		this.expenseStatus = expenseStatus;
		this.adjudicatedDate = adjudicatedDate;
		this.approveDeny = approveDeny;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public long getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(long expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public String getExpenseStatus() {
		return expenseStatus;
	}
	public void setExpenseStatus(String expenseStatus) {
		this.expenseStatus = expenseStatus;
	}
	public String getAdjudicatedDate() {
		return adjudicatedDate;
	}
	public void setAdjudicatedDate(String adjudicatedDate) {
		this.adjudicatedDate = adjudicatedDate;
	}

	public String getApproveDeny() {
		return approveDeny;
	}
	public void setApproveDeny(String approveDeny) {
		this.approveDeny = approveDeny;
	}
	@Override
	public String toString() {
		return "RequestPojo [expenseId=" + expenseId + ", expenseAmount=" + expenseAmount + ", employeeId=" + employeeId
				+ ", requestDate=" + requestDate + ", expenseStatus=" + expenseStatus + ", adjudicatedDate="
				+ adjudicatedDate + ", approveDeny=" + approveDeny + "]";
	}
	
	

}
