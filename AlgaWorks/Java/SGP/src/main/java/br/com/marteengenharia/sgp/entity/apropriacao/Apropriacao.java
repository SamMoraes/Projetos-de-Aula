package br.com.marteengenharia.sgp.entity.apropriacao;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.marteengenharia.sgp.entity.centrocusto.CentroCusto;
import br.com.marteengenharia.sgp.entity.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apropriacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apropriacao implements Serializable{

	//DECLACARAO DE VARIAVEIS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="apropriacao_id")
	private Long id;
	@Column(name="data")
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate data;
	@Column(name="duracaoHora")
	@NotNull
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime duracaoHora;
	@Column(name="duracaoHoraPadrao")
	@NotNull
	private Double duracaoHoraPadrao;
	@Column(name="descricao")
	@Pattern(regexp="[a-z A-Z] {2,50}", message="ERRO, CARACTER NAO PERMITIDO")
	private String descricao;
	@NotNull
	@Column(name="situacao")
	private SituacaoApropriacao situacao;
	
	//Declaração dos relacionamentos dos CodeDatas
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "atividade_id")
	 private Atividade atividade;
	 
	//Declaração dos relacionamento entre as entidades
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "centroCusto_id")
	 @JsonManagedReference
	 private CentroCusto centroCusto;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "usuario_id")
	 @JsonManagedReference
	 private Usuario usuario;
	 
	
	
	
	
	
	
	
	
	
	
}
