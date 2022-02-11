package repositories;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import entities.Project;
import interfaces.IProjectRepository;

public class TdProjectRepository implements IProjectRepository {

	protected static final String PATH = "\\\\storage04\\FILESERVER\\TD\\TD_PROJETOS\\";

	@Override
	public void createFolder(Project project) throws Exception {

		File folder = new File(PATH + "novoTdProjeto");
		
			folder.mkdir();
				

		 }
		 
	
	public void remaneFolder(Project project) throws Exception{
		
		File oldFolderName = new File(PATH + "novoTdProjeto");
		
		File newFolderName = new File(PATH + project.getNome());

			oldFolderName.renameTo(newFolderName);
		
		
	}

	@Override
	public void copyStructure(Project project) throws Exception {
		
		File source = new File("\\\\storage04\\FILESERVER\\GO\\GO_TI\\01_Infraestrutura\\01.1_Documentacao\\Estrutura de pastas\\Projetos TD\\");
		File dest = new File(PATH + "novoTdProjeto");
		try {
		    FileUtils.copyDirectory(source, dest);
		} 
		catch (IOException e) {
		    e.printStackTrace();
		}

		
		}


	@Override
	public void testFolderExists(Project project) throws Exception {
		// TODO Auto-generated method stub
		
	} 
	}


