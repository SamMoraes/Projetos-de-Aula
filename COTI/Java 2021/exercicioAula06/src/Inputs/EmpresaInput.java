package Inputs;

import javax.swing.JOptionPane;

public class EmpresaInput {

	public static Integer lerIdEmpresa() {

		return Integer.parseInt(JOptionPane.showInputDialog("Informe o ID da empresa"));

	}

	public static String lerNomeFantasia() {

		return JOptionPane.showInputDialog("Informe o nome fantasia da empresa");

	}
	
	public static String lerRazaoSocial() {

		return JOptionPane.showInputDialog("Informe a razão social da empresa");

	}
	
	public static String lerCNPJ() {

		return JOptionPane.showInputDialog("Informe o CNPJ da empresa");

	}
}
