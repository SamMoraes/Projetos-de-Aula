package repositories;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;

import entities.Project;
import interfaces.IProjectRepository;

public class OmProjectRepository implements IProjectRepository {

	//AQUI NAO E NECESSARIO METODO DE PERMISSIONAMENTO POIS EM OM A PERMISSAO E HERDADA DA ESTRUTURA DO FILESERVER
	
	//DIRETORIO DOS PROJETOS DE OM
	protected static final String PATH = "\\\\storage04\\FILESERVER\\OM\\OM_OPERACOES\\";


	//METODO PARA CRIAR A PASTA DO PROJETO
	@Override
	public void createFolder(Project project) throws Exception {
		File folder = new File(PATH + project.getNome());

		try {

			folder.mkdir();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	//PASTA PARA COPIAR A ESTRUTURA DE PASTAS PARA O PROJETO CRIADO 
	@Override
	public void copyStructure(Project project) throws Exception {

		File source = new File(
				"\\\\storage04\\FILESERVER\\GO\\GO_TI\\01_Infraestrutura\\01.1_Documentacao\\Estrutura de pastas\\Projetos OM\\");
		File dest = new File(PATH + project.getNome());

		try {

			FileUtils.copyDirectory(source, dest);

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	

}
