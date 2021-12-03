package principal;

import entities.Cliente;
import entities.Endereco;

public class Program {

	public static void main(String[] args) {
		
		/*
		 * Pessoa pessoa = new Pessoa();
		 * 
		 * pessoa.setId(1); pessoa.setNome("Sergio Mendes");
		 * 
		 * 
		 * System.out.println("\nDados de Pessoa:\n"); System.out.println("\tId.....: "
		 * + pessoa.getId()); System.out.println("\tNome...: " + pessoa.getNome());
		 */
		
		Cliente cliente = new Cliente(1, "Ana Paula", "123.456.789-00", 
									"(21) 99999-9999", "anapaula@gmail.com");
		
		cliente.setEndereco(new Endereco(1, "Av Rio Branco 185", "Centro", "Rio de Janeiro", 
										"RJ", "200040-007"));

		System.out.println("\nDADOS DO CLIENTE:");
		System.out.println(cliente);
		System.out.println(cliente.getEndereco());


	}

}
