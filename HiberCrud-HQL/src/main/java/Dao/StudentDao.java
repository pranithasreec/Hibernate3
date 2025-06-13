package Dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Connection.StudentConn;
import Model.Student;
public class StudentDao implements DaoStudentI {

	SessionFactory factory;
	public StudentDao()
	{
		factory=StudentConn.getSessionFactory();
	}
	public void savaData(Student s) {
		Session session=factory.openSession();
		Transaction txt=session.beginTransaction();
		session.save(s);
		txt.commit();
	}
	@Override
	public void removeByRoll(int rno) {
		Session session=factory.openSession();
		Transaction txt=session.beginTransaction();
		Student s=session.find(Student.class, rno);
		if(s==null) {
			System.out.println("Not found");		
		}else {
			session.delete(s);	
		}
		txt.commit();
		
	}
	@Override
	public void updateStudent(int roll,double marks,String name) {
		Session session = factory.openSession();
	    Transaction txt = session.beginTransaction();
	    Student s=session.get(Student.class, roll);
	    if(s==null) {
	    	System.out.println("Not found");
	    }else {
	    	s.setName(name);
	        s.setMarks(marks);
	    	session.update(s);
	    }
	    txt.commit();	    
	}
	@Override
	public void searchByRoll(int roll) {
	    Session session = factory.openSession();
	    Transaction txt = session.beginTransaction();
	    Student s = session.get(Student.class, roll);
	    if(s==null) {
	    	System.out.println("Not found");
	    }else {
	    	
	    	System.out.println(s.getRollno());
	        System.out.println(s.getName());
	        System.out.println(s.getMarks());
	    }
	    txt.commit();	    
	}
	@Override
	public void showData() {
		Session session = factory.openSession();
		//We are executing the list command
		// Query class has one fun which is list
		Query<Student> query=session.createQuery("from Student");
		//Concept: Pagination
		query.setFirstResult(0);
		query.setMaxResults(3);
		List<Student> students=query.list();
		for(Student s:students) {
			System.out.println(s.toString());
		}
		
	}
//	@Override
//	public void searchByName(String name) {
//	    Session session = factory.openSession();
//	    Query<Student> query = session.createQuery("FROM Student WHERE name = :studentName" );
//	    query.setParameter("studentName", name);
//	    List<Student> students = query.list();
//	        if (students.isEmpty()) {
//	            System.out.println("Not Found");
//	        } else {
//	            for (Student s : students) {
//	            	 System.out.println(s.getRollno());
//	                 System.out.println(s.getName());
//	                 System.out.println(s.getMarks());
//	            }
//	        }
	
	@Override
	public void searchHQLName(String name) {
		Session session = factory.openSession();
		Query <Student> Q=session.createQuery("from Student where name=:name",Student.class);
		Q.setParameter("name", name);
		List<Student> usersList=Q.list();
		for(Student u:usersList)
		{
			System.out.println(u.toString());
		}
	}
	@Override
	public void searchHQLNameMarks(String name,double marks) {
		Session session = factory.openSession();
		Query <Student> Q=session.createQuery("from Student where name=:name and marks=:marks",Student.class);
		Q.setParameter("name", name);
		Q.setParameter("marks", marks);
		List<Student> usersList=Q.list();
		for(Student u:usersList)
		{
			System.out.println(u.toString());
		}
	}
	@Override
	public void searchHQLNameMarksData(String name, double marks) {

	    Session session = factory.openSession();
	    Query<Student> query = session.createQuery(
	        "from Student where name = :name and marks > :marks", Student.class);
	    query.setParameter("name", name);
	    query.setParameter("marks", marks);
	    List<Student> usersList = query.list();
	    usersList.stream()
	             .forEach(student -> System.out.println(student.toString()));
	}
	public void removeByRollNo(int rollno) {
		Session session = factory.openSession();
		Transaction txt=session.beginTransaction();
		Query <Student> Q=session.createQuery("delete from Student where rollno=:rollno");
		Q.setParameter("rollno", rollno);
		int r=Q.executeUpdate();
		if(r>0) {
			System.out.println("Removed");
		}else {
			System.out.println("Not Removed");
		}
		txt.commit();
	}
	public void updateByNameRollHQL(int roll, String name) {
	    Session session = factory.openSession();
	    Transaction txt = session.beginTransaction(); 
	    Query<Student> q = session.createQuery("update Student set name = :name where rollno = :roll");
	    q.setParameter("name", name);
	    q.setParameter("roll", roll);
	    int r = q.executeUpdate();
	    if (r > 0) {
	        System.out.println("Updated");
	    } else {
	        System.out.println("Not Updated");
	    }
	    
	    txt.commit();
	}

	

}



