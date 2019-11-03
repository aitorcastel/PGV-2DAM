package pgv.tema1.programaciondeprocesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TP_ComandoWindows {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		//ProcessBuilder builder = new ProcessBuilder().command("cmd.exe", "dir", "C:/Users/aitor/Desktop");
		ProcessBuilder builder = new ProcessBuilder("CMD", "/C", "dir C:/Users/aitor/Desktop");
		Process process = builder.start();
		
		// alternativa a process builder
		// Process process = Runtime.getRuntime().exec(new String[] {"cmd.exe", "dir" ,"C:/Users/aitor/Desktop" });
		
		process.waitFor(10, TimeUnit.SECONDS);
		
		int value = process.exitValue();
		if(value != 0) {
			throw new Exception(MessageFormat.format("[x] Código de salda con error (%d)",value));
			
		}
		
		// obtener la salida del proceso
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
		String result = br.lines().collect(Collectors.joining("\n"));
		br.close();
		
		// obtener el tiempo desde el inicio del sistema
		String seconds = result.split(" ")[0];
		System.out.printf("[i] Segundos desde el inicio del sistema: %.2f", new BigDecimal(seconds));
	}

}
