package principal;

import javax.swing.JOptionPane;

import entities.Produto;
import enums.StatusProduto;
import interfaces.IProdutoRepository;
import repositories.ProdutoRepositoryCSV;
import repositories.ProdutoRepositoryTXT;

public class Program {

	public static void main(String[] args) {

		try {
			
			//criando uma variável de instância para Produto
			Produto produto = new Produto();
			
			produto.setIdProduto(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID do produto:")));
			produto.setNome(JOptionPane.showInputDialog("Entre com o nome do produto:"));
			produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Entre com o preço do produto:")));
			produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Entre com a quantidade do produto:")));
			
			//definindo o status do produto (ENUM)
			if(produto.getQuantidade() > 0) {
				produto.setStatus(StatusProduto.Disponivel);
			}
			else {
				produto.setStatus(StatusProduto.Esgotado);
			}
			
			//criando uma variavel para a interface, sem inicializa-la
			IProdutoRepository produtoRepository = null; //vazio!
			
			String opcao = JOptionPane.showInputDialog("Informe TXT ou CSV para exportar os dados:");
			
			//fazendo o polimorfismo..
			switch(opcao) {
			
				case "TXT": 
					produtoRepository = new ProdutoRepositoryTXT(); //POLIMORFISMO!
					break;
				
				case "CSV":
					produtoRepository = new ProdutoRepositoryCSV(); //POLIMORFISMO!
					break;
			}
			
			//gerando o arquivo
			produtoRepository.exportarDados(produto);

			//exibir mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
			
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}

}


