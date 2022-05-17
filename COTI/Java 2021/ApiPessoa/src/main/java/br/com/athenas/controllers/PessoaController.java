package br.com.athenas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.athenas.entities.Pessoa;
import br.com.athenas.repositories.IPessoaRepository;
import br.com.athenas.requests.PessoaPostRequest;
import br.com.athenas.requests.PessoaPutRequest;
import br.com.athenas.responses.PessoaGetResponse;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class PessoaController {

	@Autowired
	private IPessoaRepository pr;

	// endereço do serviço
	private static final String ENDPOINT = "/api/pessoa";

	// cadastro de pessoas - POST
	@CrossOrigin
	@ApiOperation("Serviço para cadastro de pessoas.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody PessoaPostRequest request) {

		try {
			Pessoa pessoa = new Pessoa();

			pessoa.setNome(request.getNome());
			pessoa.setDataNasc(request.getDataNasc());
			pessoa.setCpf(request.getCpf());
			pessoa.setSexo(request.getSexo());
			pessoa.setAltura(request.getAltura());
			pessoa.setPeso(request.getPeso());

			pr.save(pessoa);

			return ResponseEntity.status(HttpStatus.OK).body("Pessoa cadastrada com sucesso.");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}

	// atualização de pessoas - PUT
	@CrossOrigin
	@ApiOperation("Serviço para atualização de pessoas.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody PessoaPutRequest request) {

		try {

			// consultar pessoa pelo ID
			Optional<Pessoa> p = pr.findById(request.getIdPessoa());

			// verificar se a pessoa não foi encontrada
			if (p.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pessoa não encontrada");
			} else {
				Pessoa pessoa = p.get();

				pessoa.setNome(request.getNome());
				pessoa.setDataNasc(request.getDataNasc());
				pessoa.setCpf(request.getCpf());
				pessoa.setSexo(request.getSexo());
				pessoa.setAltura(request.getAltura());
				pessoa.setPeso(request.getPeso());

				
				pr.save(pessoa);

				return ResponseEntity.status(HttpStatus.OK).body("Pessoa atualizada com sucesso");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

	}

	// exclusao de pessoas - DELETE
	@CrossOrigin
	@ApiOperation("Serviço para exclusão de pessoas")
	@RequestMapping(value = ENDPOINT + "/{idPessoa}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idPessoa") Integer idPessoa) {

		try {

			// consultar pessoa pelo ID
			Optional<Pessoa> p = pr.findById(idPessoa);

			// verificar se a pessoa não foi encontrada
			if (p.isEmpty()) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pessoa não encontrada");

			} else {
				Pessoa pessoa = p.get();
				pr.delete(pessoa);

				return ResponseEntity.status(HttpStatus.OK).body("Pessoa excluída com sucesso");
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}

	// consulta de todas as pessoas - GET
	@CrossOrigin
	@ApiOperation("Serviço para consultar todas as pessoas")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<List<PessoaGetResponse>> get() {

		List<PessoaGetResponse> response = new ArrayList<PessoaGetResponse>();

		for (Pessoa pessoa : pr.findAll()) {

			PessoaGetResponse p = new PessoaGetResponse();

			p.setIdPessoa(pessoa.getIdPessoa());
			p.setNome(pessoa.getNome());
			p.setDataNasc(pessoa.getDataNasc());
			p.setCpf(pessoa.getCpf());
			p.setSexo(pessoa.getSexo());
			p.setAltura(pessoa.getAltura());
			p.setPeso(pessoa.getPeso());

			response.add(p);
		}

		return ResponseEntity.status(HttpStatus.OK).body(response);

	}
	
	@CrossOrigin
	@ApiOperation("Serviço para consultar 1 pessoa através do ID.")
	@RequestMapping(value = ENDPOINT + "/{idPessoa}", method = RequestMethod.GET)
	public ResponseEntity<PessoaGetResponse> getById(@PathVariable("idPessoa") Integer idPessoa){
		
		Optional<Pessoa> p = pr.findById(idPessoa);
		
		if(p.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		else {
			PessoaGetResponse response = new PessoaGetResponse();
			Pessoa pessoa = p.get();
			
		
			response.setIdPessoa(pessoa.getIdPessoa());
			response.setNome(pessoa.getNome());
			response.setDataNasc(pessoa.getDataNasc());
			response.setCpf(pessoa.getCpf());
			response.setSexo(pessoa.getSexo());
			response.setAltura(pessoa.getAltura());
			response.setPeso(pessoa.getPeso());
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
			
			
			

		}
		
	}
	
	

	@CrossOrigin
	@ApiOperation("Serviço para peso ideal das pessoas")
	@RequestMapping(value = ENDPOINT + "/{idPessoa}" + "/pesoIdeal", method = RequestMethod.GET)
	public ResponseEntity<String> pesoIdeal(@PathVariable("idPessoa") Integer idPessoa){
		
		try {

			// consultar pessoa pelo ID
			Optional<Pessoa> p = pr.findById(idPessoa);

			// verificar se a pessoa não foi encontrada
			if (p.isEmpty()) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pessoa não encontrada");

			} else {
				Pessoa pessoa = p.get();
				
				pessoa.CalcularPesoIdeal(pessoa);

				return ResponseEntity.status(HttpStatus.OK).body("Seu peso ideal é: " + pessoa.getPesoIdeal().toString());
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}

}
