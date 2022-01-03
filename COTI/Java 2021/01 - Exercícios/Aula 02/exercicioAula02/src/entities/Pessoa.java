package entities;

import java.util.Objects;

public class Pessoa {

	//DECLARACAO DE VARIAVEIS
	private Integer id;
	private String nome;
	private String sobrenome;
	
	//CONSTRUTOR VAZIO
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	//CONSTRUTOR CHEIO
	public Pessoa(Integer id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	//GETS E SETS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}

	//HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(id, nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(sobrenome, other.sobrenome);
	}
	
	
	
}
