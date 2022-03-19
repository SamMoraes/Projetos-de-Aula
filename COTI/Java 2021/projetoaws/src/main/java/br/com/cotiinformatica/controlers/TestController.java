package br.com.cotiinformatica.controlers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class TestController {

	@CrossOrigin
	@ApiOperation("Serviço teste de mensagem.")
	@GetMapping("/hello")
	public String hello() {
		return "Seja bem vindo a API Java";
	}

}



