package Dao;

import java.util.List;
import Model.Student;

public interface DaoStudentI {
	void savaData(Student s);
	void removeByRoll(int rno);
	void updateStudent(int roll, double marks, String name);
	void searchByRoll(int roll);
	void showData();
//	void searchByName(String name);
	void searchHQLName(String name);
	void searchHQLNameMarks(String name, double marks);
	void searchHQLNameMarksData(String name, double marks);
	void removeByRollNo(int rollno);
	void updateByNameRollHQL(int roll, String name);

}
