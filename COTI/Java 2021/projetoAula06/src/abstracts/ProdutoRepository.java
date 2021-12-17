package abstracts;

import java.io.File;

import entities.Produto;

public abstract class ProdutoRepository {

	protected static final String PATH = "C:\\Git\\Projetos-de-Aula\\COTI\\Java 2021\\projetoAula06\\Arquivo\\exportacao\\";

	// m�todo para criar a pasta onde os arquivos ser�o armazenados
	// este m�todo ser� definido como protected para que somente
	// as subclasses da ProdutoRepository possam acessar este m�todo
	protected void criarDiretorio() throws Exception {
		// verificar se o diretorio n�o existe
		File directory = new File(PATH);
		if (!directory.exists()) {
			// criar o diret�rio
			directory.mkdir();
		}
	}
	
	public abstract void exportarDados(Produto produto) throws Exception;

}
