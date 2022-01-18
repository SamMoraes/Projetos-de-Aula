package repositories;

import java.io.FileWriter;
import java.util.HashMap;

import org.json.simple.JSONObject;

import abstracts.EmpresaRepository;
import entities.Empresa;

public class EmpresaRepositoryJSON extends EmpresaRepository{

	@Override
	public void exportarDados(Empresa empresa) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("idEmpresa", empresa.getIdEmpresa());
		map.put("nomeFantasia", empresa.getNomeFantasia());
		map.put("razaoSocial", empresa.getRazaoSocial());
		map.put("CNPJ", empresa.getCnpj());
		
		JSONObject json = new JSONObject(map);
		
		FileWriter fw = new FileWriter(PATH + "empresa.json");
		fw.write(json.toString());
		fw.flush();
		fw.close();
		
		
	}

}
