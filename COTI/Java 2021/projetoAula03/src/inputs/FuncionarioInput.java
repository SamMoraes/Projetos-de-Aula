package inputs;

import java.util.Scanner;

import entities.Funcionario;

public class FuncionarioInput {

	public static Funcionario read() {
		
		Scanner scanner = new Scanner(System.in);
		Funcionario funcionario = new Funcionario();
		
		System.out.println("ENTREW COM OS DADOS DO FUNCION�RIO");
		
		System.out.print("ID do funcion�rio.......:");
		funcionario.setIdFuncionario(Integer.parseInt(scanner.nextLine()));
		
		System.out.print("Nome do funcion�rio");
		funcionario.setNome(scanner.nextLine());
		
		System.out.print("Sal�rio do funcionpario");
		funcionario.setSalario(Double.parseDouble(scanner.nextLine()));
		
		System.out.print("CPF do funcionpario");
		funcionario.setCpf(scanner.nextLine());
		
		
		
		return funcionario;
	}
}
