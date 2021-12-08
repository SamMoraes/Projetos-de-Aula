package principal;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Empresa;
import entities.Funcionario;
import inputs.EmpresaInput;
import inputs.FuncionarioInput;
import repositories.EmpresaRepositoryCSV;
import repositories.EmpresaRepositoryTXT;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("\n *** EXPORTADOR DE DADOS *** \n");

		// Criando um objeto da classe EmpresaInput
		Empresa empresa = EmpresaInput.read();

		// inicializando a lista de funcionários do objeto empresa
		empresa.setFuncionarios(new ArrayList<Funcionario>());

		System.out.print("Qtd de funcionários desejado..: ");
		Integer qtd = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= qtd; i++) {

			System.out.println("\n" + i + "º Funcionário:");
			Funcionario funcionario = FuncionarioInput.read();

			// adicionando o funcionário na empresa
			empresa.getFuncionarios().add(funcionario);
		}

		// criando uma variavel de instancia para a classe do repositorio
		EmpresaRepositoryTXT empresaRepositoryTXT = new EmpresaRepositoryTXT();
		EmpresaRepositoryCSV empresaRepositoryCSV = new EmpresaRepositoryCSV();

		try {
			empresaRepositoryTXT.exportar(empresa);
			System.out.println("\nARQUIVO TXT GRAVADO COM SUCESSO.");

			empresaRepositoryCSV.exportar(empresa);
			System.out.println("\nARQUIVO CSV GRAVADO COM SUCESSO.");
		} catch (Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		}

	}

}
