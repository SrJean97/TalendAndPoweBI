package routines;

public class usuario {

    public static int validar_edad(String edad) {
    	
    	try {
			int edad_validada = Integer.parseInt(edad);
			return edad_validada;
		} 
    	catch (NumberFormatException e) {
			return 0;
		}
    }
}
