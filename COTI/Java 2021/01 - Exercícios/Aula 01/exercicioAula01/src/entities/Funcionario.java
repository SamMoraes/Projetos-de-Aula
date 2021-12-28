package entities;

import java.util.Objects;

public class Funcionario {

	//DECLARA플O DE ATRIBUTOS
	private Integer idFuncionario;
	private String nome;
	private String cpf;
	private String matricula;
	private Double salario;

	//DECLARA플O CONSTRUTOR VAZIO
	public Funcionario() {

	}

	//DECLARA플O CONSTRUTOR CHEIO
	public Funcionario(Integer idFuncionario, String nome, String cpf, String matricula, Double salario) {
		super();
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.cpf = cpf;
		this.matricula = matricula;
		this.salario = salario;
	}

	
	//DECLARA플O GET E SETS
	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	
	//DECLARA플O TOSTRING
	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nome=" + nome + ", cpf=" + cpf + ", matricula="
				+ matricula + ", salario=" + salario + "]";
	}
	
	//DECLARA플O HASHCODE E EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(cpf, idFuncionario, matricula, nome, salario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(idFuncionario, other.idFuncionario)
				&& Objects.equals(matricula, other.matricula) && Objects.equals(nome, other.nome)
				&& Objects.equals(salario, other.salario);
	}

}
