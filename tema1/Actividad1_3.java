package pgv.tema1.programaciondeprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

// ---------------------------
 // ACTIVIDADES 1.3 PAGINA 28
 // ---------------------------

public class Actividad1_3 {

	public static void main(String[] command) {
		// TODO Auto-generated method stub
		
		String line;
		
		// preparacion del comando a ejecutar
		
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.redirectErrorStream(true);
		
		try {
			
			// creacion del proceso hijo
			Process shell = pb.start();
			
			// se obtiene el stdout del proceso hijo
			InputStream is = shell.getInputStream();
			
			// se convierte el formato de UTF-8 al de un string de Java
			BufferedReader br = new BufferedReader (new InputStreamReader(is,"UTF-8"));
			
			System.out.println("La salida del proceso hijo "
					+ Arrays.toString(command)
					+ " :");
			
			// se muestra salida del hijo por pantalla
			while( (line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			// cuando finaliza se cierra el descriptor de salida del hijo
			is.close();
			
		}catch(IOException e) {
			
			System.out.println("[x] Error ejecutando el comando."
					+ "\n\tDescripcion: "
					+ e.getMessage() );
		}
		
		
	}

}
