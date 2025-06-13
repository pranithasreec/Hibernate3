package com.hibernate.HiberCrud_HQL;
import Service.StudentService;
public class App 
{
    public static void main( String[] args )
    {
    	StudentService service=new StudentService();
//service.saveService();
//    	service.removeData();
//    	service.updateService();
//    	service.searchService();
 	service.showAll();
//    	service.searchByNameService();
//   	service.searchByName();
//    	service.searchByNameMarks();
//    	service.searchByNameMarksService();
//    	service.removebyRollHQL();
//    	service.updateNR();
        System.out.println( "Done!LA!LA!LA" );
    }
}
