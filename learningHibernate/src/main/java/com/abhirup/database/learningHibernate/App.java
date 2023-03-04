package com.abhirup.database.learningHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abhirup.database.learningHibernate.Mandatory.ConvertCSVToPOJO;
import com.abhirup.database.learningHibernate.Mandatory.MandatoryHolidayDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
	   
	   //Student sd=new Student(132,"Abhirup","Asansol");
	   //saveStudentbjectToDb(sd);
	   List<MandatoryHolidayDetails> listOfMandatoryHolidays = new ConvertCSVToPOJO().convertcsvFileToObjects();
	   listOfMandatoryHolidays.stream().forEach(System.out::println);
	   saveMandatoryHolidayListToDb(listOfMandatoryHolidays);
	   System.out.println("Holidays added to db successfully!");
    }

	private static void saveStudentbjectToDb(Student sd) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(sd);
		tx.commit();
	}
	
	private static void saveMandatoryHolidayListToDb(List<MandatoryHolidayDetails> listOfMandatoryHolidays) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		for(MandatoryHolidayDetails Holiday : listOfMandatoryHolidays) {
			Transaction tx = session.beginTransaction();
			session.save(Holiday);
			tx.commit();
		}
		session.close();
	}
}
