package services;

import abstractions.ResumoConta;
import entities.Conta;

public class ResumoContaSimples extends ResumoConta{

	@Override
	public void imprimirDados(Conta conta) {
		System.out.println("\n *** RESUMO DE CONTA SIMPLES");
		
		System.out.println("ID......: " + conta.getIdConta());
		System.out.println("NOME....: " + conta.getNome());
		System.out.println("VALOR...: " + conta.getValor());
		System.out.println("TIPO....: " + conta.getTipo());
		
	}

}
