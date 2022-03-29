package br.com.cotiinformatica.responses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteGetResponse {

	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	
}
