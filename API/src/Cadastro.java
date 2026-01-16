import java.util.Scanner;

public class Cadastro {

	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados();
		Scanner texto = new Scanner(System.in);
		bd.conectar();
		if(bd.estaConectado()) {
			//System.out.println("Digite o nome: ");
			//String nome = texto.nextLine();
			//System.out.println("Digite o telefone: ");
			//String telefone = texto.nextLine();
			String nome = "Jackson";
			String telefone = "85 985841256";
			String endereco = "Rua X 321";
			bd.inserirCliente(nome,telefone,endereco);
			//bd.editarContato("1", "Jalim", "85 985231456");
			//bd.apagarContato("5");
			bd.listarcliente();
			System.out.println("\n");
			bd.listarcardapio();
			System.out.println("\n");
			bd.listarbebidas();
			System.out.println("n");
			
			//bd.desconectar();
		}else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
	}
}