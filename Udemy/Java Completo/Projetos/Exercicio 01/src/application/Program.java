package application;

import java.util.Scanner;

import entity.Conta;
import exceptions.DomainException;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Digite os dados da conta");
			System.out.println("Insira o numero da conta");
			int numConta = sc.nextInt();
			System.out.println("Insira o nome do Titular");
			String titular = sc.next();
			System.out.println("Insira o saldo inicial");
			double saldo = sc.nextDouble();
			System.out.println("Insira o limite de saque");
			double limiteSaque = sc.nextDouble();
			System.out.println("\n" + "Insira o valor para o saque");
			double saque = sc.nextDouble();
			
			Conta c = new Conta(numConta, titular, saldo, limiteSaque, null, saque);
			
			c.Saque(saque);
			System.out.println("Novo saldo em conta" + c);
		}
		catch (DomainException e) {
			 System.out.println("Erro em saque: " + e.getMessage());
		 }
		 catch (RuntimeException e) {
			 System.out.println("Unexpected error");
		 }
		 sc.close();
		
	}

}
