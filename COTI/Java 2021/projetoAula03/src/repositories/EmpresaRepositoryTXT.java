package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Empresa;
import entities.Funcionario;

public class EmpresaRepositoryTXT {

	// método para receber um objeto Empresa
	// e exportar os seus dados para um arquivo
	// de extensão .TXT
	public void exportar(Empresa empresa) throws Exception {

		PrintWriter print = new PrintWriter(new File("c:\\temp\\empresa.txt"));

		// imprimindo os dados da empresa:
		print.write("\nDADOS DA EMPRESA:\n");

		print.write("\nID DA EMPRESA.........: " + empresa.getIdEmpresa());
		print.write("\nNOME FANTASIA.........: " + empresa.getNomeFantasia());
		print.write("\nRAZÃO SOCIAL..........: " + empresa.getRazaoSocial());
		print.write("\nCNPJ..................: " + empresa.getCnpj());
		print.write("\nQTD DE FUNCIONÁRIOS...: " + empresa.getFuncionarios().size());

		// imprimindo os dados dos funcionários:
		print.write("\nDADOS DOS FUNCIONÁRIOS:\n");
		
		for(Funcionario funcionario : empresa.getFuncionarios()) {
			
			print.write("\nID DO FUNCIONÁRIO.....: " + funcionario.getIdFuncionario());
			print.write("\nNOME..................: " + funcionario.getNome());
			print.write("\nSALÁRIO...............: " + funcionario.getSalario());
			print.write("\nCPF...................: " + funcionario.getCpf());
			print.write("\n---");			
		}
		
		//salvar e fechar o arquivo
		print.flush();
		print.close();
	}

}
