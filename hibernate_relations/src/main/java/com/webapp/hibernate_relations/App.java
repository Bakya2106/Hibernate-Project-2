package com.webapp.hibernate_relations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
		
		  LaptopModel lp=new LaptopModel();
		  
		  lp.setLapId(114); 
		  lp.setName("ASus");
		  
		 StudentModel st=new StudentModel();
		  
		  st.setRollno(9); 
		  st.setName("Keerthi"); 
		  st.getLp().add(lp);
		  
		  lp.setSt(st);
		 
    	
    	Configuration cg=new Configuration().configure().addAnnotatedClass(StudentModel.class).addAnnotatedClass(LaptopModel.class);
    	SessionFactory sf=cg.buildSessionFactory();
    	Session s=sf.openSession();
    	s.beginTransaction();
    	s.save(lp);
     	s.save(st);
     	s.getTransaction().commit();
    	s.close();

    	
    	
//-------------------------------Caching concepts-------------------------------------------------------------------
    	
//		Session s1=sf.openSession();
//		s1.beginTransaction();
//		  LaptopModel lp2=null;
//		  
//		  lp2=(LaptopModel)s1.get(LaptopModel.class, 101); 
//		  System.out.println(lp2);
//		 // lp2=(LaptopModel)s.get(LaptopModel.class, 101); //->1st level cache
//		//  System.out.println(st);
//		 
//    	s1.getTransaction().commit();
//    	
//    	s1.close();
    	
//    	
//    	Session s2=sf.openSession();
//    	s2.beginTransaction();
//    	lp2=(LaptopModel)s2.get(LaptopModel.class, 101);
//    	System.out.println(lp2);
//    	s2.getTransaction().commit();
//    	//if we open a session 2nd time, hibernate will hit the db again --> 2nd level cache
//    	
//    	s2.close();
    }
}
