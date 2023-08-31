import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesControllerAula {

	public RedesControllerAula() {
		super();
	}
//-------------------------------------------------------------------------------------------------------------//
	// EXIBIR O NOME DO SISTEMA OPERACIONAL
	public String os() {
		String so = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String versao = System.getProperty("os.version");

		System.out.println(so);
		System.out.println(versao);

		// CONDICAO WINDOWS OU NAO?
		if (so.contains("Win")) { // AQUI ELE COMPARA, VENDO SE INICIA COM "WIN"
			System.out.println("É WINDOWS");
		} else {
			System.out.println("Não é WINDOWS");
		}

		return "Sistema Operacional: " + so + "\n Arquitetura" + arch + "\n Versão: " + versao;
	}
//-------------------------------------------------------------------------------------------------------------//
	// CHAMAR O PROCESSO (SEM ELEVACAO)
	public void callProcess(String process) {
		try {
			// DENTRO DO TRY -> TODAS AS LINHAS QUE QUERO TRATAMENTO
			Runtime.getRuntime().exec(process);

		} catch (Exception e) {
			// LINHAS DE TRATAMENTO DE ERRO
			System.err.println(e.getMessage());
		}
	}

//-------------------------------------------------------------------------------------------------------------//
	// CHAMAR O PROCESSO - FOCANDO NO ERRO ---> (QUANDO HÁ ELEVACAO)
	public void chamarProcessoElevacao(String process) {
		try {

			Runtime.getRuntime().exec(process);

		} catch (Exception e) {

			String msgErro = e.getMessage();

			if (msgErro.contains("740")) { // 740 --> ERRO DE ELEVAÇÃO DO WINDOWS
				// CMD -> /c caminho_do_processo
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);

				// MSG DE ERRO - EXIBIÇÃO
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} else {
				System.err.println(msgErro); // SE O ERRO NÃO FOR 740, ISSO AQUI FAZ MOSTRAR O ERRO
			}
		}
	}
//-------------------------------------------------------------------------------------------------------------//
	// LER PROCESSO - COMO LER?
	public void lerProcesso(String proces) {
		try {

			Process p = Runtime.getRuntime().exec(proces); // ENQUANTO TIVER EXECUCAO, FICA SALVO
			InputStream fluxo = p.getInputStream(); // FLUXO DE ENTRADA DE DADOS
			InputStreamReader leitor = new InputStreamReader(fluxo); // ELE LÊ E TROCA PARA STRING
			BufferedReader buffer = new BufferedReader(leitor); // CONVERTENDO, SALVA NO BUFFER

			// LENDO A PRIMEIRA LINHA DO BUFFER
			String linha = buffer.readLine(); // APÓS ISSO, DESCARTA

			// ENQUANTO FOR DIFERENTE DE NULL | --> ATÉ SE ESGOTAR
			while (linha != null) {
				System.out.println(linha); // PRINTA O CONTEUDO DA LINHA
				linha = buffer.readLine(); // LE A LINHA NOVAMENTE
			}
			
			//TERMINOU? -> FECHAR TUDO
			buffer.close();
			leitor.close();
			fluxo.close();

		} catch (IOException e) {
			e.printStackTrace(); //APENAS O TRATAMENTO DE ERRO;
		}
	}
//-------------------------------------------------------------------------------------------------------------//
	//MATAR PROCESSO - COMO MATAR?
	public void killProcess(String param) {
		String cmdPid = "TASKKILL /PID"; 		//MATAR PELO ID
		String cmdName = "TASKKILL /IM"; 		//MATAR PELO NOME DO PROCESSO
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		//DESSA FORMA, CONSEGUIMOS MATAR O PROCESSO SEJA POR PID OU POR NOME
		try {
			//TASKKILL /PID XXXX -> VALOR QUALQUER
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(" ");
			buffer.append(pid);
			
		} catch (NumberFormatException e) {			//SE ELE TENTAR MATAR PELO PID E NÃO CONSEGUIR, VAI PELO NOME
			//TASKKILL /IM nomedoprocesso.exe
			buffer.append(cmdName);
			buffer.append(" ");
			buffer.append(param);
		}
		
		//CHAMAR O PROCESSO:
		callProcess(buffer.toString());		//AQUI ELE VAI CHAMAR A FUNÇÃO CRIADA PARA CHAMAR O PROCESSO;
	}
}


/*UMA OUTRA FORMA DE EXIBIR O RESULTADO, É FAZENDO OUTRO TRY:
try {
	Runtime.getRuntime().exec(buffer.toString());
} catch (IOException e) {
	e.printStackTrace();

	//ENTRETANTO, JÁ TEMOS A OPERAÇÃO DE CHAMAR O PROCESSO *NESTE* CODIGO, ENTÃO NÃO VOU USAR;
}
*/