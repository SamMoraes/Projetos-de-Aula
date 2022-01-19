package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.interfaces.ITarefaRepository;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

@Controller
public class TarefasConsultaController {

	@Autowired
	private ITarefaRepository tarefaRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/tarefas-consulta")
	public ModelAndView consulta() {
		
		ModelAndView modelAndView = new ModelAndView("tarefas-consulta");
		
		return modelAndView;
	}
}
