package br.com.marteengenharia.sgp.entity.centrocusto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.marteengenharia.sgp.entity.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento extends CentroCusto implements Serializable{

	//DECLACARAO DE VARIAVEIS
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="departamento_id")
	private Long id;
	
	//Declaração dos relacionamento entre as entidades
	@ManyToMany
    @JoinTable(
        name = "departamento_usuario",
        joinColumns = @JoinColumn(name = "departamento_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    		  )
    private List<Usuario> usuario;
	

}
