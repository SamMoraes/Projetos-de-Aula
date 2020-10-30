package br.com.marteengenharia.sgp.entity.cliente;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable{

	//DECLACARAO DE VARIAVEIS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cliente_id")
	private Long id;
	@Column(name="codigo")
	@NotNull
	private Integer codigo;
	@Column(name="razaoSocial")
	@NotNull
	private String razaoSocial;
	@Column(name="cnpj")
	@NotNull
	//talvez um pattern aqui
	private Integer cnpj;
	@Column(name="nomeRepresentante")
	@NotNull
	private String nomeRepresentante;
	@Column(name="telefone")
	@NotNull
	private Integer telefone;
	@Column(name="endereco")
	@NotNull
	private String endereco;
	
	
		
		
		
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
