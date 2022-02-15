package repositories;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import entities.Project;
import interfaces.IProjectRepository;

public class TdProjectRepository implements IProjectRepository {

	// DIRETORIO DOS PROJETOS DE TD
	protected static final String PATH = "\\\\storage04\\FILESERVER\\TD\\TD_PROJETOS\\";

	// METODO PARA CRIAR UMA PASTA GENERICA DE PROJETO
	@Override
	public void createFolder(Project project) throws Exception {

		File folder = new File(PATH + "novoTdProjeto");

		try {

			folder.mkdir();

		} catch (Exception e) {
			e.getMessage();
		}
	}

	// PASTA PARA COPIAR A ESTRUTURA DE PASTAS PARA O PROJETO CRIADO
	@Override
	public void copyStructure(Project project) throws Exception {

		File source = new File(
				"\\\\storage04\\FILESERVER\\GO\\GO_TI\\01_Infraestrutura\\01.1_Documentacao\\Estrutura de pastas\\Projetos TD\\");
		File dest = new File(PATH + "novoTdProjeto");

		try {

			FileUtils.copyDirectory(source, dest);

		} catch (IOException e) {
			e.getMessage();
		}

	}

	// METODO PARA RENOMEAR A PASTA GENERICA PARA O NOME DO PROJETO INSERIDO
	public void remaneFolder(Project project) throws Exception {

		File oldFolderName = new File(PATH + "novoTdProjeto");
		File newFolderName = new File(PATH + project.getNome());

		try {

			oldFolderName.renameTo(newFolderName);

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
