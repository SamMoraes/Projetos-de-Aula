package br.com.athenas.responses;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.athenas.enuns.Sexo;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PessoaGetResponse {

	private Integer idPessoa;
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Calendar dataNasc;
	private String cpf;
	private Sexo sexo;
	private Double Altura;
	private Double Peso;
	
	

	
	
	
}
