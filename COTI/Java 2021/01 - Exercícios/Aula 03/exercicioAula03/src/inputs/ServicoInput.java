package inputs;

import java.util.Scanner;

import entities.Servico;

public class ServicoInput {

	
	public static Servico inputServico() {
		
		try {
			
		Scanner scanner = new Scanner(System.in);
		Servico s = new Servico();
	
		System.out.println("INSIRA COM OS DADOS DO SERVICO");
		
		System.out.println("ID do serviço................:");
		s.setIdServico(Integer.parseInt(scanner.nextLine()));
		System.out.println("Nome do serviço..............:");
		s.setNome(scanner.nextLine());
		System.out.println("Descrição do serviço.........:");
		s.setDescricao(scanner.nextLine());
		System.out.println("Preço do serviço.............:");
		s.setPreco(Double.parseDouble(scanner.nextLine()));
		
		return s;
			
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
		return null;
		
	}
}
