package principal;

import entities.Cliente;
import persistence.ClientePersistence;

public class Program {

	public static void main(String[] args) {

		System.out.println("Java");
		
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(1);
		cliente.setNome("Samuel");
		cliente.setEmail("samuel@gmail.com");
		cliente.setTelefone("21993134119");
		
		/*
		 * System.out.println("\nDADOS DO CLIENTE:");
		 * System.out.println("\tID DO CLIENTE: " + cliente.getIdCliente());
		 * System.out.println("\tNOME.........: " + cliente.getNome());
		 * System.out.println("\tEMAIL........: " + cliente.getEmail());
		 * System.out.println("\tTELEFONE.....: " + cliente.getTelefone());
		 */
		
		ClientePersistence persistence = new ClientePersistence();
				persistence.exportarDados(cliente);
				
	}
}
