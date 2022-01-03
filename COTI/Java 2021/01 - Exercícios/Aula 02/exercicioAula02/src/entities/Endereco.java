package entities;

import java.util.Objects;

public class Endereco {

	//DECLARACAO DE VARIAVEIS
	private Integer id;
	private String logradouro;
	private String complemento;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	
	//CONSTRUTOR VAZIO
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	//CONSTRUTOR CHEIO
	public Endereco(Integer id, String logradouro, String complemento, String numero, String bairro, String cidade,
			String estado, String cep) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	//GETS E SETS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "\nEndereco \nid=" + id + "\nlogradouro=" + logradouro + "\ncomplemento=" + complemento + "\nnumero="
				+ numero + "\nbairro=" + bairro + "\ncidade=" + cidade + "\nestado=" + estado + "\ncep=" + cep;
	}

	//HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, estado, id, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero);
	}
	
	
}
