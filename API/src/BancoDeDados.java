import java.sql.Connection; //conexão
import java.sql.DriverManager; //driver
import java.sql.ResultSet; //resultados(select)
import java.sql.Statement; //consultas
class BancoDeDados {
	private Connection connection = null; //armazena a conexão
	private Statement statement = null; //armazena as consultas
	private ResultSet resultset = null; //armazena os resultados
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/pizzaria"; //caminho
		String usuario = "root"; //usuario
		String senha = "Aluno"; //senha
		String driver = "com.mysql.cj.jdbc.Driver"; //caminho do driver
		try {
			Class.forName(driver); //acessa o driver
			this.connection = DriverManager.getConnection(servidor,usuario,senha);
			this.statement = this.connection.createStatement(); //consultas
		}catch(Exception e) {
			System.out.println("Error:"+e.getMessage());
			
		}
	}
	public boolean estaConectado() {
		if(this.connection!=null) {
			return true;
		}else {
			return false;
		}
	}
	public void listarcliente() {
		try {
			String query = "select * From cliente";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("ID:"+this.resultset.getString("id")+"Nome:"+this.resultset.getString("nome")+"Telefone:"+this.resultset.getString("telefone")+"Endereço:"+this.resultset.getString("endereco"));
			}
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	public void listarcardapio() {
		try {
			String query = "select * From cardapio";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("ID:"+this.resultset.getString("id")+"Pizza:"+this.resultset.getString("pizza")+"Ingrediente:"+this.resultset.getString("ingrediente")+"Valor:"+this.resultset.getString("valor")+"Taxa:"+this.resultset.getString("taxa"));
			}
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	public void listarbebidas() {
		try {
			String query = "select * From bebidas";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("ID:"+this.resultset.getString("id")+"Refri:"+this.resultset.getString("refri")+"Suco:"+this.resultset.getString("suco")+"Sabor:"+this.resultset.getString("sabor")+"Valor:"+this.resultset.getString("valor"));
			}
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	public void inserirCliente(String nome,String telefone,String endereco) {
		try {
			String query = "insert into cliente(nome,telefone,endereco) values('"+nome+"','"+telefone+"','"+endereco+"');";
			this.statement.executeUpdate(query);
			
		}catch(Exception e) {
			System.out.println("Error:"+e.getLocalizedMessage());
		}
	}
	public void inserirComanda(String produto,Double valor) {
		try {
			String query = "insert into comanda(produto,valor) values('"+produto+"','"+valor+"');";
			this.statement.executeUpdate(query);
			
		}catch(Exception e) {
			System.out.println("Error:"+e.getLocalizedMessage());
		}
	}
		public void editarCliente(String id, String nome, String telefone) {
			try {
				String query = "update contado set nome = '"+nome+"',telefone = '"+telefone+"'where id = '"+id+"'";
				this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		public void apagarContato(String id) {
			try {
			String query = "delete from contado where id='"+id+"'";
			this.statement.executeUpdate(query);
			}catch(Exception e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
}
		//public void desconectar() {
			//try {
				//this.connection.close();
				//System.out.println("Banco de Dados desconectado");
			//}catch(Exception e) {
				//System.out.println("Erro"+e.getMessage());
		