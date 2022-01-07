package principal;

import java.util.List;

import javax.swing.JOptionPane;

import entities.Aluno;
import inputs.AlunoInput;
import repositories.AlunoRepository;

public class Program {

	public static void main(String[] args) {

		try {
			
			Integer opcao = Integer.parseInt(JOptionPane.showInputDialog("\nSISTEMA DE CONTROLE DE ALUNOS\n"
					+ "\n INSIRA (1) PARA CADASTRAR UM ALUNO   " + "\n INSIRA (2) PARA ATUALIZAR UM ALUNO   "
					+ "\n INSIRA (3) PARA EXCLUIR UM ALUNO   " + "\n INSIRA (4) PARA CONSULTAR UM ALUNO   "));

			if (opcao == 1) {

				JOptionPane.showMessageDialog(null, "Você selecionou cadastro de aluno");

				Aluno aluno = new Aluno();

				aluno.setNome(AlunoInput.lerNome());
				aluno.setMatricula(AlunoInput.lerMatricula());
				aluno.setCpf(AlunoInput.lerCpf());

				AlunoRepository ar = new AlunoRepository();
				ar.create(aluno);

				 JOptionPane.showMessageDialog(null, "ALUNO CADASTRADO COM SUCESSO"); 

			}
			if (opcao == 2) {

				JOptionPane.showMessageDialog(null, "Você selecionou atualização de aluno");

				Aluno aluno = new Aluno();

				aluno.setIdAluno(AlunoInput.lerIdAluno());
				aluno.setNome(AlunoInput.lerNome());
				aluno.setMatricula(AlunoInput.lerMatricula());
				aluno.setCpf(AlunoInput.lerCpf());

				AlunoRepository ar = new AlunoRepository();
				ar.update(aluno);

				JOptionPane.showMessageDialog(null, "ALUNO ATUALIZADO COM SUCESSO");

			} else if (opcao == 3) {

				JOptionPane.showMessageDialog(null, "Você selecionou exclusão de aluno");

				Aluno aluno = new Aluno();

				aluno.setIdAluno(AlunoInput.lerIdAluno());

				AlunoRepository ar = new AlunoRepository();
				ar.delete(aluno);

				JOptionPane.showMessageDialog(null, "ALUNO EXCLUIDO COM SUCESSO");

			} else if (opcao == 4) {

				JOptionPane.showMessageDialog(null, "Você selecionou consulta de aluno");

				AlunoRepository ar = new AlunoRepository();
				List<Aluno> lista = ar.findAll(null);
				
				for(Aluno a : lista) {
					JOptionPane.showMessageDialog(null, a.toString());
				}

			} else {
							
				throw new Exception("Opção inválida.");	
				
			}

		} catch (Exception e) {
			
			 JOptionPane.showMessageDialog(null, "\nErro: " + e.getMessage()); 
			
			System.out.println("\nErro: " + e.getMessage());
		}

	}
}
