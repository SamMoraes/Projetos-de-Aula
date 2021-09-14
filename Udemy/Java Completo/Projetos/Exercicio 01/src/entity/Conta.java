package entity;

import exceptions.DomainException;

public class Conta {

	private Integer numConta;
	private String titular;
	private Double saldo;
	private Double limiteSaque;
	

	
		
	
	public void Deposito(Double deposito) {
		deposito += saldo;
	}
	
	public void Saque(Double saque) throws DomainException {
		
		
		if(saque > saldo) {
			throw new DomainException("Saldo insuficiente");
		}
		if (saque > limiteSaque) {
			throw new DomainException("Limite de saque excedido");
		}
		
		saldo -= saque;
		
		
	}
	
	
	public Conta() {
		
	}

	public Conta(Integer numConta, String titular, Double saldo, Double limiteSaque, Double saque, Double deposito) {
		this.numConta = numConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumConta() {
		return numConta;
	}

	public void setNumConta(Integer numConta) {
		this.numConta = numConta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public Double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return 	"\n" + "Número da conta: " + numConta + 
				"\n" + "Titular: " + titular +  
				"\n" + "Limite de saque atual: " + limiteSaque +
				"\n" + " Saldo atual=" + saldo;
	}

	
	
	
	}
	
	

