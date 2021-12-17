package principal;

import entities.Produto;
import enums.Categoria;
import enums.Status;
import repositories.ProdutoRepositoryJSON;
import repositories.ProdutoRepositoryXML;

public class Program {

	public static void main(String[] args) {
		
		try {

			Produto produto = new Produto(1, "Notebook", 3000.0, 10, Status.DISPONIVEL, Categoria.NAO_PERECIVEL);

			ProdutoRepositoryXML xml = new ProdutoRepositoryXML();
			xml.exportarDados(produto);
			
			ProdutoRepositoryJSON json = new ProdutoRepositoryJSON();
			json.exportarDados(produto);
			
			System.out.println("\nARQUIVOS GERADOS COM SUCESSO!");
			
		}  catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}
}
