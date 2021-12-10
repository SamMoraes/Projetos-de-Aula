package interfaces;

import entities.Produto;

public interface IProdutoRepository {

	//métodos abstratos (somente a declaração)
	void exportarDados(Produto produto) throws Exception;
}
