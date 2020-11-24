package model;


public class EmpSkill {
	private int ESId;
	private  String EmployeeId;
	private String SkillId;
	private String ExpYear;
	//default constructor methods
	public EmpSkill() {
		
	}
	//parameterized constructor method
	public EmpSkill(String EmployeeId, String SkillId, String ExpYear ) {
		super();
		this.EmployeeId = EmployeeId;
		this.SkillId = SkillId;
		this.ExpYear = ExpYear;
	}
	//All setter and getter methods
	public int getESId() {
		return ESId;
	}
	public void setESId(int esId) {
		this.ESId = esId;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.EmployeeId = employeeId;
	}
	public String getSkillId() {
		return SkillId;
	}
	public void setSkillId(String skillId) {
		this.SkillId = skillId;
	}
	public String getExpYear() {
		return ExpYear;
	}
	public void setExpYear(String expYear) {
		this.ExpYear = expYear;
	}
	@Override
	public String toString() {
		return "EmpSkill [ESId=" + ESId + ", EmployeeId=" + EmployeeId + ","
				+ " SkillId=" + SkillId + ", ExpYear=" + ExpYear
				+ "]" ;
				}
	
}
