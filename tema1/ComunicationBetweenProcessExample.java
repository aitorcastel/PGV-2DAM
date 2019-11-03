package pgv.tema1.programaciondeprocesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ComunicationBetweenProcessExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Process process = new ProcessBuilder(args).start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		
		System.out.println("Salida del proceso "
				+ Arrays.toString(args)
				+ " :");
		
		while( (line = br.readLine() ) != null ) {
			System.out.println(line);
			
		}
		
	}

}
