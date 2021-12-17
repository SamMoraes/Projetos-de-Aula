package abstracts;

import java.io.File;

import entities.Produto;

public abstract class ProdutoRepository {

	protected static final String PATH = "C:\\Git\\Projetos-de-Aula\\COTI\\Java 2021\\projetoAula06\\Arquivo\\exportacao\\";

	// método para criar a pasta onde os arquivos serão armazenados
	// este método será definido como protected para que somente
	// as subclasses da ProdutoRepository possam acessar este método
	protected void criarDiretorio() throws Exception {
		// verificar se o diretorio não existe
		File directory = new File(PATH);
		if (!directory.exists()) {
			// criar o diretório
			directory.mkdir();
		}
	}
	
	public abstract void exportarDados(Produto produto) throws Exception;

}
