package model;

public class Skill {
	private int skillId;
	private  String skillName;
	private String skillDescription;
	private String Active;	
	//default constructor methods
	public Skill() {
		
	}
	//parameterized constructor method
	public Skill(String skillName, String skillDescription,  String Active) {
		super();
		this.skillName = skillName;
		this.skillDescription = skillDescription;
		this.Active = Active;
		
	}
	//All setter and getter methods
	public int getskillId() {
		return skillId;
	}
	public void setskillId(int skillId) {
		this.skillId = skillId;
	}
	public String getskillName() {
		return skillName;
	}
	public void setskillName(String skillName) {
		this.skillName = skillName;
	}
	public String getskillDescription() {
		return skillDescription;
	}
	public void setskillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String Active) {
		this.Active = Active;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", skillDescription =" + skillDescription + ", Active=" + Active + "]";
	}
	
	


}
