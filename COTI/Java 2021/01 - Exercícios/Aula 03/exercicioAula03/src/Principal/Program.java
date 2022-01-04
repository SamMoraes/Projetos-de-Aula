package Principal;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Profissional;
import entities.Servico;
import inputs.ProfissionalInput;
import inputs.ServicoInput;
import repositories.ProfissionalRepository;

public class Program {

	public static void main(String[] args) {

		try {
			
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n GERADOR DE DADOS DOS SERVIÇOS DOS PROFISSIONAIS");
		
		//CAPTURAR OS DADOS DO PROFISSIONAL
		Profissional p = ProfissionalInput.inputProfissional();
		
		//CAPTURAR OS DADOS DOS SERVIÇOS
		p.setServico(new ArrayList<Servico>());
		
		System.out.println("INSIRA A QUANTIDADE DE SERVIÇOS QUE DESAJA CADASTRAR: ");
		Integer qtd = Integer.parseInt(scanner.nextLine());
		
			for (int i=1; i<=qtd; i++) {
				System.out.println("\n" + i + " serviço: ");
				Servico s = ServicoInput.inputServico();
				
				//associando serviço ao profissional
				p.getServico().add(s);
			}
		
		//INICALIZANDO A EXPORTAÇÃO DOS DADOS
		ProfissionalRepository pr = new ProfissionalRepository();	
		pr.gravarArquivo(p);
		System.out.println("\nARQUIVO GERADO COM SUCESSO NO FORMATO TXT.");
		
		} catch (Exception e) {
			System.out.println("\nERRO: " + e.getMessage());
		}

	}

}
