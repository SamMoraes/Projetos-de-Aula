package principal;

import javax.swing.JOptionPane;

import abstractions.ResumoConta;
import entities.Conta;
import enums.TipoConta;
import services.ResumoContaDetalhada;
import services.ResumoContaSimples;

public class Program {

	public static void main(String[] args) {

		try {

			Conta conta = new Conta();

			conta.setIdConta(Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID da Conta:")));
			conta.setNome(JOptionPane.showInputDialog("Entre com o Nome da Conta:"));
			conta.setValor(Double.parseDouble(JOptionPane.showInputDialog("Entre com o Valor da Conta:")));

			Integer tipoConta = Integer.parseInt(JOptionPane.showInputDialog("Informe (1) Receita ou (2) Despesa:"));

			if (tipoConta == 1) {
				conta.setTipo(TipoConta.Receita);
			} else if (tipoConta == 2) {
				conta.setTipo(TipoConta.Despesa);
			}

			Integer tipoImpressao = Integer
					.parseInt(JOptionPane.showInputDialog("(1) Impressão Simples, (2) Impressão detalhada: "));

			ResumoConta resumoConta = null; // vazio

			switch (tipoImpressao) {

			case 1:
				resumoConta = new ResumoContaSimples(); //POLIMORFISMO!
				break;

			case 2:
				resumoConta = new ResumoContaDetalhada(); //POLIMORFISMO!
				break;
			}
			
			//imprimindo os dados da conta
			resumoConta.imprimirDados(conta);

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
	}

}





