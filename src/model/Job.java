package model;

public class Job {
	private static int JobId;
	private  String JobTitle;
	private String JobDescription;
	private String companyName;
	private String Location;
	private String keySkill;
	private String salary;
	private String Active;
	//default constructor methods
	public Job() {
		
	}
	//parameterized constructor method
	public Job(String JobTitle, String JobDescription,  String companyName, String Location, String keyskill,String salary, String Active) {
		super();
		this.JobTitle = JobTitle;
		this.JobDescription = JobDescription;
		this.companyName=companyName;
		this.Location=Location;
		this.keySkill=keyskill;
		this.salary=salary;
		this.Active = Active;
		
	}
	//All setter and getter methods
	public static int getJobId() {
		return JobId;
	}
	public void setJobId(int JobId) {
		this.JobId = JobId;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	public void setJobTitle(String JobTitle) {
		this.JobTitle = JobTitle;
	}	
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String JobDescription) {
		this.JobDescription = JobDescription;
	}
	public String getcompanyName() {
		return companyName;
	}
	public void setcompanyName(String companyName) {
		this.companyName= companyName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	public String getkeySkill() {
		return keySkill;
	}
	public void setkeySkill(String keySkill) {
		this.keySkill =keySkill;
	}
	public String getsalary() {
		return salary;
	}
	public void setsalary(String salary) {
		this.salary= salary;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String Active) {
		this.Active = Active;
	}

	@Override
	public String toString() {
		return "Job [JobId=" + JobId + ", JobTitle=" + JobTitle + ", Jobdescription=" + JobDescription + ",companyName=" +companyName
				+ ",Location=" +Location + ",keySkill=" +keySkill + ", salary=" + salary + ", Active=" + Active + "]";
	}
	
	


}
