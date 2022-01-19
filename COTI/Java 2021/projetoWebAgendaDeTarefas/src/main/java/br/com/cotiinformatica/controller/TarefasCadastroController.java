package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.interfaces.ITarefaRepository;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;

@Controller
public class TarefasCadastroController {

	@Autowired
	private ITarefaRepository tarefaRepository;
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	// Método para abrir (rota) a página de cadastro
	@RequestMapping(value = "/tarefas-cadastro")
	public ModelAndView cadastro() {

		ModelAndView modelAndView = new ModelAndView("tarefas-cadastro");
		return modelAndView;
	}

}





