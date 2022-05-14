package br.com.athenas.responses;

import java.util.Date;

import br.com.athenas.enuns.Sexo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaGetResponse {

	private Integer idPessoa;
	private String nome;
	private Date dataNasc;
	private String cpf;
	private Sexo sexo;
	private Double Altura;
	private Double Peso;
}
