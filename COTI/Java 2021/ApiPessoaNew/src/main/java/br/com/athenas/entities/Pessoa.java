package br.com.athenas.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Column(nullable = false)
	private Date dataNasc;
	@Column(nullable = false, length = 11, unique = true)
	private String cpf;
	@Column(nullable = false)
	private String sexo;
	@Column(nullable = false)
	private Double altura;
	@Column(nullable = false)
	private Double peso;
	
	
	public void CalcularPesoIdeal() {
		//TODO
	}
}
