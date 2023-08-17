package view;

import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {
			//INSTANCIA PARA A CLASSE DE CONTROLER
			OperacoesController vetController = new OperacoesController();
			
			//DECLARAR OS VETORES
	    	int[] vetorMilposicoes = vetController.gerarVet(1000);
	    	int[] vetorDezMilposicoes  = vetController.gerarVet(10000);
	    	int[] vetorCemMilposicoes  = vetController.gerarVet(100000);
	    	
	    	//EXIBIR RESULTADO
	    	System.out.println("Para 1000");
	    	vetController.percoVet(vetorMilposicoes);
	    	vetController.perBuffer(vetorMilposicoes);
	    	System.out.println("-------------------------------------------------");
	    	
	    	System.out.println("Para 10000");
	    	vetController.percoVet(vetorDezMilposicoes);
	    	vetController.perBuffer(vetorDezMilposicoes);
	    	System.out.println("-------------------------------------------------");
	    	
	    	System.out.println("Para 100000");
	    	vetController.percoVet(vetorCemMilposicoes);
	    	vetController.perBuffer(vetorCemMilposicoes);
	    	System.out.println("-------------------------------------------------");
		}
}