package view;

import controller.Chamadas;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

				
		Chamadas chamadas = new Chamadas();
		
		String os = chamadas.os();
		
		System.out.println("Seu sistema é: " + os);
	
	if (os.contains ("linux")) {
	String param;	
	int opc = 0;
    while (opc!=9){
     opc = Integer.parseInt(JOptionPane.showInputDialog
              ("1 -  Lista de Processos \n 2 - Encerrar processo via PID \n 3 - Encerrar processo por nome \n 9 - Finaliza"));
     	switch (opc) {
            case 1:  String process = "ps -ef";
   		 			 chamadas.readProcessL(process);
                     break;
            case 2: param = (JOptionPane.showInputDialog("Digite o PID"));
			 		chamadas.killProcessL(param);
                    break;
            case 3: param = (JOptionPane.showInputDialog("Digite o PID"));
			 		chamadas.killProcessL(param);
            		break;
            case 9:  JOptionPane.showMessageDialog(null,"Programa finalizado");
                     break;
            default: JOptionPane.showMessageDialog(null,"Opção Inválida");
        } 
  	}  
 } else {
	 
	 int opc = 0;
	    while (opc!=9){
	     opc = Integer.parseInt(JOptionPane.showInputDialog
	              ("1 -  Lista de Processos \n 2 - Encerrar processo via PID \n 3 - Encerrar processo por nome \n 9 - Finaliza"));
	     	String param;
			switch (opc) {
	            case 1:  String process = "TASKLIST /FO TABLE";
	            		 chamadas.readProcess(process);
	                     break;
	            case 2:  param = (JOptionPane.showInputDialog("Digite o PID"));
	    				 chamadas.killProcess(param);
	    				 break;
	            case 3: param = (JOptionPane.showInputDialog("Digite o PID"));
				 		chamadas.killProcess(param);
	                    break;
	            case 9:  JOptionPane.showMessageDialog(null,"Programa finalizado");
	                     break;
	            default: JOptionPane.showMessageDialog(null,"Opção Inválida");
	 
	     	}
}	
}
}
}
