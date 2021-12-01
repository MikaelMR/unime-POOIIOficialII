
public class GuildaConnect {

	public static void main(String[] args) {
		BD bd = new BD();
		bd.conectar();
		
		BDAventureiro bdAV = new BDAventureiro(bd);
		
		TelaGuildaLista telaGuildaLista = new TelaGuildaLista(bdAV);
		telaGuildaLista.setVisible(true);
	}

}
