/**
 * 
 */
package interdisciplinar.mvc.view.admin;

import java.util.List;

import interdisciplinar.mvc.controller.UserController;
import interdisciplinar.mvc.util.Leitor;
import interdisciplinar.mvc.vo.User;
import interdisciplinar.mvc.vo.UserAdmin;
import interdisciplinar.mvc.vo.UserEstabelecimento;
import interdisciplinar.mvc.vo.UserPublic;

/**
 * @author Israel Block
 * @version 1.0.1
 * @since 15 de out de 2017
 */
public class AdminUserView {

	private final int MENU_INCLUIR = 1;
	private final int MENU_ATUALIZAR = 2;
	private final int MENU_EXCLUIR = 3;
	private final int MENU_LISTAR_TODOS = 4;
	private final int MENU_PESQUISA_ID = 5;
	private final int MENU_PESQUISA_NOME = 6;
	private final int MENU_SAIR = 0;
	
	private UserController uc;
	
	/**
	 * 
	 */
	public AdminUserView() {
		uc = new UserController();
	}
	public void menu() {
		int opc = -1;
		do {
			System.out.println("MENU DE OPÇÕES");
			System.out.println("=================");
			System.out.println("Selecione uma opção");
			System.out.println("Digite 1 para incluir um usuário");
			System.out.println("Digite 2 para atualizar um usuário");
			System.out.println("Digite 3 para excluir um usuário");
			System.out.println("Digite 4 para listar todos os usuários");
			System.out.println("Digite 5 para pesquisar usuário pelo ID");
			System.out.println("Digite 6 para pesquisar usuário pelo nome");
			System.out.println("Digite 0 para sair");

			opc = Leitor.readInt("Digite sua opção: ");

			switch (opc) {
			case MENU_INCLUIR:
				incluir();
				break;
			case MENU_ATUALIZAR:
				atualizar();
				break;
			case MENU_EXCLUIR:
				excluir();
				break;
			case MENU_LISTAR_TODOS:
				listar();
				break;
			case MENU_PESQUISA_ID:
				pesquisaId();
				break;
			case MENU_PESQUISA_NOME:
				pesquisaNome();
				break;
			case MENU_SAIR:
				titulo("Até logo!");
				break;
			default:
				titulo("Verifique sua opção");
			}
		} while (opc != 0);
	}

	public void incluir() {
		titulo("Incluir");
		
		String nome;
		String email;
		String senha;
		char sexo;
		int tipo;
		
		nome = Leitor.readString("Digite o nome do usuário: ");
		email = Leitor.readString("Digite o email do usuário: ");
		senha = Leitor.readString("Digite uma senha. Pode conter número, letra e caracteres especiais: ");
		sexo = Leitor.readChar("Digite o sexo do usuário (m/f/o): ");
		System.out.println("Digite 1 para adicionar um Administrador Geral");
		System.out.println("Digite 2 para adicionar um Administrador de Estabelecimento");
		tipo = Leitor.readInt("Digite 3 para adicionar um usuário do sistema: ");
		
		User user = null;
		if(tipo == 1) {
			user = new UserAdmin(nome, email, senha, sexo);
		}else if(tipo == 2) {
			user = new UserEstabelecimento(nome, email, senha, sexo);
		}else if(tipo == 3) {
			user = new UserPublic(nome, email, senha, sexo);
		}else {
			System.out.println("Tipo de usuário inválido. Operação cancelada.");
		}
		if( uc.incluir(user) ) {
			System.out.println("Novo usuário registrado com sucesso.");
		}else {
			System.out.println("Erro ao cadastrar usuário.");
		}
		
		
	}
	public void atualizar() {
		titulo("Atualizar");
		
		List<User> lu = uc.listarUsuarios();

		if (lu == null) {
			System.out.println("Erro");
		} else if (lu.isEmpty()) {
			System.out.println("Lista vazia");
		} else {
			for (User usuario : lu) {
				int tipo;
				String nomeTipo;
				if (usuario instanceof UserPublic) {
					tipo = 3;
					nomeTipo = "Usuário Final";
				}
				else if (usuario instanceof UserEstabelecimento) {
					tipo = 2;
					nomeTipo = "Administrador de Estabelecimento";
				}else {
					tipo = 1;
					nomeTipo = "Administrador Geral";
				}
				String sexo;
				if(usuario.getSexo() == 'm') {
					sexo = "Masculino";
				}else if(usuario.getSexo() == 'f') {
					sexo = "Feminino";
				}else {
					sexo = "Outros";
				}
				System.out.print("ID: ["+usuario.getIdUsuario()+"] - Nome: " + usuario.getNomeUsuario() + " - Email: " + usuario.getEmailUsuario() + " - Tipo: "+nomeTipo + "["+tipo+"]");
				System.out.println(" - Sexo: " + sexo + " - Data de cadastro: " + usuario.getDataCadastro());
				System.out.println("==========================================");
			}
		}
		int entraId = Leitor.readInt("Digite o ID do usuário que deseja atualizar: ");
		
		User usuario = uc.pesquisar(entraId);
		
		String nome;
		String email;
		String senha;
		String s;
		char sexo;
		
		nome = Leitor.readString("Digite o novo nome. Deixe em branco e digite ENTER para não alterar: ");
		email = Leitor.readString("Digite o novo email. Deixe em branco e digite ENTER para não alterar: ");
		senha = Leitor.readString("Digite a nova senha. Deixe em branco e digite ENTER para não alterar: ");
		s = String.valueOf(Leitor.readString("Digite o novo sexo (m/f/o). Deixe em branco e digite ENTER para não alterar: "));
		if(!nome.isEmpty() ) {
			usuario.setNomeUsuario(nome);
		}
		if(!email.isEmpty()) {
			usuario.setEmailUsuario(email);
		}
		if(!senha.isEmpty()) {
			usuario.setSenha(senha);
		}
		if(!s.isEmpty()) {
			sexo = s.charAt(0);
			usuario.setSexo(sexo);
		}
		
		uc.atualizar(usuario);
	}
	public void excluir() {
		titulo("Excluir");
		
		List<User> lu = uc.listarUsuarios();

		if (lu == null) {
			System.out.println("Erro");
		} else if (lu.isEmpty()) {
			System.out.println("Lista vazia");
		} else {
			for (User usuario : lu) {
				int tipo;
				String nomeTipo;
				if (usuario instanceof UserPublic) {
					tipo = 3;
					nomeTipo = "Usuário Final";
				}
				else if (usuario instanceof UserEstabelecimento) {
					tipo = 2;
					nomeTipo = "Administrador de Estabelecimento";
				}else {
					tipo = 1;
					nomeTipo = "Administrador Geral";
				}
				String sexo;
				if(usuario.getSexo() == 'm') {
					sexo = "Masculino";
				}else if(usuario.getSexo() == 'f') {
					sexo = "Feminino";
				}else {
					sexo = "Outros";
				}
				System.out.print("ID: ["+usuario.getIdUsuario()+"] - Nome: " + usuario.getNomeUsuario() + " - Email: " + usuario.getEmailUsuario() + " - Tipo: "+nomeTipo + "["+tipo+"]");
				System.out.println(" - Sexo: " + sexo + " - Data de cadastro: " + usuario.getDataCadastro());
				System.out.println("==========================================");
			}
		}
		
		int id = Leitor.readInt("Digite o ID do usuário que você deseja excluir: ");
		
		User usuario = uc.pesquisar(id);
		
		if(usuario == null) {
			System.out.println("Nenhum usuário encontrado com este ID.");
		}else {
			int tipo;
			String nomeTipo;
			if (usuario instanceof UserPublic) {
				tipo = 3;
				nomeTipo = "Usuário Final";
			}
			else if (usuario instanceof UserEstabelecimento) {
				tipo = 2;
				nomeTipo = "Administrador de Estabelecimento";
			}else {
				tipo = 1;
				nomeTipo = "Administrador Geral";
			}
			String sexo;
			if(usuario.getSexo() == 'm') {
				sexo = "Masculino";
			}else if(usuario.getSexo() == 'f') {
				sexo = "Feminino";
			}else {
				sexo = "Outros";
			}
			System.out.print("Nome: " + usuario.getNomeUsuario() + " - Email: " + usuario.getEmailUsuario() + " - Tipo: "+nomeTipo + "["+tipo+"]");
			System.out.println(" - Sexo: " + sexo + " - Data de cadastro: " + usuario.getDataCadastro());
			System.out.println("==========================================");
		}

		String escolha = Leitor.readString("Tem certeza que deseja excluir? (s/n): ");
		if(escolha.equals("s") || escolha.equals("S")) {
			Boolean excluir = uc.excluir(id);
			if(excluir == true) {
				System.out.println("Usuário #["+ id +"] deletado com sucesso");
			}else {
				System.out.println("Houve um erro ao concluir a operação. Tente novamente em instantes.");
			}
		}else if(escolha.equals("n") || escolha.equals("N")) {
			System.out.println("Nenhum registro alterado.");
		}else {
			System.out.println("Opção inválida. Tente novamente");
			excluir();
		}
		
		
	}
	public void listar() {
		titulo("Listar");
		
		List<User> lu = uc.listarUsuarios();

		if (lu == null) {
			System.out.println("Erro");
		} else if (lu.isEmpty()) {
			System.out.println("Lista vazia");
		} else {
			for (User usuario : lu) {
				int tipo;
				String nomeTipo;
				if (usuario instanceof UserPublic) {
					tipo = 3;
					nomeTipo = "Usuário Final";
				}
				else if (usuario instanceof UserEstabelecimento) {
					tipo = 2;
					nomeTipo = "Administrador de Estabelecimento";
				}else {
					tipo = 1;
					nomeTipo = "Administrador Geral";
				}
				String sexo;
				if(usuario.getSexo() == 'm') {
					sexo = "Masculino";
				}else if(usuario.getSexo() == 'f') {
					sexo = "Feminino";
				}else {
					sexo = "Outros";
				}
				System.out.print("ID: ["+usuario.getIdUsuario()+"] - Nome: " + usuario.getNomeUsuario() + " - Email: " + usuario.getEmailUsuario() + " - Tipo: "+nomeTipo + "["+tipo+"]");
				System.out.println(" - Sexo: " + sexo + " - Data de cadastro: " + usuario.getDataCadastro());
				System.out.println("==========================================");
			}
		}
	}
	public void pesquisaId() {
		titulo("Pesquisar por ID");
		
		int id = Leitor.readInt("Digite o ID que deseja pesquisar: ");
		
		User usuario = uc.pesquisar(id);
		
		if(usuario == null) {
			System.out.println("Sua pesquisa não retornou nenhum resultado.");
		}else {
			int tipo;
			String nomeTipo;
			if (usuario instanceof UserPublic) {
				tipo = 3;
				nomeTipo = "Usuário Final";
			}
			else if (usuario instanceof UserEstabelecimento) {
				tipo = 2;
				nomeTipo = "Administrador de Estabelecimento";
			}else {
				tipo = 1;
				nomeTipo = "Administrador Geral";
			}
			String sexo;
			if(usuario.getSexo() == 'm') {
				sexo = "Masculino";
			}else if(usuario.getSexo() == 'f') {
				sexo = "Feminino";
			}else {
				sexo = "Outros";
			}
			System.out.print("Nome: " + usuario.getNomeUsuario() + " - Email: " + usuario.getEmailUsuario() + " - Tipo: "+nomeTipo + "["+tipo+"]");
			System.out.println(" - Sexo: " + sexo + " - Data de cadastro: " + usuario.getDataCadastro());
			System.out.println("==========================================");
		}
	}
	public void pesquisaNome() {
		titulo("Pesquisar por Nome");
		
		String nome = Leitor.readString("Digite o nome que deseja pesquisar: ");
		
		List<User> lu = uc.pesquisar(nome);
		
		if (lu == null) {
			System.out.println("Erro");
		} else if (lu.isEmpty()) {
			System.out.println("Lista vazia");
		} else {
			for (User usuario : lu) {
				int tipo;
				String nomeTipo;
				if (usuario instanceof UserPublic) {
					tipo = 3;
					nomeTipo = "Usuário Final";
				}
				else if (usuario instanceof UserEstabelecimento) {
					tipo = 2;
					nomeTipo = "Administrador de Estabelecimento";
				}else {
					tipo = 1;
					nomeTipo = "Administrador Geral";
				}
				String sexo;
				if(usuario.getSexo() == 'm') {
					sexo = "Masculino";
				}else if(usuario.getSexo() == 'f') {
					sexo = "Feminino";
				}else {
					sexo = "Outros";
				}
				System.out.print("Nome: " + usuario.getNomeUsuario() + " - Email: " + usuario.getEmailUsuario() + " - Tipo: "+nomeTipo + "["+tipo+"]");
				System.out.println(" - Sexo: " + sexo + " - Data de cadastro: " + usuario.getDataCadastro());
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
