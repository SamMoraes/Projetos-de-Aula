package factories;

import java.io.File;

import entities.Project;
import interfaces.IFolder;

public class FolderFactory implements IFolder {

	protected static final String PATH = "C:\\TEMP\\";

	@Override
	public void createFolder(Project project) throws Exception {

		File folder = new File(PATH + project.getNome());
		if (!folder.exists()) {
			folder.mkdir();
		}

	}

	@Override
	public void copyStructure(Project project) throws Exception {

		
		String directory = "robocopy.exe \"Z:\\GO\\GO_TI\\01_Infraestrutura\\01.1_Documentacao\\Estrutura de pastas\\Projetos TD\" \"" + PATH + project.getNome() + "\"  *.* /e /r:0 /w:0 /tee "; 
		
		Runtime.getRuntime().exec("cmd /c " + directory); 
		
		
		} 
	}


