package persistence;

import java.io.File;
import java.io.PrintWriter;

import entities.Cliente;

public class ClientePersistence {

	// método para receber os dados de um cliente e grava-los em arquivo
	public void exportarDados(Cliente cliente) {

		try { //tentativa
			
			//criando o arquivo
			PrintWriter print = new PrintWriter(new File("C:\\Git\\Projetos-de-Aula\\COTI\\Java 2021\\projetoAula01\\Arquivo\\cliente.txt"));
			
			//escrevendo no arquivo
			print.write("\nDADOS DO CLIENTE:");
			print.write("\n\tId........: " + cliente.getIdCliente());
			print.write("\n\tNome......: " + cliente.getNome());
			print.write("\n\tEmail.....: " + cliente.getEmail());
			print.write("\n\tTelefone..: " + cliente.getTelefone());
			
			print.flush(); //salvar o arquivo
			print.close(); //fechar o arquivo
		}
		catch(Exception e) { //captura do erro
			//imprimir o log de erro
			e.printStackTrace();
		}		
	}
}
