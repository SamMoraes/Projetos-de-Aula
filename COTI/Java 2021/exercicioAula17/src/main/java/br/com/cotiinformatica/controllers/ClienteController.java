package br.com.cotiinformatica.controllers;

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

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.repositories.IClienteRepository;
import br.com.cotiinformatica.requests.ClientePostRequest;
import br.com.cotiinformatica.requests.ClientePutRequest;
import br.com.cotiinformatica.responses.ClienteGetResponse;
import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class ClienteController {

	@Autowired
	private IClienteRepository cr;

	private static final String ENDPOINT = "/api/clientes";

	// POST
	@CrossOrigin
	@ApiOperation("Serviço para cadastro de clientes.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<String> post(@RequestBody ClientePostRequest request) {

		try {

			Cliente cliente = new Cliente();

			cliente.setNome(request.getNome());
			cliente.setCpf(request.getCpf());
			cliente.setEmail(request.getEmail());

			cr.save(cliente);

			return ResponseEntity.status(HttpStatus.OK).body("Cliente cadastrado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}

	}

	// PUT
	@CrossOrigin
	@ApiOperation("Serviço para atualização de clientes.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.PUT)
	public ResponseEntity<String> put(@RequestBody ClientePutRequest request) {

		try {

			// consulta Cliente por ID
			Optional<Cliente> item = cr.findById(request.getIdCliente());

			// verificar se consulta retornou null
			if (item.isEmpty()) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Produto não encontrado, por favor verifique.");

			} else {

				Cliente cliente = item.get();

				cliente.setNome(request.getNome());
				cliente.setCpf(request.getCpf());
				cliente.setEmail(request.getEmail());

				cr.save(cliente);
			}

			return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com sucesso.");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());

		}

	}

	// DELETE
	@CrossOrigin
	@ApiOperation("Serviço para exclusão de clientes.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("idCliente") Integer idProduto) {

		try {

			// consulta Cliente por ID
			Optional<Cliente> item = cr.findById(idProduto);

			// verificar se consulta retornou null
			if (item.isEmpty()) {

				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Produto não encontrado, por favor verifique.");

			} else {

				Cliente cliente = item.get();

				cr.delete(cliente);
			}

			return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso.");

		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());

		}

	}

	// GET
	@CrossOrigin
	@ApiOperation("Serviço para consulta de clientes.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<List<ClienteGetResponse>> get() {

		List<ClienteGetResponse> response = new ArrayList<ClienteGetResponse>();

		for (Cliente cliente : cr.findAll()) {

			ClienteGetResponse item = new ClienteGetResponse();

			item.setIdCliente(cliente.getIdCliente());
			item.setNome(cliente.getNome());
			item.setCpf(cliente.getCpf());
			item.setEmail(cliente.getEmail());

			response.add(item);

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
