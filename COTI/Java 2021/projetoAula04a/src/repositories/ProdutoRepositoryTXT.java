package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Produto;
import interfaces.IProdutoRepository;

public class ProdutoRepositoryTXT implements IProdutoRepository{

	@Override
	public void exportarDados(Produto produto) throws Exception {
		PrintWriter writer = new PrintWriter(new File("c:\\temp\\produto.txt"));
			writer.write("\nID DO PRODUTO..........: " + produto.getIdProduto());
			writer.write("\nNOME...................: " + produto.getNome());
			writer.write("\nPREÇO..................: " + produto.getPreco());
			writer.write("\nQUANTIDADE.............: " + produto.getQuantidade());
			writer.write("\nSTATUS.................: " + produto.getStatus());
		
			writer.flush();
			writer.close();
	}

}
