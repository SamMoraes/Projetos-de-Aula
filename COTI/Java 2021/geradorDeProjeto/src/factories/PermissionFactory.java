package factories;

public class PermissionFactory {

	//METODO PARA INVOCAR A BAT COM O SCRIPT DA PERMISSAO DA ESTRUTURA DE PASTA DOS PROJETOS TD
	public static void permissionProject() throws Exception{
		
		String batDirectory = "\\\\adds-server-01\\Publico\\Scripts\\CriacaoProjetos\\icaclsProjeto.bat";
	
		Runtime.getRuntime().exec("cmd.exe /c " + batDirectory); 
		
	}
	
	

}
