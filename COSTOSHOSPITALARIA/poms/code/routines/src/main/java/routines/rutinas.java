package routines;

import java.util.Calendar;
import java.util.Date;

public class rutinas {

    public static String Semana_Anio_Id(Date date) {
    	
    	Calendar calendar = Calendar.getInstance();
    	    	
    	calendar.setTime(date);
    	
    	//Get of calendar, the weeks of year
    	int semana = calendar.get(Calendar.WEEK_OF_YEAR);
    	int anio = calendar.get(Calendar.YEAR);
    	
    	return (semana < 10)? (anio+"-"+"0"+semana) : (anio+"-"+semana);
    }
    
        
    public static String Day_Week_Id(Date date) {
    	
    	Calendar calendar = Calendar.getInstance();
    	    	
    	calendar.setTime(date);
    	
    	int Day_Week_Id = calendar.get(Calendar.DAY_OF_WEEK);
    	
    	
    	return Integer.toString(Day_Week_Id) ;
    }
    
    
    public static String Quarter(Date date) {
    	
    	int mes = Integer.parseInt(TalendDate.formatDate("MM", date));
    	
    	if(mes <= 3) {
    		return "Trimestre 1";
    	}
    	else if(mes > 3 && mes <= 6) {
    		return "Trimestre 2";
    	}
    	else if(mes > 6 && mes <= 9) {
    		return "Trimestre 3";
    	}
    	else {
    		return "Trimestre 4";
    	}
    	
    }
    
 public static int QuarterId(Date date) {
    	
    	int mes = Integer.parseInt(TalendDate.formatDate("MM", date));
    	
    	if(mes <= 3) {
    		return 1;
    	}
    	else if(mes > 3 && mes <= 6) {
    		return 2;
    	}
    	else if(mes > 6 && mes <= 9) {
    		return 3;
    	}
    	else {
    		return 4;
    	}
    	
    }
    
    
    public static String Semester_Anio(Date date) {
    	int mes = Integer.parseInt(TalendDate.formatDate("MM", date));
    	
    	return (mes < 6)? "Semestre 1" : "Semestre 2";
    }
    
    public static int SemesterId(Date date) {
    	int mes = Integer.parseInt(TalendDate.formatDate("MM", date));
    	
    	return (mes < 6)? 1 : 2;
    }
    
    
    public static String End_Week(Date date) {
    	Calendar calendar = Calendar.getInstance();
    	
    	calendar.setTime(date);
    	
    	int day_Week = calendar.get(Calendar.DAY_OF_WEEK);
    	
    	return (day_Week == 6 || day_Week == 7 || day_Week == 1)? "SI" : "NO";
    }
    
    public static String quincena(Date date) {
    	
    	
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int dayMonth = calendar.get(Calendar.DAY_OF_MONTH);
    	
    	if(dayMonth == 15 || dayMonth == 30) {
    		return "SI";
    	}
    	else {
    		return "NO";
    	}
    }
    
    public static String Leap_Year(Date date) {
    	
    	int anio = Integer.parseInt(TalendDate.formatDate("yyyy", date));
    	
    	return (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0))? "SI" : "NO";
    }
}
