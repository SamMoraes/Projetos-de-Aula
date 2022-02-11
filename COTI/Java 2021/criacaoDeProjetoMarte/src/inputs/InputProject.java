package inputs;

import javax.swing.JOptionPane;

import entities.Project;
import factories.PermissionFactory;
import repositories.OmProjectRepository;
import repositories.TdProjectRepository;

public class InputProject {

	
	
	Project p = new Project();
	
	TdProjectRepository tdProject = new TdProjectRepository();
	OmProjectRepository omProject = new OmProjectRepository();

	public static void inputProjectTd() {

		Project p = new Project();
		TdProjectRepository tdProject = new TdProjectRepository();

		try {
			p.setNome(JOptionPane.showInputDialog("Insira o nome do projeto:"));
			
						
			if (p.getNome() != null) {
				tdProject.createFolder(p);
				tdProject.copyStructure(p);
				PermissionFactory.permissionProject();
				Thread.sleep(20000);
				tdProject.remaneFolder(p);
				JOptionPane.showMessageDialog(null, "Projeto criado com sucesso");
			} else {
				JOptionPane.showMessageDialog(null,
						"Não foi inserido o nome do projeto" + "\nSelecione o tipo de projeto e tente novamente.");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public static void inputProjectOm() {

		Project p = new Project();
		OmProjectRepository omProject = new OmProjectRepository();

		try {
			p.setNome(JOptionPane.showInputDialog("Insira o nome do projeto:"));

			if (p.getNome() != null) {

				omProject.createFolder(p);
				omProject.copyStructure(p);
				JOptionPane.showMessageDialog(null, "Projeto criado com sucesso");

			} else {
				JOptionPane.showMessageDialog(null,
						"Não foi inserido o nome do projeto" + "\nSelecione o tipo de projeto e tente novamente.");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
