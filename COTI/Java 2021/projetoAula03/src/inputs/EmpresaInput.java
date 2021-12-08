package inputs;

import java.util.Scanner;

import entities.Empresa;

public class EmpresaInput {

	public static Empresa read() {
				
		Scanner scanner = new Scanner(System.in);
		Empresa empresa = new Empresa();
		
		System.out.println("ENTRE COM OS DADOS DA EMPRESA: ");
					
		System.out.print("ID da empresa...............:");
		empresa.setIdEmpresa(Integer.parseInt(scanner.nextLine()));
		
		System.out.print("Nome da Empresa.............: ");
		empresa.setNome(scanner.nextLine());
				
		System.out.print("Nome fantasia da Empresa......: ");
		empresa.setNomeFantasia(scanner.nextLine());
		
		System.out.print("Razão Social da empresa......:");
		empresa.setRazaoSocial(scanner.nextLine());
		
		System.out.print("CNPJ da empresa..............:");
		empresa.setCnpj(scanner.nextLine());
			
		
		
		return empresa;
	}
}
