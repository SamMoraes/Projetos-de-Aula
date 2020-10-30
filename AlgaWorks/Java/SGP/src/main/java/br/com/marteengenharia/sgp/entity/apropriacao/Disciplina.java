package br.com.marteengenharia.sgp.entity.apropriacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.marteengenharia.sgp.entity.centrocusto.AreaCentroCusto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "disciplina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Disciplina implements Serializable{

		//DECLACARAO DE VARIAVEIS
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="disciplina_id")
		private Long id;
		@Column(name="descricao")
		private String descricao;
		@Column(name="area")
		private AreaCentroCusto area;
		
	
		
		
}
