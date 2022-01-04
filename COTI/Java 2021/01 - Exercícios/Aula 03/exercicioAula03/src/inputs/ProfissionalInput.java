package inputs;

import java.util.Scanner;

import entities.Profissional;

public class ProfissionalInput {

	public static Profissional inputProfissional() {
		
		try {
			
		Scanner scanner = new Scanner(System.in);
		Profissional p = new Profissional();
		
		System.out.println("INSIRA OS DADOS DO PROFISSIONAL: ");
		
		System.out.println("ID do profissional...........: ");
		p.setIdProfissional(Integer.parseInt(scanner.nextLine()));
		System.out.println("Nome do profissional.........: ");
		p.setNome(scanner.nextLine());
		System.out.println("CPF do profissional..........: ");
		p.setCpf(scanner.nextLine());
		System.out.println("Telefone do profissional.....: ");
		p.setTelefone(scanner.nextLine());
		
		return p;
				
		} catch (Exception e) {
			System.out.println("\nErro:" + e.getMessage());
		}
		return null;
	}
}
