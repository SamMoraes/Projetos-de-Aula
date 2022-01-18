package repositories;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import abstracts.EmpresaRepository;
import entities.Empresa;

public class EmpresaRepositoryXML extends EmpresaRepository{

	@Override
	public void exportarDados(Empresa empresa) throws Exception {
		
		criarDiretorio();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document d = db.newDocument();
		
		Element raiz = d.createElement("EMPRESA");
		d.appendChild(raiz);
		
		Element idProduto = d.createElement("IDEMPRESA");
		idProduto.setTextContent(empresa.getIdEmpresa().toString());
		raiz.appendChild(idProduto);
		
		Element nomeFantasia = d.createElement("NOMEFANTASIA");
		nomeFantasia.setTextContent(empresa.getNomeFantasia());
		raiz.appendChild(nomeFantasia);
		
		Element razaoSocial = d.createElement("RAZAOSOCIAL");
		razaoSocial.setTextContent(empresa.getRazaoSocial());
		raiz.appendChild(razaoSocial);
		
		Element cnpj = d.createElement("RAZAOSOCIAL");
		cnpj.setTextContent(empresa.getCnpj());
		raiz.appendChild(cnpj);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		DOMSource ds = new DOMSource(d);
		
		StreamResult sr = new StreamResult(new File(PATH + "empresa.xml"));
		t.transform(ds, sr);
		
		
	}

	
}
