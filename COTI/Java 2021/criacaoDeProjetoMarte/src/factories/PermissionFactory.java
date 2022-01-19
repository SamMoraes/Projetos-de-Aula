package factories;

import entities.Project;

public class PermissionFactory {

	
	protected static final String PATH = "C:\\TEMP\\";
	
	public void permissionProject(Project project) throws Exception{
		
		String comand = "icacls.exe \""+ PATH + project.getNome() + "\" /restore C:\\Users\\administrador\\TDPERMISSAO.acl" ;
		
		Runtime.getRuntime().exec("cmd.exe /c start " + comand); 
		
		System.out.println(comand);
	}
	
	

	/* C:\Users\administrador\TDPERMISSAO.acl */
}
