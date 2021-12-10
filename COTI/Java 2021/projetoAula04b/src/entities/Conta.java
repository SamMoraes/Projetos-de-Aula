package entities;

import enums.TipoConta;

public class Conta {

	private Integer idConta;
	private String nome;
	private Double valor;
	
	private TipoConta tipo;
	
	public Conta() {
		
	}

	public Conta(Integer idConta, String nome, Double valor, TipoConta tipo) {
		super();
		this.idConta = idConta;
		this.nome = nome;
		this.valor = valor;
		this.tipo = tipo;
	}

	public Integer getIdConta() {
		return idConta;
	}

	public void setIdConta(Integer idConta) {
		this.idConta = idConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", nome=" + nome + ", valor=" + valor + ", tipo=" + tipo + "]";
	}
	
	
}
