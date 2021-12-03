package entities;

import java.util.Objects;

public class Cliente extends Pessoa{

	private String cpf;
	private String telefone;
	private String email;
	
	private Endereco endereco;
		
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	

	public Cliente(Integer id, String nome, String cpf, String telefone, String email) {
		super(id, nome);
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cliente [cpf=" + cpf + ", "
								+ "telefone=" + telefone + ", email=" + email + "]";

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, email, telefone);
		return result;
	}

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
				&& Objects.equals(telefone, other.telefone);
	}
	
	
}
