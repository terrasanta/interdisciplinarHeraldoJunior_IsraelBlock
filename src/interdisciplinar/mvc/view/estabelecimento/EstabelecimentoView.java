/**
 * 
 */
package interdisciplinar.mvc.view.estabelecimento;

import java.util.List;

import interdisciplinar.mvc.controller.EstabelecimentoController;
import interdisciplinar.mvc.vo.Estabelecimento;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 30 de out de 2017
 */
public class EstabelecimentoView {
	
	private EstabelecimentoController ec;

	/**
	 * 
	 */
	public EstabelecimentoView() {
		ec = new EstabelecimentoController();
	}
	public void listar() {
		titulo("Listar");
		
		List<Estabelecimento> le = ec.listarEstabelecimento();

		if (le == null) {
			System.out.println("Erro");
		} else if (le.isEmpty()) {
			System.out.println("Lista vazia");
		} else {
			for (Estabelecimento estabelecimento : le) {
				String nomeTipo = ec.nomeTipo(estabelecimento.getTipoEstabelecimento());
				
				System.out.print("ID: ["+estabelecimento.getIdEstabelecimento()+"] - Nome: " + estabelecimento.getNomeEstabelecimento() + " - Tipo: "+nomeTipo + "["+estabelecimento.getTipoEstabelecimento()+"]");
				System.out.println(" - Data de cadastro: " + estabelecimento.getDataCadastro());
				System.out.println("==========================================");
			}
		}
	}
	
	public void titulo(String value) {
		System.out.println("****************************************");
		System.out.println(value);
		System.out.println("****************************************");
	}

}
