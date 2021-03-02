package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chamadas {

	public Chamadas(){
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
			return os;
	}
//Listagem Windows
	public void readProcess(String process){
		try {
			Process p = Runtime.getRuntime().exec(process);
			java.io.InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//Listagem Linux
	public void readProcessL(String process){
		try {
			Process p = Runtime.getRuntime().exec(process);
			java.io.InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//Matar processo Windows
		public void killProcess (String param) {
			String cmdPid = "TASKKILL /PID";
			String cmdNome = "TASKKILL /IM";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			
			try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			} catch (NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(param);
			}
			
			callProcess(buffer.toString());
		}	

//Matar processo Linux

		public void killProcessL (String param) {
			String cmdPid = "kill -9";
			String cmdNome = "pkill -f";
			int pid = 0;
			StringBuffer buffer = new StringBuffer();
			
			try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			} catch (NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(param);
			}
			callProcess(buffer.toString());
		}	
//Chamada do processo
		public void callProcess(String process) {
			try {
				Runtime.getRuntime().exec(process);
			} catch (Exception e) {
				String msgErro = e.getMessage();
			//	System.err.println(msgErro);
				if (msgErro.contains("740")){
					StringBuffer buffer = new StringBuffer();
					buffer.append("cmd /c");
					buffer.append(" ");
					buffer.append(process);
					try {
						Runtime.getRuntime().exec(buffer.toString());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else {
					e.printStackTrace();
				}
			}
		}
		
	}
