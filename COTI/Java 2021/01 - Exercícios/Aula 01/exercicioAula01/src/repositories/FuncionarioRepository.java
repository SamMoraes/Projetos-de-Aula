package repositories;

import java.io.File;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import entities.Funcionario;

public class FuncionarioRepository {

	public void gravarArquivo(Funcionario funcionario) {
		
		try {
			
			PrintWriter pw = new PrintWriter(new File("C:\\Git\\Projetos-de-Aula\\COTI\\Java 2021\\exercicioAula01\\Arquivo\\DADOS_DO_FUNCIONARIO.txt"));
			
			pw.write("\nDADOS DO FUNCIONÁRIO");
			pw.write("\n\tID............: " + funcionario.getIdFuncionario());
			pw.write("\n\tNome..........: " + funcionario.getNome());
			pw.write("\n\tCPF...........: " + funcionario.getCpf());
			pw.write("\n\tMatricula.....: " + funcionario.getMatricula());
			pw.write("\n\tSalário.......: " + funcionario.getSalario());
			
			pw.flush();
			pw.close();
			
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
}
