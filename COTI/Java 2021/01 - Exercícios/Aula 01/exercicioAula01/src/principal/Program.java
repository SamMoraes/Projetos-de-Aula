package principal;

import javax.swing.JOptionPane;

import entities.Funcionario;
import repositories.FuncionarioRepository;

public class Program {

	public static void main(String[] args) {
		
		 try {
			 Funcionario f = new Funcionario();
				
				JOptionPane.showMessageDialog(null, "Insira os dados do funcion�rio");
				f.setIdFuncionario(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID do Funcion�rio:")));
				f.setNome(JOptionPane.showInputDialog("Entre com o nome do funcion�rio:"));
				f.setCpf(JOptionPane.showInputDialog("Insira o CPF do funcion�rio:"));
				f.setMatricula(JOptionPane.showInputDialog("Insira a matricula do funcion�rio"));
				f.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Insira o sal�rio do funcion�rio:")));
				
				FuncionarioRepository fr = new FuncionarioRepository();
				
				fr.gravarArquivo(f);
				
		} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
		
	}

}
