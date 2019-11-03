package pgv.tema1.programaciondeprocesos;

import java.io.IOException;

public class RunProcessExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		if (args.length <= 0) {
			System.err.println("[x] Se necesita un programa para ejecutar");
			System.exit(-1);
		}
		
		Runtime runtime = Runtime.getRuntime();
		try{
			
			Process process = runtime.exec(args);
			process.destroy();
		}catch(IOException ex){
			System.err.println("[!] Excepcion de E/S");
			System.exit(-1);
		}
	}

}
