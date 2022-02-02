package br.com.cotiinformatica.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Tarefa;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.helpers.DateHelper;
import br.com.cotiinformatica.interfaces.ITarefaRepository;
import br.com.cotiinformatica.models.TarefaConsultaModel;

@Controller
public class TarefasConsultaController {

	@Autowired
	private ITarefaRepository tarefaRepository;

	// M�todo para abrir (rota) a p�gina de consulta
	@RequestMapping(value = "/tarefas-consulta")
	public ModelAndView consulta() {

		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");
		modelAndView.addObject("model", new TarefaConsultaModel());

		return modelAndView;
	}

	// M�todo para receber o SUBMIT POST da p�gina (formul�rio)
	@RequestMapping(value = "post-tarefas-consulta", method = RequestMethod.POST)
	public ModelAndView postConsulta(TarefaConsultaModel model, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");

		// realizando a valida��o dos campos
		boolean isValid = true;

		if (model.getDataMin().trim().length() == 0) {
			modelAndView.addObject("erro_dataMin", "Por favor, informe a data de in�cio.");
			isValid = false;
		}

		if (model.getDataMax().trim().length() == 0) {
			modelAndView.addObject("erro_dataMax", "Por favor, informe a data de t�rmino.");
			isValid = false;
		}

		try {

			if (isValid) {

				// obtendo o usu�rio autenticado no sistema (sess�o)
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

				// capturando as datas preenchidas na p�gina
				Date dataMin = DateHelper.toDate(model.getDataMin());
				Date dataMax = DateHelper.toDate(model.getDataMax());

				// consultando os dados no banco
				modelAndView.addObject("tarefas",
						tarefaRepository.findByDatas(dataMin, dataMax, usuario.getIdUsuario()));
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		modelAndView.addObject("model", model);
		return modelAndView;
	}
	
	@RequestMapping(value = "/tarefas-exclusao")
	public ModelAndView exclusao(int id, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");
		modelAndView.addObject("model", new TarefaConsultaModel());
		
		try {
			
			//buscar o usu�rio autenticado no sistema..
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//buscar a tarefa no banco de dados atraves do id..
			Tarefa tarefa = tarefaRepository.findById(id, usuario.getIdUsuario());
			tarefa.setUsuario(usuario);
			
			//excluindo a tarefa
			tarefaRepository.delete(tarefa);
			
			modelAndView.addObject("mensagem_sucesso", "Tarefa " + tarefa.getNome() + ", exclu�da com sucesso.");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}
}
