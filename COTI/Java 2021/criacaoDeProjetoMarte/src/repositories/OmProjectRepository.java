package repositories;

import java.io.File;

import entities.Project;
import interfaces.IProjectRepository;

public class OmProjectRepository implements IProjectRepository {

	protected static final String PATH = "C:\\TEMP\\";

	@Override
	public void createFolder(Project project) throws Exception {
		File folder = new File(PATH + "novoProjetoTD");
		if (!folder.exists()) {
			folder.mkdir();
		} else {
			// TODO
		}

	}

	public void remaneFolder(Project project) throws Exception {

		
		File oldFolderName = new File(PATH + "novoProjetoTD");

		File newFolderName = new File(PATH + project.getNome());

		oldFolderName.wait(1000);
		
		boolean success = oldFolderName.renameTo(newFolderName);
		
		if(!success) { 
			System.out.println("Erro");
		}

	}

	@Override
	public void copyStructure(Project project) throws Exception {

		String directory = "robocopy.exe \"Z:\\GO\\GO_TI\\01_Infraestrutura\\01.1_Documentacao\\Estrutura de pastas\\Projetos TD\" \""
				+ PATH + "novoProjetoTD" + "\"  *.* /e /r:0 /w:0 /tee ";
		/*
		 * File copia = new
		 * File("Z:\\GO\\GO_TI\\01_Infraestrutura\\01.1_Documentacao\\Estrutura de pastas\\Projetos TD"
		 * ); File destino = new File(PATH + "novoProjetoTD");
		 */

		Runtime.getRuntime().exec("cmd /c " + directory);

		
	}

}
