package principal;

import javax.swing.JOptionPane;

import entities.Project;
import factories.PermissionFactory;
import repositories.OmProjectRepository;
import repositories.TdProjectRepository;

public class Program {

	public static void main(String[] args) throws Exception {
		
		
		Project p = new Project();
		
		p.setNome(JOptionPane.showInputDialog("Informe o nome do projeto"));
		
		/*
		 * try { TdProjectRepository ff = new TdProjectRepository(); ff.createFolder(p);
		 * ff.copyStructure(p); PermissionFactory.permissionProject();
		 * ff.remaneFolder(p); } catch (Exception e) {
		 * JOptionPane.showInputDialog("Erro: " + e.getMessage());
		 * 
		 * 
		 * }
		 */
		OmProjectRepository op = new OmProjectRepository();
		try {
			
			op.createFolder(p);
			op.copyStructure(p);
			
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro: " + e.getMessage());
			
		
		}
		
		op.remaneFolder(p);
	}
}
