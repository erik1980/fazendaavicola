package fazendaavicola;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fazenda fazenda = new Fazenda(1200);
		
		int[] prod = new int[] {122,233, 523, 20, 134, 122, 2, 53, 123, 533, 1234, 12};
		fazenda.adicionarCapoeira(1, prod);
		
		prod = new int[] {23,45, 12, 20, 63, 12, 23, 91, 11, 5, 12, 10};
		fazenda.adicionarCapoeira(2, prod);
		
		prod = new int[] {11,12, 4, 20, 15, 54, 10, 55, 86, 34, 13, 11};
		fazenda.adicionarCapoeira(3, prod);
		
		prod = new int[] {10, 12, 45, 20, 65, 23, 5, 12, 75, 34, 333, 12};
		fazenda.adicionarCapoeira(4, prod);
		
		prod = new int[] {1,54, 23, 20, 20, 12, 11, 313, 45, 11, 34, 1};
		fazenda.adicionarCapoeira(5, prod);
		
		System.out.printf("Porcento do plano no mes %d: %f\n",5, fazenda.porcentoPlanoAnual(5));
		System.out.printf("Mes mais produtivo do ano: %d\n",fazenda.obterMesMaisProdutivo());
		System.out.printf("Capoeira mais produtiva do ano: %d\n",fazenda.obterCapoeiraMaisProdutiva());
		System.out.print("Meses em que cumpriram o plano: ");
		for (int mes : fazenda.obterMesesCumpridos()) {
			System.out.print(mes + "\t");
		}
		System.out.println();
		System.out.print("Meses em que não cumpriram o plano: ");
		for (int mes : fazenda.obterMesesNaoCumpridos()) {
			System.out.print(mes + "\t");
		}
		System.out.println();
		System.out.print("Meses em que sobre cumpriram o plano: ");
		for (int mes : fazenda.obterMesesSobreCumpridos()) {
			System.out.print(mes + "\t");
		}
		System.out.println("\n----------------------------------------------------------");
		Scanner sc = new Scanner(System.in);		
		System.out.print("Digite o ID da capoeira para atribuir produção: ");
		int id = sc.nextInt();		
		System.out.print("Digite o mes da capoeira: ");
		int mes = sc.nextInt();	
		System.out.print("Digite a produção da capoeira: ");
		int producao = sc.nextInt();
		fazenda.atribuirProducao(id, mes, producao);		
		System.out.print("A produçao da Capoeira mensal agora é: ");
		for (int p : fazenda.obterProduçaoCapoeira(id)) {
			System.out.print(p + "\t");			
		}

	}

}
