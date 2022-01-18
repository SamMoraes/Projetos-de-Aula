package abstracts;

import java.io.File;

import entities.Empresa;

public abstract class EmpresaRepository {

	protected static final String PATH = "C:\\TEMP\\";
	
	protected void criarDiretorio() throws Exception{
		
		File diretorio = new File(PATH);
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
	}
	
	public abstract void exportarDados(Empresa empresa) throws Exception;
	
}
