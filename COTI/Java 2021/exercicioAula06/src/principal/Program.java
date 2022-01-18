package principal;

import javax.swing.JOptionPane;

import Inputs.EmpresaInput;
import entities.Empresa;
import repositories.EmpresaRepositoryJSON;
import repositories.EmpresaRepositoryXML;

public class Program {

	public static void main(String[] args) {

		try {
			Empresa empresa = new Empresa();
			EmpresaRepositoryXML xml = new EmpresaRepositoryXML();
			EmpresaRepositoryJSON json = new EmpresaRepositoryJSON();

			JOptionPane.showMessageDialog(null, "INSIRA OS DADOS DA EMPRESA");

			empresa.setIdEmpresa(EmpresaInput.lerIdEmpresa());
			empresa.setNomeFantasia(EmpresaInput.lerNomeFantasia());
			empresa.setRazaoSocial(EmpresaInput.lerRazaoSocial());
			empresa.setCnpj(EmpresaInput.lerCNPJ());

			Integer opcao = Integer.parseInt(JOptionPane.showInputDialog("\nEXPORTAÇÃO DE ARQUIVO\n"
					+ "\n INSIRA (1) PARA EXPORTAR DADOS EM XML   " + "\n INSIRA (2) PARA EXPORTAR EM JSON"));
			
			if(opcao == 1) {
				JOptionPane.showMessageDialog(null, "Você selecionou a exportação em XML");
				xml.exportarDados(empresa);	
				
				JOptionPane.showMessageDialog(null, "ARQUIVO EXPORTADO COM SUCESSO");
			}
			else if(opcao == 2) {
				JOptionPane.showMessageDialog(null, "Você selecionou a exportação em JSON");
				json.exportarDados(empresa);
				
				JOptionPane.showMessageDialog(null, "ARQUIVO EXPORTADO COM SUCESSO");
			}

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}
