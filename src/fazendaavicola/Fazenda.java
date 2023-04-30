package fazendaavicola;

import java.util.ArrayList;

public class Fazenda {

	private int planoAnual;

	private final ArrayList<Capoeira> capoeiras = new ArrayList<>();

	public Fazenda() {
		this.planoAnual = 0;
	}

	public Fazenda(int planoAnual) {
		this.planoAnual = planoAnual;
	}

	public void setPlanoAnual(int planoAnual) {
		if (planoAnual >= 0) {
			this.planoAnual = planoAnual;
		}
	}

	public float porcentoPlanoAnual(int mes) {
		int producao = 0;
		if (mes >= 1 && mes <= 12) {
			for (Capoeira item : capoeiras) {
				producao += item.obterProducaoAteMes(mes);
			}
		}
		return ((float) producao / planoAnual) * 100;
	}

	/*
	 * public float porcentoPlanoAnual(int mes) { int producao = 0; for (int i = 0;
	 * i < mes; i++) { producao += obterProducaoMes(i + 1); } return
	 * (producao/planoAnual)*100; }
	 */

	public int obterMesMaisProdutivo() {
		int mes = 1;
		int maiorProducao = obterProducaoMes(1);
		for (int i = 1; i < 12; i++) {
			if (maiorProducao < obterProducaoMes(i + 1)) {
				mes = i + 1;
				maiorProducao = obterProducaoMes(i + 1);
			}
		}
		return mes;
	}

	private int obterProducaoMes(int mes) {
		int producao = 0;
		if (mes >= 1 && mes <= 12) {
			for (Capoeira item : capoeiras) {
				producao += item.obterProducao(mes);
			}
		}
		return producao;
	}

	public int obterCapoeiraMaisProdutiva() {
		Capoeira capoeira = capoeiras.get(0);
		for (int i = 1; i < capoeiras.size(); i++) {
			if (capoeira.obterProducao() < capoeiras.get(i).obterProducao()) {
				capoeira = capoeiras.get(i);
			}
		}
		return capoeira.getId();
	}

	public ArrayList<Integer> obterMesesCumpridos() {
		ArrayList<Integer> meses = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			if (obterProducaoMes(i + 1) == (float) planoAnual / 12) {
				meses.add(i + 1);
			}
		}
		return meses;
	}

	public ArrayList<Integer> obterMesesNaoCumpridos() {
		ArrayList<Integer> meses = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			if (obterProducaoMes(i + 1) < (float) planoAnual / 12) {
				meses.add(i + 1);
			}
		}
		return meses;
	}

	public ArrayList<Integer> obterMesesSobreCumpridos() {
		ArrayList<Integer> meses = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			if (obterProducaoMes(i + 1) > (float) planoAnual / 12) {
				meses.add(i + 1);
			}
		}
		return meses;
	}

	private int buscarCapoeira(int id) {
		for (int i = 0; i < capoeiras.size(); i++) {
			if (capoeiras.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public boolean adicionarCapoeira(int id) {

		if (id >= 0 && buscarCapoeira(id) == -1) {
			capoeiras.add(new Capoeira(id));
			return true;
		}
		return false;
	}

	public boolean adicionarCapoeira(int id, int[] producaoMensal) {
		if (id >= 0 && validarProducao(producaoMensal) && buscarCapoeira(id) == -1) {
			capoeiras.add(new Capoeira(id, producaoMensal));
			return true;
		}
		return false;
	}

	public boolean atribuirProducao(int id, int mes, int producao) {
		int indice = buscarCapoeira(id);
		if (indice >= 0 && mes >= 1 && mes <= 12 && producao >= 0) {
			capoeiras.get(indice).atribuirProduçao(mes, producao);
			return true;
		}
		return false;
	}

	public int[] obterProduçaoCapoeira(int id) {
		int indice = buscarCapoeira(id);
		if (indice >= 0) {
			return capoeiras.get(indice).getProducaoMensal();
		}
		return null;
	}
// valida que cada produção é maior que 0 e estão as produções dos 12 meses
	private boolean validarProducao(int[] producaoMensal) {
		boolean result = true;
		if (producaoMensal != null && producaoMensal.length == 12) {		
			for (int p : producaoMensal) {
				if (p < 0) {
					result = false;
				}
			}
		}else {
			result = false;
		}
		return result;
	}

}
