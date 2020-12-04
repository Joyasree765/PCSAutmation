package dao;
import java.util.List;
import model.EmpSkill;


public interface IEmpSkillDao {
	List<EmpSkill> getAllEmpSkills();
	void addEmpSkill(EmpSkill es);
	EmpSkill getEmpSkillById(int id);
	void updateEmpSkill(EmpSkill es);
	void deactivateEmpSkill(EmpSkill es);
	void deleteEmpskill(int id);
	EmpSkill checkLogin(String userId, String password);
	 

}
