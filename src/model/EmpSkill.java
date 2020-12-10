package model;


public class EmpSkill {
	private int ESId;
	private  int EmployeeId;
	private int SkillId;
	private int ExpYear;
	//default constructor methods
	public EmpSkill() {
		
	}
	//parameterized constructor method
	public EmpSkill(int EmployeeId, int SkillId, int ExpYear ) {
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
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.EmployeeId = employeeId;
	}
	public int getSkillId() {
		return SkillId;
	}
	public void setSkillId(int skillId) {
		this.SkillId = skillId;
	}
	public int getExpYear() {
		return ExpYear;
	}
	public void setExpYear(int expYear) {
		this.ExpYear = expYear;
	}
	@Override
	public String toString() {
		return "EmpSkill [ESId=" + ESId + ", EmployeeId=" + EmployeeId + ","
				+ " SkillId=" + SkillId + ", ExpYear=" + ExpYear
				+ "]" ;
				}
	
}
