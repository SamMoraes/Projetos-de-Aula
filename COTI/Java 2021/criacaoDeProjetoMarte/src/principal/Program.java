package principal;

import javax.swing.JOptionPane;

import entities.Project;
import factories.FolderFactory;
import factories.PermissionFactory;

public class Program {

	public static void main(String[] args) {
		
		
		Project p = new Project();
		
		p.setNome(JOptionPane.showInputDialog("Informe o nome do projeto"));
		
		try {
			FolderFactory ff = new FolderFactory();
			PermissionFactory pf = new PermissionFactory();
			ff.createFolder(p);
			ff.copyStructure(p);
			pf.permissionProject(p);
		} catch (Exception e) {
			System.out.println(e);
	
		
		}
	}
}
