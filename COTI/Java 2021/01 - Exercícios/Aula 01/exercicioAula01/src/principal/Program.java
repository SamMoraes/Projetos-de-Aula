package principal;

import javax.swing.JOptionPane;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class Program {

	public static void main(String[] args) {
		
		 try {
			 Funcionario f = new Funcionario();
				
				JOptionPane.showMessageDialog(null, "Insira os dados do funcionário");
				f.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID do Funcionário:")));
				f.setNome(JOptionPane.showInputDialog("Entre com o nome do funcionário:"));
				f.setCpf(JOptionPane.showInputDialog("Insira o CPF do funcionário:"));
				f.setMatricula(JOptionPane.showInputDialog("Insira a matricula do funcionário"));
				f.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Insira o salário do funcionário:")));
				
				FuncionarioRepository fr = new FuncionarioRepository();
				
				fr.gravarArquivo(f);
				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		
	}

}
