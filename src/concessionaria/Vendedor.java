package concessionaria;

public class Vendedor {
	//Attributes
	private String nome;
	private String id;
	private String dataAdm;
	//Constructor
	public Vendedor(String nome, String id, String dataAdm) {
		super();
		this.nome = nome;
		this.id = id;
		this.dataAdm = dataAdm;
	}
	//Get Set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDataAdm() {
		return dataAdm;
	}
	public void setDataAdm(String dataAdm) {
		this.dataAdm = dataAdm;
	}
	
}
