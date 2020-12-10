package model;

public class EmpJob {
	private int EJId;
	private  int EmployeeId;
	private int JobId;
	private String Recruited;
	//default constructor methods
	public EmpJob() {
		
	}
	//parameterized constructor method
	public EmpJob(int EmployeeId, int JobId, String Recruited ) {
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
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.EmployeeId = employeeId;
	}
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
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
