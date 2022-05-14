package br.com.athenas.requests;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaPutRequest {

	private Integer idPessoa;
	private String nome;
	private Date dataNasc;
	private String cpf;
	private String sexo;
	private Double Altura;
	private Double Peso;
}
