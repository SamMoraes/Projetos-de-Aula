package inputs;

import javax.swing.JOptionPane;

public class AlunoInput {

	public static Integer lerIdAluno() {

		return Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do Aluno"));

	}

	public static String lerNome() {

		return JOptionPane.showInputDialog("Informe o nome do Aluno");

	}
	
	public static String lerMatricula() {

		return JOptionPane.showInputDialog("Informe a matricula do Aluno");

	}
	
	public static String lerCpf() {

		return JOptionPane.showInputDialog("Informe o CPF do Aluno");

	}
}
