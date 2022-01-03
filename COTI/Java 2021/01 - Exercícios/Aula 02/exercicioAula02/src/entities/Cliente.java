package entities;

import java.util.Objects;

public class Cliente extends Pessoa{

	//DECLARACAO DE VARIAVEIS
	private String cpf;
	private String email;
	private String telefone;
	
	//associacao
	private Endereco endereco;
	
	//CONSTRUTOR VAZIO
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	//CONSTRUTOR CHEIO
	public Cliente(Integer id, String nome, String sobrenome, String cpf, String email, String telefone) {
		super(id, nome, sobrenome);
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	//GETS E SETS
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Cliente" + "\nid=" + super.getId() + "\nnome=" + super.getNome() + "\nsobrenmome=" + super.getSobrenome() + "\ncpf=" + cpf + "\nemail=" + email + "\ntelefone=" + telefone + 
				"\n\nEndereco do Cliente" + endereco;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, email, endereco, telefone);
		return result;
	}

	//HASHCODE E EQUALS
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(telefone, other.telefone);
	}
	
	
	
	
	
	
}
