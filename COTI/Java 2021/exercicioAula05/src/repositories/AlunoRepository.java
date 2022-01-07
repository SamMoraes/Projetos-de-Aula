package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;
import interfaces.iAlunoRepository;

public class AlunoRepository implements iAlunoRepository{


	@Override
	public void create(Aluno aluno) throws Exception {
		
		//conexao com bd
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO ALUNO(NOME, MATRICULA, CPF) VALUES(?, ?, ?)");
		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf()); 
		statement.execute(); 
		statement.close();
		
		connection.close();
		
	}

	@Override
	public void update(Aluno aluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("UPDATE ALUNO SET  NOME =?, MATRICULA=?, CPF=? WHERE IDALUNO =?");
		statement.setString(1, aluno.getNome());
		statement.setString(2, aluno.getMatricula());
		statement.setString(3, aluno.getCpf());
		statement.setInt(4, aluno.getIdAluno());
		statement.execute(); 
		statement.close(); 
		
		connection.close();
		
	}

	@Override
	public void delete(Aluno aluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("DELETE FROM ALUNO WHERE IDALUNO =?");
		
		statement.setInt(1, aluno.getIdAluno());
		statement.execute(); 
		statement.close(); 
		
		connection.close();
		
	}

	@Override
	public List<Aluno> findAll(Aluno aluno) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("SELECT * FROM ALUNO");
		
		ResultSet result = statement.executeQuery();
		
		List<Aluno> lista = new ArrayList<Aluno>();
		
		while(result.next()) {
			
			
			Aluno a = new Aluno();
			
			a.setIdAluno(result.getInt("IDALUNO"));
			a.setNome(result.getString("NOME"));
			a.setMatricula(result.getString("MATRICULA"));
			a.setCpf(result.getString("CPF"));
			
			
			lista.add(a);
		}
		
		result.close();
		statement.close();
		connection.close();
		
		return lista;

	}

}
