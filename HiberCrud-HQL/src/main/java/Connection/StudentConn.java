package Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Student;

public class StudentConn {
	
	public static SessionFactory sessionFactory;
	//creating single object we use static
	//Retreive 
	// static can be changed
	//copy the data of all members
	
	
	StudentConn()
	{
		sessionFactory= new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	}
	public static SessionFactory getSessionFactory() {
		
		StudentConn studentConn=new StudentConn();
		
		return sessionFactory;
	}
	

}
