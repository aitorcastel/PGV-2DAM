package pgv.tema1.programaciondeprocesos;

import java.io.IOException;
import java.util.Arrays;

public class ProcessBuilderExample {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		if( args.length <= 0) {
			
			System.err.println("[x] Se necesita programa para ejecutar");
			System.exit(-1);
			
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		
		try {
			
			Process process = pb.start();
			int retorno = process.waitFor();
			System.out.println("[+] La ejecucion de "
					+ Arrays.toString(args)
					+ " devuelve "
					+ retorno);
			
		}catch(IOException ex){
			System.err.println("[!] Excepción de E/S");
			System.exit(-1);
			
		}catch(InterruptedException ex){
			System.err.println("[!] Proceso HIJO finalizó de forma incorrecta");
			System.exit(-1);
			
		}
		
	}

}
