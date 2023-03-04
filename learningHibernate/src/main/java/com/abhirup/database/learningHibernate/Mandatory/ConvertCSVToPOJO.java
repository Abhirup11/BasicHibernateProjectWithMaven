package com.abhirup.database.learningHibernate.Mandatory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertCSVToPOJO {

	public List<MandatoryHolidayDetails> convertcsvFileToObjects(){
		List<MandatoryHolidayDetails> MandatoryHolidayList = new ArrayList<MandatoryHolidayDetails>();
	    
		try {
			BufferedReader br = new BufferedReader(new 
				FileReader("C:\\Users\\Abhirup Chatterjee\\eclipse-workspace\\learningHibernate\\src\\main\\resources\\mandatoryHolidays.csv"));
		    
			String line;
			try {
				while ((line = br.readLine()) != null) {  
				       // split on comma(',')  
				       String[] manholidayCsv = line.split(",");  

				       // create car object to store values  
				       MandatoryHolidayDetails manholiday = new MandatoryHolidayDetails();  

				       // add values from csv to holiday object  
				       manholiday.setDayOfTheWeek(manholidayCsv[0]);  
				       manholiday.setDate(manholidayCsv[1]); 
				       manholiday.setEvent(manholidayCsv[2].replaceAll("\\s+", " ").substring(5));  
				       

				       // adding holiday objects  to a list  
				       MandatoryHolidayList.add(manholiday);         
				}
			} catch (IOException e) {
				System.out.println("Some IO exception occured ");
				e.printStackTrace();
			} 
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate File ");
			e.printStackTrace();
		}  
		
		return MandatoryHolidayList;
		
	}
}
