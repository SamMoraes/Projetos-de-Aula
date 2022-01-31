package principal;

import javax.swing.JOptionPane;

import entities.Project;
import factories.PermissionFactory;
import repositories.TdProjectRepository;

public class Program {

	public static void main(String[] args) throws Exception {

			boolean isValid = true;
		  Project p = new Project();
		  TdProjectRepository tdProject = new TdProjectRepository();
		  
		  try {
			  p.setNome(JOptionPane.showInputDialog("Insira o nome do projeto:"));
			  tdProject.createFolder(p);
			  tdProject.copyStructure(p);
			  PermissionFactory.permissionProject();
			  Thread.sleep (5000);
			  tdProject.remaneFolder(p);
			  if (isValid) {
				  JOptionPane.showMessageDialog(null, "Projeto criado com sucesso");
			  }
			  
} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
