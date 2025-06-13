package Service;
import java.util.List;
import java.util.Scanner;
import Dao.StudentDao;
import Model.Student;

//take data from the user and connect to backend
public class StudentService {
	Student s;
	StudentDao dao;
	Scanner sc;
	public StudentService() 
	{//Constructor
		s=new Student();
		sc=new Scanner(System.in);
		dao=new StudentDao();
	}
	public void saveService() {
		System.out.print("Enter rollno");
		s.setRollno(sc.nextInt());
		System.out.print("Enter name");
		sc.nextLine();
		s.setName(sc.nextLine());
		System.out.print("Enter Marks");
		s.setMarks(sc.nextDouble());
		
		dao.savaData(s);
		
	}
	
	public void removeData() {
		int rno;
		System.out.print("enter roll no:");
		rno=sc.nextInt();
		dao.removeByRoll(rno);
	}
	
	public void updateService() {
	    System.out.print("Enter roll number: ");
	    int roll = sc.nextInt();

	    System.out.print("Enter new name: ");
	    sc.nextLine(); 
	    String name = sc.nextLine();

	    System.out.print("Enter new marks: ");
	    double marks = sc.nextDouble();

	    dao.updateStudent(roll, marks, name);
	}
	public void searchService() {
	    System.out.print("Enter roll no: ");
	    int roll = sc.nextInt();

	    dao.searchByRoll(roll);
	}

	public void showAll() {
		dao.showData();
	}
//	public void searchByNameService() {
//	    System.out.print("Enter name: ");
//	    String name = sc.next();
//	    dao.searchByName(name);
//	    }
	public void searchByName() {
		 System.out.print("Enter name: ");
		 String name = sc.next();
		 dao.searchHQLName(name);
	}
	public void searchByNameMarks() {
		 System.out.print("Enter name: ");
		 String name = sc.next();
		 System.out.print("Enter marks: ");
		 double marks = sc.nextDouble();
		 dao.searchHQLNameMarks(name,marks);
	}
	public void searchByNameMarksService() {
		 System.out.print("Enter name: ");
		 String name = sc.next();
		 System.out.print("Enter marks: ");
		 double marks = sc.nextDouble();
		 dao.searchHQLNameMarksData(name,marks);
	}
	public void removebyRollHQL() {
		System.out.print("Enter roll number: ");
	    int rollno = sc.nextInt();
	   dao.removeByRollNo(rollno);
	}
	public void updateNR() {
		System.out.print("Enter roll number: ");
	    int rollno = sc.nextInt();
	    sc.nextLine();
	    System.out.print("Enter new name: ");
	    String name = sc.nextLine();
	    dao.updateByNameRollHQL(rollno, name);
		
	}


	}

	

	
