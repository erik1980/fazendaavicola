package fazendaavicola;

public class Capoeira {

	private int id;

	private int[] producaoMensal;
	/*
	 * Nos constructores, a maneira de validar é lançar uma exceção se os dados não forem
	 * válidos, mas ainda não abordamos esse mecanismo nas classes.
	 */

	public Capoeira(int id, int[] producaoMensal) { 
		this.id = id;
		/*
		 * Antes de fazer essa atribuição, pode ser conveniente validar que cada
		 * elemento do vetor é maior que 0 ou simplesmente não permitir que esse
		 * parâmetro seja passado por um construtor e apenas as produções sejam
		 * passadas, uma a uma, pelo método attribuirProduçao .
		 */
		this.producaoMensal = producaoMensal; 
	}

	public Capoeira(int id) {
		this(id, new int[12]);
	}

	public int getId() {
		return id;
	}

	public int[] getProducaoMensal() {
		return producaoMensal;
	}

	/*
	 * Em vez de não fazer nada quando os dados são inválidos, devemos lançar uma
	 * exceção, veremos isso em aulas futuras. Por enquanto, o importante é saber
	 * que, como boa prática de programação, devemos sempre validar os parâmetros de
	 * entrada.
	 */
	public int obterProducaoAteMes(int mes) {
		int producao = 0;
		if (mes >= 1 && mes <= 12) { 
			for (int i = 0; i < mes; i++) {
				producao += producaoMensal[i];
			}
		}
		return producao;
	}

	public int obterProducao(int mes) {
		int producao = 0;
		if (mes <= 12 && mes >= 1) {
			producao = producaoMensal[mes - 1];
		}
		return producao;

	}

	public int obterProducao() {
		int producaoAnual = 0;
		for (int p : producaoMensal) {
			producaoAnual += p;

		}
		return producaoAnual;
	}


	public void atribuirProduçao(int mes, int producao) {
		if (mes >= 1 && mes <= 12 && producao >= 0) {
			producaoMensal[mes - 1] = producao;
		}
	}
	

}
