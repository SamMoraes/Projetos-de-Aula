package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Cliente;
import factories.ConnectionFactory;
import interfaces.iClienteRepository;

public class ClienteRepository implements iClienteRepository{

	@Override
	public void create(Cliente cliente) throws Exception {

		//abrindo uma conexão com o banco de dados
		Connection connection = ConnectionFactory.getConnection();

		//gravar um cliente na base de dados
		PreparedStatement statement = connection.prepareStatement("INSERT INTO CLIENTE(NOME, CPF, EMAIL) VALUES(?, ?, ?)");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getCpf());
		statement.setString(3, cliente.getEmail());
		statement.execute(); //executando o comando
		statement.close(); 
		
		//fechando a conexão
		connection.close();
	}


	@Override
	public void update(Cliente cliente) throws Exception {
		
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("UPDATE CLIENTE SET  NOME =?, CPF=?, EMAIL=? WHERE IDCLIENTE =?");
		statement.setString(1, cliente.getNome());
		statement.setString(2, cliente.getEmail());
		statement.setString(3, cliente.getCpf());
		statement.setInt(4, cliente.getIdCliente());
		statement.execute(); //executando o comando
		statement.close(); 
		
		connection.close();
	}

	@Override
	public void delete(Cliente cliente) throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("DELETE FROM CLIENTE WHERE IDCLIENTE =?");
		
		statement.setInt(1, cliente.getIdCliente());
		statement.execute(); //executando o comando
		statement.close(); 
		
		connection.close();
		
	}

	@Override
	public List<Cliente> findAll(Cliente cliente) throws Exception {
Connection connection = ConnectionFactory.getConnection();
		
		PreparedStatement statement = connection.prepareStatement
				("SELECT * FROM CLIENTE");
		
		//Executando a consulta e capturando os registros obtidos
		//atraves do componente ResultSet
		ResultSet result = statement.executeQuery();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		//percorrer cada cliente obtido do banco de dados
		while(result.next()) {
			
			//criando um cliente..
			Cliente c = new Cliente();
			
			c.setIdCliente(result.getInt("IDCLIENTE"));
			c.setNome(result.getString("NOME"));
			c.setEmail(result.getString("EMAIL"));
			c.setCpf(result.getString("CPF"));
			
			//adicionar o cliente na lista
			lista.add(c);
		}
		
		result.close();
		statement.close();
		connection.close();
		
		return lista; //retornando a lista de clientes

	}

}
