package repositories;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import abstracts.ProdutoRepository;
import entities.Produto;

public class ProdutoRepositoryXML extends ProdutoRepository {

	@Override
	public void exportarDados(Produto produto) throws Exception {

		// chamando o método da classe abstrata
		criarDiretorio();

		// criando um documento XML
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();

		// criando a tag raiz do XML <PRODUTO>
		Element raiz = document.createElement("PRODUTO");
		document.appendChild(raiz);

		// criando as tags onde serão impressos os dados do produto
		Element idProduto = document.createElement("IDPRODUTO");
		idProduto.setTextContent(produto.getIdProduto().toString());
		raiz.appendChild(idProduto);

		Element nome = document.createElement("NOME");
		nome.setTextContent(produto.getNome());
		raiz.appendChild(nome);

		Element preco = document.createElement("PRECO");
		preco.setTextContent(produto.getPreco().toString());
		raiz.appendChild(preco);

		Element quantidade = document.createElement("QUANTIDADE");
		quantidade.setTextContent(produto.getQuantidade().toString());
		raiz.appendChild(quantidade);

		Element status = document.createElement("STATUS");
		status.setTextContent(produto.getStatus().toString());
		raiz.appendChild(status);

		Element categoria = document.createElement("CATEGORIA");
		status.setTextContent(produto.getCategoria().toString());
		raiz.appendChild(categoria);

		// finalizando e gravando o arquivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);

		StreamResult stream = new StreamResult(new File(PATH + "produto.xml"));
		transformer.transform(domSource, stream);
	}
}

