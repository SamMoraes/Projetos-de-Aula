package br.com.athenas.responses;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaGetResponse {

	private Integer idPessoa;
	private String nome;
	private Date dataNasc;
	private String cpf;
	private String sexo;
	private Double Altura;
	private Double Peso;
}
