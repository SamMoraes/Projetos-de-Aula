package br.com.cotiinformatica.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountPostRequest {

	private String nome;
	private String login;
	private String senha;

}



