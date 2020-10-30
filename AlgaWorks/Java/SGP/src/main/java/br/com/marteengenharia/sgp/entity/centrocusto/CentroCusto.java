package br.com.marteengenharia.sgp.entity.centrocusto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.marteengenharia.sgp.entity.apropriacao.Apropriacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "centrocusto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CentroCusto implements Serializable{

	 	//DECLACARAO DE VARIAVEIS
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="centroCusto_id")
		private Long id;
		@Column(name="codigo")
		@NotNull
		private Integer codigo;
		@Column(name="descricao")
		@Pattern(regexp="[a-z A-Z] {2,50}", message="ERRO, CARACTER NAO PERMITIDO")
		private String descricao;
		@NotNull
		@Column(name="dataInicio")
		@JsonFormat(pattern="dd-MM-yyyy")
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
		private LocalDate dataInicio;
		@NotNull
		@Column(name="dataFim")
		@JsonFormat(pattern="dd-MM-yyyy")
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
		private LocalDate dataFim;
		
		//Declaração dos relacionamento entre as entidades
		@OneToMany(mappedBy = "centroCusto", fetch = FetchType.EAGER)
	    @JsonBackReference
	    private List<Apropriacao> apropriacao;
		
	
		
}
