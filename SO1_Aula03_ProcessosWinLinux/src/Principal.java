
import controller.RedesControllerAula;

public class Principal {

	public static void main(String[] args) {

		//INSTANCIA DO CONSTRUTOR
		RedesControllerAula controller = new RedesControllerAula();
		
		//EXIBIR RESULTADO -> NOME | VERSÃO | ARQUITETURA
		//controller.os();
//-------------------------------------------------------------------------------------------------------------//
		//CHAMAR PROCESSO (SEM ELEVACAO) - VOCÊ PODE INSERIR O CAMINHO DA PASTA E ABRIR ALGUM APP
		String processoSemElevacao = "notepad.exe"; 		//FAZ ABRIR O BLOCO DE NOTAS0
		controller.callProcess(processoSemElevacao);		
//-------------------------------------------------------------------------------------------------------------//		
		//CHAMAR COM ELEVAÇÃO -> FUNCAO chamarProcessoElevacao
//		String processoComElevacao = "C:\\Windows\\regedit.exe"; 		//TESTE COM ELEVAÇÃO (ADM)
//		controller.chamarProcessoElevacao(processoComElevacao);
//-------------------------------------------------------------------------------------------------------------//
		//ABRINDO O EXCEL, POR EXEMPLO:
		//String processoTeste = "C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.exe";
		//controller.callProcess(processoTeste);
//-------------------------------------------------------------------------------------------------------------//	
		//MOSTRAR OS PROCESSOS NO WINDOWS -> CHAMA A FUNÇÃO LER PROCESSO
//		String process = "TASKLIST /FO TABLE";
//		controller.lerProcesso(process);
		
		//FAZER O PING PARA O GOOGLE -> t-10 (VAI PINGAR ETERNAMENTE)
//		String process = "PING -t10 www.google.com";
		//String process = "IPCONFIG";		// VER AS INFORMAÇÕES DE IP
//		controller.lerProcesso(process);
//-------------------------------------------------------------------------------------------------------------//	
		// MATAR PROCESSO -> VC PODE MATAR PELO NOME OU ID;
		//CHAMA A FUNÇÃO KILL PROCESS
//		String param = "notepad.exe"; 		//ESCOLHER O PROCESSO QUE VAI MATAR (nome)
//		String param = "20084"; 		//ESCOLHER O PROCESSO QUE VAI MATAR (PID))
//		controller.killProcess(param);
	}
}