package valentao;

import java.util.ArrayList;
import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		
		System.out.println("\n Algoritmo do Valentão \n");
		
		Processo p0 = new Processo(0);
		Processo p1 = new Processo(1);
		Processo p2 = new Processo(2);
		Processo p3 = new Processo(3);
		Processo p4 = new Processo(4);
		Processo p5 = new Processo(5);
		Processo p6 = new Processo(6);
		Processo p7 = new Processo(7);
		
		ArrayList<Processo> armazenaProcessos = new ArrayList<>();
		armazenaProcessos.add(p0);
		armazenaProcessos.add(p1);
		armazenaProcessos.add(p2);
		armazenaProcessos.add(p3);
		armazenaProcessos.add(p4);
		armazenaProcessos.add(p5);
		armazenaProcessos.add(p6);
		armazenaProcessos.add(p7);
		
		/* Menu */
		
		boolean stopProgram = true;
		int processoEleicao = 0;
		
		while(stopProgram) {
			
			System.out.println("\n*************************************************************************************\n");
			System.out.println("\nDigite uma opção:\n 1- Exibir atual coordenador\n 2- Exibir conjunto de processos ativos\n 3- Requisitar eleição\n 4- Encerrar programa\n");
			
			Scanner scan = new Scanner(System.in);
			int opcao = scan.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("\nAtual coordenador: "+armazenaProcessos.get(0).getCoordenador()+"\n");
				break;
			case 2:
				conjuntoProcessos(armazenaProcessos);
				break;
			case 3:
				System.out.println("\nDigite a posição do processo a requisitar eleição:\n");
				processoEleicao = scan.nextInt();
				System.out.println("Processo Escolhido: "+processoEleicao+"\n");
				requisitarEleicao(processoEleicao, armazenaProcessos);
				break;
			case 4:
				System.out.println("\nFinalizou\n");
				stopProgram = false;
				break;
			default:
				System.out.println("\nOpção inválida\n");
				break;
			}
			
		}
	
	}
	
	public static void conjuntoProcessos(ArrayList<Processo> armazenaProcessos) {
		
		System.out.println("\n");
		
		for(int i=0; i < armazenaProcessos.size(); i++) {
			
			System.out.println("|PROCESSO "+armazenaProcessos.get(i).getId()+" - COORDENADOR "+armazenaProcessos.get(i).getCoordenador()+" - ATIVO: "+armazenaProcessos.get(i).isAtivo()+" - POSICAO: "+i+" |");
			
		}
		
	}
	
	public static void requisitarEleicao(int processoEleicao, ArrayList<Processo> armazenaProcessos) {
		
		int posicaoCoordenadorVetor = (armazenaProcessos.size()) - 1;
		
		boolean processoAtivo = armazenaProcessos.get(posicaoCoordenadorVetor).processoAtivo();
		
		System.out.println("\nPROCESSO ATIVO? "+processoAtivo);
		
		if(processoAtivo == true) {
			System.out.println("\nO atual coordenador ainda está ativo\n");
		}else {
			System.out.println("\nO coordenador não está mais ativo ativo\n");
			armazenaProcessos.remove(posicaoCoordenadorVetor);
			
			conjuntoProcessos(armazenaProcessos);
			
			int processoEleicaoAux = processoEleicao;
			
			while(processoEleicaoAux != armazenaProcessos.size()) {
				
				System.out.println("\n------------------PROCESSO "+processoEleicaoAux+" PEDE UMA NOVA ELEICAO--------------------");
				
				for(int i=processoEleicaoAux+1; i<armazenaProcessos.size();i++) {
					System.out.println("\n|PROCESSO "+armazenaProcessos.get(processoEleicaoAux).getId()+" pede eleicao ao "+armazenaProcessos.get(i).getId()+" que retorna OK |");
				}
				
				System.out.println("----------------------------------------------------------------------");
				
				processoEleicaoAux += 1;
				
			}
			
			System.out.println("PROCESSO "+(processoEleicaoAux-1)+ " É O NOVO COORDENADOR!");
			
			for(int k=0; k < armazenaProcessos.size(); k++) {
				
				armazenaProcessos.get(k).setCoordenador(processoEleicaoAux-1);
				
			}
			
		}
		
	}

}
