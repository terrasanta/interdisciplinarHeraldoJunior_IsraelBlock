/**
 * 
 */
package interdisciplinar.mvc.main;

import interdisciplinar.mvc.view.estabelecimento.EstabelecimentoView;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 15 de out de 2017
 */
public class Main {

	public static void main(String[] args) {
		//AdminUserView uv = new AdminUserView();
		//uv.menu();	
		
		EstabelecimentoView ev = new EstabelecimentoView();
		ev.listar();
	}

}
