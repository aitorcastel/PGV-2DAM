package pgv.tema1.programaciondeprocesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
*	- Autor: Aitor del Castillo
*	- Asignatura: PGV - 2DAMB
*   - Actividad: 1.4
*/



public class Entrega_Actividad1_4 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		try {
			
			
			Scanner sc = new Scanner(System.in);
			String text = null;
			
			while(true) {
				
				System.out.print("[?] Introduzca su frase: ");
				text = sc.nextLine();
				
				if(text.equals("fin")){System.exit(0);}
				
				Process rn = new ProcessBuilder("RandomNumber.exe").start();
				InputStream rn_stream = rn.getInputStream();
				InputStreamReader rn_streamR = new InputStreamReader(rn_stream, "UTF-8");
				BufferedReader br = new BufferedReader(rn_streamR);
				
				System.out.println("[>] Numero: "+br.readLine());
				
			}
			
						
			
			}catch(IOException e) {
			
	        FileWriter fstream = new FileWriter("errores.txt");
	        BufferedWriter out = new BufferedWriter(fstream);
	        out.write(e.toString());
	        out.close();
	        
		}
		
		
	}

}
