package interfaces;

import entities.Produto;

public interface IProdutoRepository {

	//m�todos abstratos (somente a declara��o)
	void exportarDados(Produto produto) throws Exception;
}
