package br.com.marteengenharia.sgp.entity.usuario;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.marteengenharia.sgp.entity.apropriacao.Apropriacao;
import br.com.marteengenharia.sgp.entity.centrocusto.Departamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable{

	//DECLACARAO DE VARIAVEIS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private Long id;
	@Column(name="usuario")
	@NotNull
	private String username;
	@Column(name="senha")
	@NotNull
	private String password;
	@Column(name="matricula")
	@NotNull
	private Integer matricula;
	@Column(name="nome")
	@NotNull
	@Pattern(regexp="[a-z A-Z]", message="ERRO, CARACTER NAO PERMITIDO")
	private String nome;
	@Column(name="fatorHoraPadrao")
	@NotNull
	private Double fatorHoraPadrao;
	@Column(name="dataAdmissao")
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataAdmissao;
	@Column(name="dataDemissao")
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataDemissao;
	@Column(name="tipoUsuario")
	@NotNull
	private TipoUsuario tipoUsuario;
	@Column(name="tipoContratacao")
	@NotNull
	private TipoContratacao tipoContratacao;
	@Column(name="tipoProfissional")
	@NotNull
	private TipoProfissional tipoProfissional;
	@Column(name="situacao")
	@NotNull
	private SituacaoUsuario situacao;
	
	//Declaração dos relacionamento entre as entidades
	@OneToMany(mappedBy = "usuario")
	@JsonBackReference
    private List<Apropriacao> apropriacao;
	
	 @ManyToMany(mappedBy = "usuario")
	 private List<Departamento> departamento;
	 	
}
