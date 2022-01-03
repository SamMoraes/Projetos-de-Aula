package principal;

import entities.Cliente;
import entities.Endereco;

public class Program {

	public static void main(String[] args) {

		Cliente c = new Cliente(1, "Samuel", "Moraes", "123.123.123-00", "sm.smoraes@outlook.com", "21 993134119");
		c.setEndereco(new Endereco(1, "Rua Maia Lacerda", "apt301", "620", "Estácio", "Rio de Janeiro", "RJ", "20250000"));
		
		System.out.println("\nDADOS DO CLIENTE:");
		System.out.println(c.toString());

	}

}
