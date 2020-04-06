package concessionaria;

public class Cliente {
	private String nome, endereco, cidade, rg, cep, estado;

	public Cliente(String nome, String endereco, String cidade, String rg, String cep, Object estado) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
		this.rg = rg;
		this.cep = cep;
		this.estado = (String) estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
