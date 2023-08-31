import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	// -----------------------------------------ENUNCIADO------------------------------------------------------//
	// 1) NOME DO SISTEMA
	// 2) CHAMA IP
	// 3) CHAMA PING

// 1)  EXIBIR O NOME DO SISTEMA OPERACIONAL
	private String os() {
		String so = System.getProperty("os.name");
		String arq = System.getProperty("os.arch");
		String version = System.getProperty("os.version");

		return so + "Nome do Sistema Operacional: " + so + "\nArquitetura: " + arq + "\nVersão: " + version;
	}

//-------------------------------------------------------------------------------------------------------------//
// 2) CHAMA IP - DE ACORDO COM SISTEMA OPERACIONAL
	public void ip() {

		// VALIDACAO SISTEMA OPERACIONAL
		String os = os(); // MENCIONANDO O METODO ACIMA
		String chamada; // O NOME DO COMANDO DADO

		// UTILIZAÇÃO DOS COMANDOS - EXIBIR PING
		if (os.contains("Win")) {

			chamada = "IPCONFIG"; // WINDOWS

			try {
				Process p = Runtime.getRuntime().exec(chamada);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				// LENDO A PRIMEIRA LINHA DO BUFFER
				String linha = buffer.readLine();
				String titulo = "";
				while (linha != null) {

					if (linha.contains("Adaptador")) {
						titulo = linha;
					}

					// VERIFICAR NO WINDOWS (COMANDO IPCONFIG -> IPV4)
					if (linha.contains("IPv4")) {
						System.out.println(titulo);
						System.out.println(linha);
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			chamada = "ifconfig"; // LINUX

			try {
				Process p = Runtime.getRuntime().exec(chamada);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String line = buffer.readLine();
				String titulo = "";
				while (line != null) {

					if (line.contains("Adaptador")) {
						titulo = line;
					}

					// VERIFICAR NO LINUX (COMANDO IFCONFIG -> INET)
					if (line.contains("inet")) {
						System.out.println(titulo);
						System.out.println(line);
					}
					line = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

//-------------------------------------------------------------------------------------------------------------//	
// 3) CHAMA PING - DE ACORDO COM SISTEMA OPERACIONAL
	public void ping() {

		// VALIDACAO SISTEMA OPERACIONAL
		String os = os(); // MENCIONANDO O METODO ACIMA
		String chamada; // O NOME DO COMANDO DADO

		// UTILIZAÇÃO DOS COMANDOS - PINGAR
		if (os.contains("Win")) {

			// ------------------------------------VALIDACAO WINDOWS
			chamada = "PING -4 -n 10 www.google.com.br"; // WINDOWS

			try {

				Process p = Runtime.getRuntime().exec(chamada); // ENQUANTO TIVER EXECUCAO, FICA SALVO

				InputStream fluxo = p.getInputStream(); // FLUXO DE ENTRADA DE DADOS
				InputStreamReader leitor = new InputStreamReader(fluxo); // ELE LÊ E TROCA PARA STRING

				BufferedReader buffer = new BufferedReader(leitor); // CONVERTENDO, SALVA NO BUFFER

				// LENDO A PRIMEIRA LINHA DO BUFFER
				String linha = buffer.readLine(); // APÓS ISSO, DESCARTA

				// ACALMAR O USUÁRIO
				System.out.println("\nPing está sendo realizado...");
				System.out.println("\nAguardando média...");

				// VERIFICAR LINHAS DE SAIDA
				while (linha != null) {
					if (linha.contains("dia =")) { // EXIBE O VALOR DA PARTE DEBAIXO -> MÉDIA
						String[] partes = linha.split(" ");

						// TEMPO MEDIO DO PING
						for (String parts : partes) {
							if (!parts.contains("ms,") && parts.contains("ms")) {
								System.out.println("\nMedia: " + parts);

							}
						}
					}

					linha = buffer.readLine();
				}

				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				e.printStackTrace(); // EXIBIR MSG DE ERRO
			}

			// --------------------------------VALIDACAO LINUX

		} else {

			chamada = "PING -4 -c 10 www.google.com.br"; // LINUX

			try {

				Process p = Runtime.getRuntime().exec(chamada); // ENQUANTO TIVER EXECUCAO, FICA SALVO

				InputStream fluxo = p.getInputStream(); // FLUXO DE ENTRADA DE DADOS
				InputStreamReader leitor = new InputStreamReader(fluxo); // ELE LÊ E TROCA PARA STRING

				BufferedReader buffer = new BufferedReader(leitor); // CONVERTENDO, SALVA NO BUFFER

				// LENDO A PRIMEIRA LINHA DO BUFFER
				String linha = buffer.readLine(); // APÓS ISSO, DESCARTA

				// ACALMAR O USUÁRIO
				System.out.println("\nPing está sendo realizado...");
				System.out.println("\nAguardando média...");

				// VERIFICAR LINHAS DE SAIDA
				while (linha != null) {
					if (linha.contains("dia =")) { // EXIBE O VALOR DA PARTE DEBAIXO -> MÉDIA
						String[] partes = linha.split(" ");

						// TEMPO MEDIO DO PING
						for (String parts : partes) {
							if (!parts.contains("ms,") && parts.contains("ms")) {
								System.out.println("\nMedia: " + parts);

							}
						}
					}

					linha = buffer.readLine();
				}

				// TERMINOU? -> FECHAR TUDO
				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}