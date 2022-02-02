package br.com.cotiinformatica.reports;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;

public class TarefaReportPdf {

	/*
	 * M�todo para retornar um relat�rio de tarefas em formato PDF
	 */
	public ByteArrayInputStream create(Date dataMin, Date dataMax, Usuario usuario, List<Tarefa> tarefas)
			throws Exception {

		// criando o documento PDF
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document, out);

		// escrevendo o relat�rio
		document.open();

		// logotipo
		Image logo = Image.getInstance(new URL("https://www.cotiinformatica.com.br/imagens/logo-coti-informatica.png"));
		document.add(logo);

		// t�tulo do relat�rio
		document.add(new Paragraph("Relat�rio de Tarefas", new Font(FontFamily.HELVETICA, 24)));
		document.add(new Paragraph("\n"));

		// Dados do usu�rio que gerou o relat�rio
		document.add(new Paragraph("Nome do usu�rio: " + usuario.getNome()));
		document.add(new Paragraph("Email: " + usuario.getEmail()));
		document.add(new Paragraph("\n"));

		// Per�odo de consulta do relat�rio
		document.add(new Paragraph("Data de in�cio: " + new SimpleDateFormat("dd/MM/yyyy").format(dataMin)));
		document.add(new Paragraph("Data de t�rmino: " + new SimpleDateFormat("dd/MM/yyyy").format(dataMax)));
		document.add(new Paragraph("\n"));

		// desenhando uma tabela para imprimir os dados das tarefas:
		PdfPTable table = new PdfPTable(5); // 5 colunas!
		table.setWidthPercentage(100); // 100% de largura

		// cabe�alhos da tabela
		table.addCell("NOME DA TAREFA");
		table.addCell("DATA");
		table.addCell("HORA");
		table.addCell("PRIORIDADE");
		table.addCell("DESCRI��O");

		// imprimir o conteudo da tabela
		for (Tarefa t : tarefas) {

			table.addCell(t.getNome());
			table.addCell(new SimpleDateFormat("dd/MM/yyyy").format(t.getData()));
			table.addCell(t.getHora());
			table.addCell(t.getPrioridade());
			table.addCell(t.getDescricao());
		}

		// adicionar a tabela ao documento PDF
		document.add(table);

		document.add(new Paragraph("Quantidade de tarefas: " + tarefas.size()));

		// fechando o documento
		document.close();
		writer.close();

		// retornando o documento PDF
		return new ByteArrayInputStream(out.toByteArray());
	}
}
