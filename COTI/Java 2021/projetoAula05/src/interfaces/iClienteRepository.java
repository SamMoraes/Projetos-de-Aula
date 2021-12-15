package interfaces;

import java.util.List;

import entities.Cliente;

public interface iClienteRepository {
	
	void create(Cliente cliente) throws Exception;
	
	void update(Cliente cliente) throws Exception;
	
	void delete(Cliente cliente) throws Exception;
	
	List<Cliente> findAll(Cliente cliente) throws Exception;
	

}
