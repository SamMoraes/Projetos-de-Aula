package repositories;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import entities.Project;
import interfaces.IProjectRepository;

public class OmProjectRepository implements IProjectRepository {

	protected static final String PATH = "\\\\storage04\\FILESERVER\\OM\\OM_OPERACOES\\";

	@Override
	public void createFolder(Project project) throws Exception {
		File folder = new File(PATH + project.getNome());
		if (!folder.exists()) {
			folder.mkdir();
		} 
	}

	@Override
	public void copyStructure(Project project) throws Exception {


		File source = new File("\\\\storage04\\FILESERVER\\GO\\GO_TI\\01_Infraestrutura\\01.1_Documentacao\\Estrutura de pastas\\Projetos OM\\");
		File dest = new File(PATH + project.getNome());
		try {
		    FileUtils.copyDirectory(source, dest);
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}
		   
	}

	@Override
	public void testFolderExists(Project project) throws Exception {
		//TODO
		} 
		 
	

}
