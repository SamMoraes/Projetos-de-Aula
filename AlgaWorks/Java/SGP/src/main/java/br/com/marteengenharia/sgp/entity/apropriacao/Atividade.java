package br.com.marteengenharia.sgp.entity.apropriacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "atividade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atividade implements Serializable{

	//DECLACARAO DE VARIAVEIS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="atividade_id")
	private Long id;
	@Column(name="descricao")
	private String descricao;
	
	//Declaração dos relacionamentos dos CodeDatas
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
		 

	
	
}
