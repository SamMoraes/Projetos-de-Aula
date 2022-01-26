package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.interfaces.ITarefaRepository;
import br.com.cotiinformatica.models.TarefaEdicaoModel;

@Controller
public class TarefasEdicaoController {

	@Autowired
	private ITarefaRepository tarefaRepository;

	// Método para abrir (rota) a página de edicao
	@RequestMapping(value = "/tarefas-edicao")
	public ModelAndView edicao() {

		ModelAndView modelAndView = new ModelAndView("tarefas-edicao");
		modelAndView.addObject("model", new TarefaEdicaoModel());
		return modelAndView;
	}
}





