package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Produto;
import interfaces.IProdutoRepository;

public class ProdutoRepositoryCSV implements IProdutoRepository {

	@Override
	public void exportarDados(Produto produto) throws Exception {

		PrintWriter printWriter = new PrintWriter(new File("c:\\temp\\produto.csv"));

		printWriter.write("IDPRODUTO;NOME;PRECO;QUANTIDADE;STATUS\n");
		printWriter.write(produto.getIdProduto() + ";" + produto.getNome() + 
						  ";" + produto.getPreco() + ";" + produto.getQuantidade() + 
						  ";" + produto.getStatus());

		printWriter.flush();
		printWriter.close();
	}

}


