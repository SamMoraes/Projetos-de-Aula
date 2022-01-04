package entities;

import java.util.Objects;

public class Servico {

	//DELCARACAO DE VARIAVEIS
	private Integer idServico;
	private String nome;
	private String descricao;
	private Double preco;
	
	//CONSTRUTOR VAZIO
	public Servico() {
		// TODO Auto-generated constructor stub
	}

	//CONSTRUTOR CHEIO
	public Servico(Integer idServico, String nome, String descricao, Double preco) {
		super();
		this.idServico = idServico;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	//GETS E SETS
	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Servico [idServico=" + idServico + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ "]";
	}

	//HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(descricao, idServico, nome, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servico other = (Servico) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(idServico, other.idServico)
				&& Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco);
	}
	
		
}
