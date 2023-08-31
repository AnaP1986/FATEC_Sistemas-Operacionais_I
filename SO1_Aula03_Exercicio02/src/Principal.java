import javax.swing.JOptionPane;

import controller.KillController;

public class Principal {

	public static void main(String[] args) {
		
		//INSTANCIA DO CONSTRUTOR
		KillController controller = new KillController();
				
		//MENUZINHO DE USO DO SOFTWARE
		int opcao = 0;
		
		while(opcao != 9) {
				opcao = Integer.parseInt(JOptionPane.showInputDialog(""
						+ " Escolha uma opção \n"
						+ " 1 - Exibir Lista de Processos\n"
						+ " 2 - Matar o Processo por PID \n"
						+ " 3 - Matar o Processo por NOME\n"
						+ " 9 - Encerrar"
						+ ""));
				
			//CHAMA PROCESSOS
			switch(opcao) {
				case 1: controller.listaProcesso();		// LISTAR PROCESSOS ATIVOS EM SEU SISTEMA OPERACIONAL
				break;
				
				case 2: String finalizarPid = JOptionPane.showInputDialog("Digite o PID do Processo");		//USUARIO VAI DIGITAR
						controller.killPid(finalizarPid);							//VAI FINALIZAR O PROCESSO;
				break;
				
				case 3: String finalizarNome = JOptionPane.showInputDialog("Digite o NOME do Processo");		//USUARIO VAI DIGITAR
				controller.killPid(finalizarNome);																//VAI FINALIZAR O PROCESSO;
				break;
				
				case 9: JOptionPane.showMessageDialog(null, "Programa Finalizado!");
				break;
				
				default: JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
			}
		}
	}