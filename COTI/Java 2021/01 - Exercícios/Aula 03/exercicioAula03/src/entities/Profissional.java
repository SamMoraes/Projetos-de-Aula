package entities;

import java.util.List;
import java.util.Objects;

public class Profissional {

	//DELCARACAO DE VARIAVEIS
	private Integer idProfissional;
	private String nome;
	private String cpf;
	private String telefone;
	
	private List<Servico> servico;
	
	//CONSTRUTOR VAZIO
	public Profissional() {
		// TODO Auto-generated constructor stub
	}

	//CONSTRUTOR CHEIO
	public Profissional(Integer idProfissional, String nome, String cpf, String telefone) {
		super();
		this.idProfissional = idProfissional;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	//GETS E SETS
	public Integer getIdProfissional() {
		return idProfissional;
	}

	public void setIdProfissional(Integer idProfissional) {
		this.idProfissional = idProfissional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Profissional [idProfissional=" + idProfissional + ", nome=" + nome + ", cpf=" + cpf + ", telefone="
				+ telefone + "]";
	}

	//HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(cpf, idProfissional, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(idProfissional, other.idProfissional)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}
	
	
	 
}
