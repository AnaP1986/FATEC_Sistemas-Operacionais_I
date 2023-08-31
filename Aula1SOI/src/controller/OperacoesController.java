package controller;

public class OperacoesController {

	public OperacoesController() {
		super();
	}
	
	//ATIVIDADE 01 - SISTEMAS OPERACIONAIS I
	public int[] gerarVet(int nrPosicoes) {
		int[] vet = new int[nrPosicoes];
		for (int i = 0 ; i < nrPosicoes ; i++) {
			vet[i] = 0;
		}
		return vet;
	}
	
	public void percoVet(int[] numVet) {
		int tamanho = numVet.length;
		
		double tempoInicial = System.nanoTime();
		for (int i : numVet) {
			
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		
		System.out.println("Tempo String ==> " + tempoTotal +"s.");
	}
	
	public void perBuffer(int [] numVet) {
		StringBuffer buffer = new StringBuffer();
		double tempoInicial = System.nanoTime();
		
		for(int i : numVet) {
			buffer.append("a");
		}
		
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal / Math.pow(10,  9);
		System.out.println("Tempo Buffer ==> " + tempoTotal + "s.");
	}

}