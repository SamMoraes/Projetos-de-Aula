package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.interfaces.ITarefaRepository;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

@Controller
public class TarefasRelatorioController {

	@Autowired
	private ITarefaRepository tarefaRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	// Método para abrir (rota) a página de edicao
		@RequestMapping(value = "/tarefas-relatorio")
		public ModelAndView relatorio() {

			ModelAndView modelAndView = new ModelAndView("tarefas-relatorio");
			return modelAndView;
		}
}
