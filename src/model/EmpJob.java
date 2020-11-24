package model;

public class EmpJob {
	private int EJId;
	private  String EmployeeId;
	private String JobId;
	private String Recruited;
	//default constructor methods
	public EmpJob() {
		
	}
	//parameterized constructor method
	public EmpJob(String EmployeeId, String JobId, String Recruited ) {
		super();
		this.EmployeeId = EmployeeId;
		this.JobId = JobId;
		this.Recruited = Recruited;
	}
	//All setter and getter methods
	public int getEJId() {
		return EJId;
	}
	public void setEJId(int ejId) {
		this.EJId = ejId;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.EmployeeId = employeeId;
	}
	public String getJobId() {
		return JobId;
	}
	public void setJobId(String jobId) {
		this.JobId = jobId;
	}
	public String getRecruited() {
		return Recruited;
	}
	public void setRecruited(String recruited) {
		this.Recruited = recruited;
	}
	@Override
	public String toString() {
		return "EmpJob [EJId=" + EJId + ", EmployeeId=" + EmployeeId + ","
				+ " JobId=" + JobId + ",Recruited=" + Recruited
				+ "]" ;
				}
	

}
