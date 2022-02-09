package factories;

public class PermissionFactory {

	
	protected static final String PATH = "C:\\TEMP\\";
	
	public static void permissionProject() throws Exception{
		
		String batDirectory = "\\\\adds-server-01\\Publico\\Scripts\\CriacaoProjetos\\icaclsProjeto.bat";
	
		Runtime.getRuntime().exec("cmd.exe /c " + batDirectory); 
		
	}
	
	

}
