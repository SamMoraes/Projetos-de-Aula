package br.com.athenas.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athenas.enuns.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idPessoa;
	@Column(nullable = false, length = 150)
	private String nome;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNasc;
	@Column(nullable = false, length = 14, unique = true)
	private String cpf;
	@Column(nullable = false)
	private Sexo sexo;
	@Column(nullable = false)
	private Double altura;
	@Column(nullable = false)
	private Double peso;
	private Double pesoIdeal;
	
	
	public void CalcularPesoIdeal(Pessoa pessoa) {
		
				
		if(pessoa.getSexo() == Sexo.MASCULINO) {
			pesoIdeal=(72.7*altura)-58.0;
		}
		else {
			pesoIdeal=(62.1*altura)-44.7;
		}
	}
	
	
}
