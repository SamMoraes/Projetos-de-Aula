package factories;

import java.io.File;

import javax.swing.JOptionPane;

import entities.Project;
import repositories.OmProjectRepository;
import repositories.TdProjectRepository;

public class ProjectFactory {

	// METODO PARA RECEBER E VALIDAR A ENTRADA DO NOME DO PROJETO E CRIAR O PROJETO TD
	public static void ProjectTdFactory() {

		// DIRETORIO DOS PROJETOS DE TD PARA TESTAGEM
		String PATH = "\\\\storage04\\FILESERVER\\TD\\TD_PROJETOS\\";
		Project p = new Project();
		TdProjectRepository tdProject = new TdProjectRepository();

		try {
			// RECEBE O NOME DO PROJETO TD
			p.setNome(JOptionPane.showInputDialog("Insira o nome do projeto:"));

			File folderNewProjectTd = new File(PATH + p.getNome());

			// VALIDA SE O USUARIO CANCELOU A CRIACAO OU NÃO INSERIU O NOME DO PROJETO
			if (p.getNome() != null && p.getNome().trim().length() != 0) {
				// VALIDA SE EXISTE ALGUM PROJETO COM O MESMO NOME
				if (!folderNewProjectTd.exists()) {
					// INVOCA OS METODOS DE CRIACAO DO PROJETO
					tdProject.createFolder(p);
					tdProject.copyStructure(p);
					PermissionFactory.permissionProject();
					Thread.sleep(20000);
					tdProject.remaneFolder(p);
					JOptionPane.showMessageDialog(null, "Projeto criado com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "O projeto " + p.getNome() + " já existe"
							+ "\nSelecione o tipo de projeto e tente novamente");
				}

			} else {
				JOptionPane.showMessageDialog(null,
						"Não foi inserido o nome do projeto" + "\nSelecione o tipo de projeto e tente novamente.");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	// METODO PARA RECEBER E VALIDAR A ENTRADA DO NOME DO PROJETO E CRIAR O PROJETO OM
	public static void ProjectOmFactory() {

		// DIRETORIO DOS PROJETOS DE OM PARA TESTAGEM
		String PATH = "\\\\storage04\\FILESERVER\\OM\\OM_OPERACOES\\";
		Project p = new Project();
		OmProjectRepository omProject = new OmProjectRepository();

		try {
			// RECEBE O NOME DO PROJETO OM
			p.setNome(JOptionPane.showInputDialog("Insira o nome do projeto:"));

			File folderNewProjectOm = new File(PATH + p.getNome());

			// VALIDA SE O USUARIO CANCELOU A CRIACAO OU NÃO INSERIU O NOME DO PROJETO
			if (p.getNome() != null && p.getNome().trim().length() != 0) {
				// VALIDA SE EXISTE ALGUM PROJETO COM O MESMO NOME
				if (!folderNewProjectOm.exists()) {
					// INVOCA OS METODOS DE CRIACAO DO PROJETO
					omProject.createFolder(p);
					omProject.copyStructure(p);
					JOptionPane.showMessageDialog(null, "Projeto criado com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "O projeto " + p.getNome() + " já existe"
							+ "\nSelecione o tipo de projeto e tente novamente");
				}

			} else {
				JOptionPane.showMessageDialog(null,
						"Não foi inserido o nome do projeto" + "\nSelecione o tipo de projeto e tente novamente.");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
