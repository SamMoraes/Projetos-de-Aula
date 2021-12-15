package principal;

import entities.Cliente;
import inputs.ClienteInput;
import repositories.ClienteRepository;

public class Program {

	public static void main(String[] args) {

		try {

			System.out.println("\nCADASTRO DE CLIENTE:\n");
			
			Cliente cliente = new Cliente();
			
			cliente.setNome(ClienteInput.lerNome());
			cliente.setEmail(ClienteInput.lerEmail());
			cliente.setCpf(ClienteInput.lerCpf());
			
			//cadastrar no bd
			ClienteRepository clienteRepository = new ClienteRepository();
			clienteRepository.create(cliente);
			System.out.println("CLIENTE GRAVADO COM SUCESSO!");
		} 
		catch (Exception e) {
			// imprimir mensagem de erro
			System.out.println("\nErro: " + e.getMessage());
		}
	}

}
