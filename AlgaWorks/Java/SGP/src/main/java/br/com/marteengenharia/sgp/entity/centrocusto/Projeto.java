package br.com.marteengenharia.sgp.entity.centrocusto;

import java.io.Serializable;
import java.time.LocalDate;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.marteengenharia.sgp.entity.cliente.Cliente;
import br.com.marteengenharia.sgp.entity.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "projeto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Projeto extends CentroCusto implements Serializable{

	//DECLACARAO DE VARIAVEIS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projeto_id")
	private Long id;
	@Column(name="codigoCliente")
	@NotNull
	private Integer codigoCliente;
	@Column(name="numeroProposta")
	@NotNull
	private Integer numeroProposta;
	@Column(name="dataAssinatura")
	@NotNull
	@JsonFormat(pattern="dd-MM-yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataAssinatura;
	@Column(name="area")
	@NotNull
	private AreaCentroCusto area;
	@Column(name="tipo")
	@NotNull
	private TipoProjeto tipo;
	@Column(name="situacao")
	@NotNull
	private SituacaoProjeto situacao;
	
	//Declaração dos relacionamento entre as entidades
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	@JsonManagedReference
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	@JsonManagedReference
	private Cliente cliente;
	
	
}
