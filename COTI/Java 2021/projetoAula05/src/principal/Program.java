package principal;

import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import inputs.ClienteInput;
import repositories.ClienteRepository;

public class Program {

	public static void main(String[] args) {

try {
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("\n *** SISTEMA DE CONTROLE DE CLIENTES *** \n");
			System.out.println("(1) CADASTRAR CLIENTE");
			System.out.println("(2) ATUALIZAR CLIENTE");
			System.out.println("(3) EXCLUIR CLIENTE");
			System.out.println("(4) CONSULTAR CLIENTES");

			System.out.print("\nEscolha uma opção: ");
			Integer opcao = Integer.parseInt(scanner.nextLine());
			
			if(opcao == 1) {
				
				System.out.println("\nCADASTRO DE CLIENTE:\n");
				
				Cliente cliente = new Cliente();
				
				cliente.setNome(ClienteInput.lerNome());
				cliente.setEmail(ClienteInput.lerEmail());
				cliente.setCpf(ClienteInput.lerCpf());
				
				//cadastrando no banco de dados
				ClienteRepository clienteRepository = new ClienteRepository();
				clienteRepository.create(cliente);
			
				System.out.println("\nCLIENTE CADASTRADO COM SUCESSO!");				
			}
			if(opcao == 2) {
				
				System.out.println("\nATUALIZAÇÃO DE CLIENTE:\n");

				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(ClienteInput.lerIdCliente());
				cliente.setNome(ClienteInput.lerNome());
				cliente.setEmail(ClienteInput.lerEmail());
				cliente.setCpf(ClienteInput.lerCpf());
				
				//atualizando no banco de dados
				ClienteRepository clienteRepository = new ClienteRepository();
				clienteRepository.update(cliente);
				
				System.out.println("\nCLIENTE ATUALIZADO COM SUCESSO!");	
			}
			else if(opcao == 3) {
				
				System.out.println("\nEXCLUSÃO DE CLIENTE:\n");

				Cliente cliente = new Cliente();
				
				cliente.setIdCliente(ClienteInput.lerIdCliente());
				
				//excluindo no banco de dados
				ClienteRepository clienteRepository = new ClienteRepository();
				clienteRepository.delete(cliente);		
				
				System.out.println("\nCLIENTE EXCLUIDO COM SUCESSO!");
			}

			else if(opcao == 4) {
				
				System.out.println("\nCONSULTA DE CLIENTES:\n");
				ClienteRepository clienteRepository = new ClienteRepository();
				List<Cliente> lista = clienteRepository.findAll(null);
				
				for(Cliente cliente : lista) {					
					System.out.println(cliente.toString());					
				}

			}
			else {
				
				//lançar uma exceção (redirecionar para o catch!)
				throw new Exception("Opção inválida.");
			}
		} 
		catch (Exception e) {
			// imprimir mensagem de erro
			System.out.println("\nErro: " + e.getMessage());
		}


	}

}
