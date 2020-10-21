package com.algaworks.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Samuel Moraes");
		cliente1.setTelefone("21 93134119");
		cliente1.setEmail("samuel.moraes@g.com");
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Ana Moraes");
		cliente2.setTelefone("25 93134119");
		cliente2.setEmail("ana.moraes@g.com");
		return Arrays.asList(cliente1,cliente2);
	}
}
