package repositories;

import java.io.FileWriter;
import java.util.HashMap;

import org.json.simple.JSONObject;

import abstracts.ProdutoRepository;
import entities.Produto;

public class ProdutoRepositoryJSON extends ProdutoRepository{

	@Override
	public void exportarDados(Produto produto) throws Exception {

		HashMap<String, Object> mapa = new HashMap<String, Object>();
		
		mapa.put("idProduto", produto.getIdProduto());
		mapa.put("nome", produto.getNome());
		mapa.put("preco", produto.getPreco());
		mapa.put("quantidade", produto.getQuantidade());
		mapa.put("status", produto.getStatus().toString());
		mapa.put("categoria", produto.getCategoria().toString());
		
		//gerando o conteudo JSON para gravar no arquivo
		JSONObject json = new JSONObject(mapa);
		
		FileWriter writer = new FileWriter(PATH + "produto.json");
		writer.write(json.toString());
		writer.flush();
		writer.close();
	}



}
