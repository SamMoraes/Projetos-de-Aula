package br.com.cotiinformatica.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.IProdutoRepository;
import br.com.cotiinformatica.requests.ProdutoPostRequest;
import br.com.cotiinformatica.requests.ProdutoPutRequest;

@Controller
@Transactional
public class ProdutoController {

	@Autowired
	private IProdutoRepository produtoRepository;

	// definindo o endereço do serviço
	private static final String ENDPOINT = "/api/produtos";

	// método para realizar o serviço de cadastro de produto
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody ProdutoPostRequest request) {

		try {
			
			Produto produto = new Produto();
			
			produto.setNome(request.getNome());
			produto.setPreco(request.getPreco());
			produto.setQuantidade(request.getQuantidade());
			produto.setDescricao(request.getDescricao());
			
			produtoRepository.save(produto);
			
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Produto cadastrado com sucesso.");
		}
		catch(Exception e) {
			
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro: " + e.getMessage());
		}
	}

	// método para realizar o serviço de edição do produto
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody ProdutoPutRequest request) {
		
		try {
			
			//consultar o produto no banco de dados atraves do ID
			Optional<Produto> item = produtoRepository.findById(request.getIdProduto());
			
			//verificar se o produto não foi encontrado
			if(item.isEmpty()) {
				
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body("Produto não encontrado, por favor verifique.");
			}
			else {
				
				Produto produto = item.get();
				
				produto.setNome(request.getNome());
				produto.setPreco(request.getPreco());
				produto.setQuantidade(request.getQuantidade());
				produto.setDescricao(request.getDescricao());
				
				produtoRepository.save(produto);
				
				return ResponseEntity
						.status(HttpStatus.OK)
						.body("Produto atualizado com sucesso.");
			}
		}
		catch(Exception e) {
		
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro: " + e.getMessage());
		}
	}

	// método para realizar o serviço de exclusão do produto
	@RequestMapping(value = ENDPOINT + "/{idProduto}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idProduto") Integer idProduto) {
		
		try {			
			//consultar o produto no banco de dados atraves do ID
			Optional<Produto> item = produtoRepository.findById(idProduto);
			
			//verificar se o produto não foi encontrado
			if(item.isEmpty()) {
				
				return ResponseEntity
						.status(HttpStatus.BAD_REQUEST)
						.body("Produto não encontrado, por favor verifique.");
			}
			else {
				
				Produto produto = item.get();
				produtoRepository.delete(produto);
				
				return ResponseEntity
						.status(HttpStatus.OK)
						.body("Produto excluído com sucesso.");
			}
		}
		catch(Exception e) {
		
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro: " + e.getMessage());
		}
	}

	// método para realizar a consulta dos produtos
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> get() {

		List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(produtos);
	}
}




