import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	// -----------------------------------------ENUNCIADO------------------------------------------------------//
	// 1) NOME DO SISTEMA
	// 2) LISTA PROCESSOS -> VERIFICA SO E LISTA PROCESSOS ATIVOS
	// 3) MATA PID
	// 4) MATA NOME

	// 1) EXIBIR O NOME DO SISTEMA OPERACIONAL
	private String os() {
		String so = System.getProperty("os.name");
		String arq = System.getProperty("os.arch");
		String version = System.getProperty("os.version");

		return so + "Nome do Sistema Operacional: " + so + "\nArquitetura: " + arq + "\nVersão: " + version;
	}

//-------------------------------------------------------------------------------------------------------------//
// 2) LISTA PROCESSOS -> VERIFICA SO E LISTA PROCESSOS ATIVOS
	public void listaProcesso() {

		// VALIDACAO SISTEMA OPERACIONAL
		String os = os(); // MENCIONANDO O METODO ACIMA
		String chamada; // O NOME DO COMANDO DADO

		// UTILIZAÇÃO DOS COMANDOS - EXIBIR PING
		if (os.contains("Win")) {

			chamada = "TASKLIST /FO TABLE"; // WINDOWS

			// TRY COM A LEITURA DO PROCESSO
			try {
				Process p = Runtime.getRuntime().exec(chamada); // ENQUANTO TIVER EXECUCAO, FICA SALVO

				InputStream fluxo = p.getInputStream(); // FLUXO DE ENTRADA DE DADOS
				InputStreamReader leitor = new InputStreamReader(fluxo); // ELE LÊ E TROCA PARA STRING

				BufferedReader buffer = new BufferedReader(leitor); // CONVERTENDO, SALVA NO BUFFER

				// LENDO A PRIMEIRA LINHA DO BUFFER
				String linha = buffer.readLine(); // APÓS ISSO, DESCARTA

				// ENQUANTO FOR DIFERENTE DE NULL | --> ATÉ SE ESGOTAR
				while (linha != null) {

					System.out.println(linha); // IMPRIME A LINHA
					linha = buffer.readLine(); // REGISTRA A LINHA NO BUFFER
				}
				
				// TERMINOU? -> FECHAR TUDO
				buffer.close();
				leitor.close();
				fluxo.close();

				// TRATAR O ERRO E EXIBE CODIGO DE ERRO
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			chamada = "ps -ef"; // LINUX

			// TRY COM A LEITURA DO PROCESSO
			try {
				Process p = Runtime.getRuntime().exec(chamada); // ENQUANTO TIVER EXECUCAO, FICA SALVO

				InputStream fluxo = p.getInputStream(); // FLUXO DE ENTRADA DE DADOS
				InputStreamReader leitor = new InputStreamReader(fluxo); // ELE LÊ E TROCA PARA STRING

				BufferedReader buffer = new BufferedReader(leitor); // CONVERTENDO, SALVA NO BUFFER

				// LENDO A PRIMEIRA LINHA DO BUFFER
				String linha = buffer.readLine(); // APÓS ISSO, DESCARTA

				// ENQUANTO FOR DIFERENTE DE NULL | --> ATÉ SE ESGOTAR
				while (linha != null) {

					System.out.println(linha); // IMPRIME A LINHA
					linha = buffer.readLine(); // REGISTRA A LINHA NO BUFFER
				}

				// TERMINOU? -> FECHAR TUDO
				buffer.close();
				leitor.close();
				fluxo.close();

				// TRATAR O ERRO E EXIBE CODIGO DE ERRO
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

//------------------------------------------------------------------------------------------------------//
// 3) MATA PROCESSO POR PID
	public void killPid(String matar) {
		String os = os(); // NOME DO SISTEMA OPERACIONAL
		String cmdPid;

		// PROCESSO PARA MATAR POR PID;
		if (os.contains("Win")) {
			cmdPid = "TASKKILL /PID"; // WINDOWS
			StringBuffer buffer = new StringBuffer();

			try {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(matar);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			try {
				Runtime.getRuntime().exec(buffer.toString());

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			cmdPid = "kill -9"; // LINUX
			StringBuffer buffer = new StringBuffer();

			try {
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(matar);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

//-------------------------------------------------------------------------------------------------------------//		
// 4) MATA PROCESSO POR NOME
	public void killName(String matar) {
		String os = os(); // NOME DO SISTEMA OPERACIONAL
		String cmdName;

		if (os.contains("Win")) {
			cmdName = "TASKILL /IM"; // WINDOWS
			StringBuffer buffer = new StringBuffer();

			// PROCESSO PARA MATAR POR NOME;
			try {
				buffer.append(cmdName);
				buffer.append(" ");
				buffer.append(matar);

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			cmdName = "pkill -f"; // LINUX
			StringBuffer buffer = new StringBuffer();

			// PROCESSO PARA MATAR POR NOME;
			try {
				buffer.append(cmdName);
				buffer.append(" ");
				buffer.append(matar);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}