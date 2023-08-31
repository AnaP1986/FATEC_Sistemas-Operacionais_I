
import javax.swing.JOptionPane;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		
		//INSTANCIA DO CONSTRUTOR
		RedesController controller = new RedesController();
				
		//MENUZINHO DE USO DO SOFTWARE
		int opcao = 0;
		
		while(opcao != 9) {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(""
						+ " Escolha uma opção \n"
						+ " 1 - Exibir Configuração de IP\n"
						+ " 2 - Realizar PING com 10 interações \n"
						+ " 9 - Encerrar \n"
						+ ""));
				
			switch(opcao) {
				case 1: controller.ip();		//CONFIGURAÇÃO DE IP + NOME DO SISTEMA OPERACIONAL
				break;
				
				case 2: controller.ping();		//FAZER PING COM 10 INTERAÇÕES
				break;
				
				case 9: JOptionPane.showMessageDialog(null, "Programa Finalizado!");
				break;
				
				default: JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
			}
		}
	}