package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Empresa;
import entities.Funcionario;

public class EmpresaRepositoryCSV {

	public void exportar(Empresa empresa) throws Exception {
		
		PrintWriter print = new PrintWriter(new File("c:\\temp\\empresa.csv"));
		
		//escrever os dados da empresa
		print.write(empresa.getIdEmpresa() + ";");
		print.write(empresa.getNomeFantasia() + ";");
		print.write(empresa.getRazaoSocial() + ";");
		print.write(empresa.getCnpj() + "\n");
		
		//escrever os dados dos funcionários
		for(Funcionario funcionario : empresa.getFuncionarios()) {
			
			print.write(funcionario.getIdFuncionario() + ";");
			print.write(funcionario.getNome() + ";");
			print.write(funcionario.getSalario() + ";");
			print.write(funcionario.getCpf() + "\n");			
		}
		
		print.flush();
		print.close();
	}
	
}

