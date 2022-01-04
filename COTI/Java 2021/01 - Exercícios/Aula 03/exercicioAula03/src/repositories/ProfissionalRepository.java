package repositories;

import java.io.File;
import java.io.PrintWriter;

import entities.Profissional;
import entities.Servico;

public class ProfissionalRepository {

	public void gravarArquivo(Profissional p) throws Exception{
		
		PrintWriter pw = new PrintWriter(new File("c:\\temp\\profissional.txt"));
		
		//EXPORTANDO DADOS DO PROFISSIONAL
		pw.write("\nDADOS DO PROFISSIONAL\n");
		
		pw.write("\nID DO PROFISSIONAL........: " + p.getIdProfissional());
		pw.write("\nNOME DO PROFISSIONAL......: " + p.getNome());
		pw.write("\nCPF DO PROFISSIONAL.......: " + p.getCpf());
		pw.write("\nTELEFONE DO PROFISSIONAL..: " + p.getTelefone());
		
		//EXPORTANDO DADOS DOS SERVIÇOS
		pw.write("\n\nDADOS DOS SERVIÇOS\n");
		
		for(Servico s : p.getServico()) {
			
			pw.write("\t\nID DO SERVIÇO.............: " + s.getIdServico());
			pw.write("\n\tNOME DO SERVIÇO...........: " + s.getNome());
			pw.write("\t\nDESCRIÇÃO DO SERVIÇO......: " + s.getDescricao());
			pw.write("\t\nPREÇO DO SERVIÇO..........: " + s.getPreco());
		}
		
		pw.flush();
		pw.close();
		
	}
}
