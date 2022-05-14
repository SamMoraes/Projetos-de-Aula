package br.com.athenas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.athenas.entities.Pessoa;

@Repository
public interface IPessoaRepository extends CrudRepository<Pessoa, Integer>{

	
}
