package interfaces;

import java.util.List;

import entities.Aluno;

public interface iAlunoRepository {

	void create(Aluno aluno) throws Exception;
	
	void update(Aluno aluno) throws Exception;
	
	void delete(Aluno aluno) throws Exception;
	
	List<Aluno> findAll(Aluno aluno) throws Exception;

}
