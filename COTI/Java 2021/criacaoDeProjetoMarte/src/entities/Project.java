package entities;

public class Project {

	private String nome;

	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + "]";
	}
	
	
}
