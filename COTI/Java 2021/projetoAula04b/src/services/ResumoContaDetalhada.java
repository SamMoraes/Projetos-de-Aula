package services;

import java.util.Date;

import abstractions.ResumoConta;
import entities.Conta;

public class ResumoContaDetalhada extends ResumoConta {

	@Override
	public void imprimirDados(Conta conta) {
		System.out.println("\n *** RESUMO DE CONTA DETALHADA");

		System.out.println("ID......: " + conta.getIdConta());
		System.out.println("NOME....: " + conta.getNome());
		System.out.println("VALOR...: " + conta.getValor());
		System.out.println("TIPO....: " + conta.getTipo());
		System.out.println("TIPO....: " + new Date());
		System.out.println("USUÁRIO...: COTI INFORMÁTICA" );

		

	}

}
