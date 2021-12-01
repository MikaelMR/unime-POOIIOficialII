import java.sql.ResultSet;
import java.util.ArrayList;

public class BDAventureiro {
	private BD bd;

	public BDAventureiro(BD bd) {
		this.bd = bd;
	}
	
	public void cadastrar(Aventureiro aventureiro) {
		String query = "INSERT INTO "
					 + "aventureiros "
					 + "(nome, idade, classe, nivel, raca) "
					 + "VALUES "
					 + "('" + aventureiro.getNome() + "', "
					 + "'" + aventureiro.getIdade() + "', "
					 + "'" + aventureiro.getClasse() + "', "
					 + "'" + aventureiro.getNivel() + "', "
					 + "'" + aventureiro.getRaca() + "');";
		this.bd.executeUpdate(query);
	}
	
	public Aventureiro obter(int id) {
		String query = "SELECT * FROM aventureiros WHERE id = " + id + ";";
		ResultSet dados = this.bd.executeQuery(query);
		Aventureiro aventureiro = new Aventureiro();
		try {
			dados.next();
			aventureiro.setId(dados.getInt("id"));
			aventureiro.setNome(dados.getString("nome"));
			aventureiro.setIdade(dados.getString("idade"));
			aventureiro.setClasse(dados.getString("classe"));
			aventureiro.setNivel(dados.getString("nivel"));
			aventureiro.setRaca(dados.getString("raca"));
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return aventureiro;
	}
	
	public ArrayList<Aventureiro> listar() {
		String query = "SELECT * FROM aventureiros;";
		ResultSet dados = this.bd.executeQuery(query);
		ArrayList<Aventureiro> aventureiroL = new ArrayList<>();
		try {
			while(dados.next()) {
				Aventureiro aventureiro = new Aventureiro();
				aventureiro.setId(dados.getInt("id"));
				aventureiro.setNome(dados.getString("nome"));
				aventureiro.setIdade(dados.getString("idade"));
				aventureiro.setClasse(dados.getString("classe"));
				aventureiro.setNivel(dados.getString("nivel"));
				aventureiro.setRaca(dados.getString("raca"));
				aventureiroL.add(aventureiro);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return aventureiroL;
	}

	public void excluir(int id) {
		String query = "DELETE FROM aventureiros WHERE id = " + id + ";";
		this.bd.executeUpdate(query);
	}

	public void editar(Aventureiro aventureiro) {
		String query = "UPDATE aventureiros SET "
				     + "nome = '" + aventureiro.getNome() + "', "
				     + "idade = '" + aventureiro.getIdade() + "', "
				     + "classe = '" + aventureiro.getClasse() + "', "
				     + "nivel = '" + aventureiro.getNivel() + "', "
				     + "raca = '" + aventureiro.getRaca() + "' "
				     + "WHERE id = " + aventureiro.getId() + ";";
		this.bd.executeUpdate(query);
	}
}
